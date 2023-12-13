package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.buildsystem.gradle.GradleBuildSystem;
import io.spring.initializr.generator.condition.ConditionalOnBuildSystem;
import io.spring.initializr.generator.condition.ConditionalOnPackaging;
import io.spring.initializr.generator.condition.ConditionalOnRequestedDependency;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.packaging.war.WarPackaging;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.metadata.InitializrMetadata;
import org.springframework.context.annotation.Bean;

@ProjectGenerationConfiguration
@ConditionalOnRequestedDependency("taotao-cloud-starter-web")
public class TaotaoCloudProjectGenerationConfiguration {
    private final InitializrMetadata initializrMetadata;
    private final ProjectDescription projectDescription;
    private final IndentingWriterFactory indentingWriterFactory;
    private final TemplateRenderer templateRenderer;

    public TaotaoCloudProjectGenerationConfiguration(InitializrMetadata metadata,
                                                     ProjectDescription description,
                                                     IndentingWriterFactory indentingWriterFactory,
                                                     TemplateRenderer templateRenderer) {
        this.initializrMetadata = metadata;
        this.projectDescription = description;
        this.indentingWriterFactory = indentingWriterFactory;
        this.templateRenderer = templateRenderer;
    }

    // 如果系统是gradle构建
    @ConditionalOnBuildSystem(GradleBuildSystem.ID)
// 打包方式为war
    @ConditionalOnPackaging(WarPackaging.ID)
    @Bean
    public DemoContributor fcsContributor(ProjectDescription description, TemplateRenderer templateRenderer) {
        return new DemoContributor(description, templateRenderer);
    }

    // 添加README.md
//    @Bean
//    public ProjectContributor readmeProjectContributor() {
//        return new MultipleResourcesProjectContributor("contributor/readme");
//    }

//    /**
//     * 模块化的贡献者
//     *
//     * @return
//     */
//    @Bean
//    public ProjectContributor mouduleContributor() {
//        return new ModuleContributor(projectDescription, indentingWriterFactory, initializrMetadata);
//    }
//
//    /**
//     * 项目父结构下的pom.xml文件生成器 <br/>
//     * {@link MavenBuild} 没有module标签功能; 并且parent写死为spring-boot-dependencies
//     *
//     * @param build
//     * @return
//     */
//    @Bean
//    public CustomMavenBuildProjectContributor customMavenBuildProjectContributor(ModuleMavenBuild build) {
//        return new CustomMavenBuildProjectContributor(build, indentingWriterFactory);
//    }
}
