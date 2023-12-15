package io.spring.start.site.extension.dependency.taotaocloud.web;

import io.spring.initializr.generator.condition.ConditionalOnRequestedDependency;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.contributor.MultipleResourcesProjectContributor;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.start.site.extension.dependency.taotaocloud.TaoTaoCloudBootstrapYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.TaoTaoCloudGitIgnoreCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.TaoTaoCloudHelpDocumentCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.condition.ConditionalOnRequestedTaoTaoCloudDependency;
import io.spring.start.site.extension.dependency.taotaocloud.dingtalk.DingTalkApplicationYmlFileCustomizer;
import org.springframework.context.annotation.Bean;

//如果系统是gradle构建
//@ConditionalOnBuildSystem(GradleBuildSystem.ID)
//打包方式为war
//@ConditionalOnPackaging(WarPackaging.ID)
@ProjectGenerationConfiguration
@ConditionalOnRequestedTaoTaoCloudDependency(value = "taotao-cloud")
@ConditionalOnRequestedDependency(value = "taotao-cloud-starter-web")
public class WebProjectGenerationConfiguration {
    private final InitializrMetadata initializrMetadata;
    private final ProjectDescription projectDescription;
    private final IndentingWriterFactory indentingWriterFactory;
    private final TemplateRenderer templateRenderer;

    public WebProjectGenerationConfiguration(InitializrMetadata metadata,
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
     */
    @Bean
    //@ConditionalOnRequestedDependency("taotao-cloud-starter-web")
    public WebProjectContributor webProjectContributor(ProjectDescription description, TemplateRenderer templateRenderer) {
        return new WebProjectContributor(description, templateRenderer);
    }

    // 添加application.yml配置文件
    @Bean
    public WebApplicationYmlFileCustomizer webApplicationYmlFileCustomizer() {
        return new WebApplicationYmlFileCustomizer();
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


