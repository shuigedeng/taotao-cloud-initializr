package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.buildsystem.Build;
import io.spring.initializr.generator.buildsystem.Dependency;
import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.generator.spring.build.BuildCustomizer;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 定义Maven/Gradle构建过程，如增加maven build插件
 */
public class SwaggerBuildCustomizer implements BuildCustomizer<Build>, ProjectContributor {

    private final ProjectDescription description;

    private final TemplateRenderer templateRenderer;

    private final String SOURCE_PATH = "src/main/java/";

    @Override
    public void customize(Build build) {
        if (build.dependencies().has("swagger")) {
            build.dependencies().add("swagger-ui", Dependency.withCoordinates("io.springfox", "springfox-swagger-ui")
                    .version(build.dependencies().get("swagger").getVersion()));
        }
    }

    @Override
    public int getOrder() {
        return BuildCustomizer.super.getOrder();
    }

    public SwaggerBuildCustomizer(ProjectDescription description, TemplateRenderer templateRenderer) {
        this.description =  description;
        this.templateRenderer = templateRenderer;
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        //log.info("swagger 扩展加载");
        Map<String, Object> data = new HashMap<>();

        String groupId = description.getGroupId();
        String artifactId = description.getArtifactId();
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        data.put("groupId", groupId);
        data.put("artifactId", artifactId);
        data.put("package", groupId + "." + artifactId);
       // data.put("description", description.getSwaggerParams().getDescription());
        //data.put("title", description.getSwaggerParams().getTitle());
        //data.put("version", description.getSwaggerParams().getVersion());

        Files.createDirectories(projectRoot.resolve(pre + "/config/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/config/SwaggerConfig.java"));
        String code = this.templateRenderer.render("SwaggerConfig.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }

}
