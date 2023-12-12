package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.buildsystem.maven.MavenBuild;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.contributor.MultipleResourcesProjectContributor;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.metadata.InitializrMetadata;
import org.springframework.context.annotation.Bean;

@ProjectGenerationConfiguration
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
    // @Bean
    // @ConditionalOnRequestedDependency("sca-oss")
    // public OSSDemoCodeContributor ossContributor() {
    //     return new OSSDemoCodeContributor(description, templateRenderer);
    // }

    // 添加README.md
    @Bean
    public ProjectContributor readmeProjectContributor() {
        return new MultipleResourcesProjectContributor("contributor/readme");
    }

    /**
     * 模块化的贡献者
     *
     * @return
     */
    @Bean
    public ProjectContributor mouduleContributor() {
        return new ModuleContributor(projectDescription, indentingWriterFactory, initializrMetadata);
    }

    /**
     * 项目父结构下的pom.xml文件生成器 <br/>
     * {@link MavenBuild} 没有module标签功能; 并且parent写死为spring-boot-dependencies
     *
     * @param build
     * @return
     */
    @Bean
    public CustomMavenBuildProjectContributor customMavenBuildProjectContributor(ModuleMavenBuild build) {
        return new CustomMavenBuildProjectContributor(build, indentingWriterFactory);
    }
}