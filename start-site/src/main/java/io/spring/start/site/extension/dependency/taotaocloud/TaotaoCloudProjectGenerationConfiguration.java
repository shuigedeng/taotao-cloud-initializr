package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.metadata.InitializrMetadata;

@ProjectGenerationConfiguration
public class TaotaoCloudProjectGenerationConfiguration {
    private final InitializrMetadata metadata;
    private final ProjectDescription description;
    private final IndentingWriterFactory indentingWriterFactory;
    private final TemplateRenderer templateRenderer;
    public TaotaoCloudProjectGenerationConfiguration(InitializrMetadata metadata,
                                                     ProjectDescription description,
                                                     IndentingWriterFactory indentingWriterFactory,
                                                     TemplateRenderer templateRenderer) {
        this.metadata = metadata;
        this.description = description;
        this.indentingWriterFactory = indentingWriterFactory;
        this.templateRenderer = templateRenderer;
    }
    // @Bean
    // @ConditionalOnRequestedDependency("sca-oss")
    // public OSSDemoCodeContributor ossContributor() {
    //     return new OSSDemoCodeContributor(description, templateRenderer);
    // }
}