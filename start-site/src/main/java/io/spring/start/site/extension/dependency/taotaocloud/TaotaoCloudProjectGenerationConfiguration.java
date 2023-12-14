package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.contributor.MultipleResourcesProjectContributor;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.start.site.extension.dependency.taotaocloud.web.*;
import org.springframework.context.annotation.Bean;

@ProjectGenerationConfiguration
// 如果系统是gradle构建
//     @ConditionalOnBuildSystem(GradleBuildSystem.ID)
// // 打包方式为war
//     @ConditionalOnPackaging(WarPackaging.ID)
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


    /**
     * 添加controller service mapper
     *
     * @return
     */
    @Bean
    //@ConditionalOnRequestedDependency("taotao-cloud-starter-web")
    public WebProjectContributor webProjectContributor(ProjectDescription description, TemplateRenderer templateRenderer) {
        return new WebProjectContributor(description, templateRenderer);
    }

    // 添加README.md
    @Bean
    public ProjectContributor readmeProjectContributor() {
        return new MultipleResourcesProjectContributor("contributor/readme");
    }

    // 添加application.yml配置文件
    @Bean
    public WebApplicationYmlFileCustomizer webApplicationYmlFileCustomizer() {
        return new WebApplicationYmlFileCustomizer();
    }

    // 添加bootstrap.yml配置文件
    @Bean
    public WebBootstrapYmlFileCustomizer webBootstrapYmlFileCustomizer() {
        return new WebBootstrapYmlFileCustomizer();
    }


    // 添加application.properties文件
    @Bean
    public WebApplicationPropertiesContributor webApplicationPropertiesContributor() {
        return new WebApplicationPropertiesContributor();
    }

    // 主类添加注解
    @Bean
    public WebMainApplicationTypeCustomizer webMainApplicationTypeCustomizer(ProjectDescription description, TemplateRenderer templateRenderer) {
        return new WebMainApplicationTypeCustomizer(description, templateRenderer);
    }
}
