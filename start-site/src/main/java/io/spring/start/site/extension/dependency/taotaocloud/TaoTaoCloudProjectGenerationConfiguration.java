package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.buildsystem.gradle.GradleBuildSystem;
import io.spring.initializr.generator.buildsystem.maven.MavenBuildSystem;
import io.spring.initializr.generator.condition.ConditionalOnBuildSystem;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.start.site.extension.dependency.taotaocloud.condition.ConditionalOnRequestedTaoTaoCloudDependency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//如果系统是gradle构建
//@ConditionalOnBuildSystem(GradleBuildSystem.ID)
//打包方式为war
//@ConditionalOnPackaging(WarPackaging.ID)
@ProjectGenerationConfiguration
@ConditionalOnRequestedTaoTaoCloudDependency(value = "taotao-cloud")
public class TaoTaoCloudProjectGenerationConfiguration {
    private final InitializrMetadata initializrMetadata;
    private final ProjectDescription projectDescription;
    private final IndentingWriterFactory indentingWriterFactory;
    private final TemplateRenderer templateRenderer;

    public TaoTaoCloudProjectGenerationConfiguration(InitializrMetadata metadata,
                                                     ProjectDescription description,
                                                     IndentingWriterFactory indentingWriterFactory,
                                                     TemplateRenderer templateRenderer) {
        this.initializrMetadata = metadata;
        this.projectDescription = description;
        this.indentingWriterFactory = indentingWriterFactory;
        this.templateRenderer = templateRenderer;
    }

    // 添加bootstrap.yml配置文件
    @Bean
    public TaoTaoCloudBootstrapYmlFileCustomizer taoTaoCloudBootstrapYmlFileCustomizer() {
        return new TaoTaoCloudBootstrapYmlFileCustomizer();
    }
    // 添加基础yml
    @Bean
    public TaoTaoCloudApplicationYmlFileCustomizer taoTaoCloudApplicationYmlFileCustomizer() {
        return new TaoTaoCloudApplicationYmlFileCustomizer();
    }
    @Bean
    public TaoTaoCloudApplicationDevYmlFileCustomizer taoTaoCloudApplicationDevYmlFileCustomizer() {
        return new TaoTaoCloudApplicationDevYmlFileCustomizer();
    }
    @Bean
    public TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapDevYmlFileCustomizer taoTaoCloudBootstrapDevYmlFileCustomizer(){
        return new TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapDevYmlFileCustomizer();
    }
    @Bean
    public TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapLocalYmlFileCustomizer taoTaoCloudBootstrapLocalYmlFileCustomizer(){
        return new TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapLocalYmlFileCustomizer();
    }
    @Bean
    public TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapPreYmlFileCustomizer taoTaoCloudBootstrapPreYmlFileCustomizer(){
        return new TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapPreYmlFileCustomizer();
    }
    @Bean
    public TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapProYmlFileCustomizer taoTaoCloudBootstrapProYmlFileCustomizer(){
        return new TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapProYmlFileCustomizer();
    }
    @Bean
    public TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapSitYmlFileCustomizer taoTaoCloudBootstrapSitYmlFileCustomizer(){
        return new TaoTaoCloudBootstrapEnvYmlFileCustomizers.TaoTaoCloudBootstrapSitYmlFileCustomizer();
    }

    //**********************************

    // 添加README.md
    @Bean
    public TaoTaoCloudMultipleResourcesProjectContributor taoTaoCloudMultipleResourcesProjectContributor() {
        return new TaoTaoCloudMultipleResourcesProjectContributor("contributor/readme");
    }
    //添加ignore
    @Bean
    public TaoTaoCloudGitIgnoreCustomizer taoTaoCloudGitIgnoreCustomizer() {
        return new TaoTaoCloudGitIgnoreCustomizer();
    }
    //添加帮助文档
    @Bean
    public TaoTaoCloudHelpDocumentCustomizer taoTaoCloudHelpDocumentCustomizer(MustacheTemplateRenderer templateRenderer) {
        return new TaoTaoCloudHelpDocumentCustomizer(templateRenderer);
    }

    @Bean
    @ConditionalOnBuildSystem(GradleBuildSystem.ID)
    public TaoTaoCloudGradleBuildCustomizer taoTaoCloudGradleBuildCustomizer() {
        return new TaoTaoCloudGradleBuildCustomizer();
    }

    @Bean
    @ConditionalOnBuildSystem(MavenBuildSystem.ID)
    public TaoTaoCloudMavenBuildCustomizer taoTaoCloudMavenBuildCustomizer() {
        return new TaoTaoCloudMavenBuildCustomizer();
    }

    @Bean
    public TaoTaoCloudMainSourceCodeCustomizer taoTaoCloudMainSourceCodeCustomizer() {
        return new TaoTaoCloudMainSourceCodeCustomizer();
    }

    @Bean
    public TaoTaoCloudServletInitializerCustomizer taoTaoCloudServletInitializerCustomizer() {
        return new TaoTaoCloudServletInitializerCustomizer();
    }

    @Bean
    public TaoTaoCloudInitializrMetadataCustomizer taoTaoCloudInitializrMetadataCustomizer() {
        return new TaoTaoCloudInitializrMetadataCustomizer();
    }


}


