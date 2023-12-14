package io.spring.start.site.extension.dependency.taotaocloud.contributor;

import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class DemoProjectContributor implements ProjectContributor {
    private static final Logger logger = LoggerFactory.getLogger(DemoProjectContributor.class);

    private final ProjectDescription description;
    private final TemplateRenderer templateRenderer;
    private final String SOURCE_PATH = "src/main/java/";

    public DemoProjectContributor(ProjectDescription description, TemplateRenderer templateRenderer) {
        this.description = description;
        this.templateRenderer = templateRenderer;
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        Map<String, Object> data = new HashMap<>();
        String groupId = description.getGroupId();
        String artifactId = description.getArtifactId();
        data.put("groupId", groupId);
        data.put("artifactId", artifactId);

        logger.info("data======: {}", data);

        Path file = Files.createFile(projectRoot.resolve("README.md"));
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/controller/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/controller/DemoController.java"));
        String code = this.templateRenderer.render("code/DemoController.java", data);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file));
             PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            writer.println("README");
            codeWriter.print(code);
        }
    }
}
