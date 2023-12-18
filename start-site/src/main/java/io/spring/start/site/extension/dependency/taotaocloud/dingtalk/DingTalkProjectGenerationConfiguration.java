package io.spring.start.site.extension.dependency.taotaocloud.dingtalk;

import io.spring.initializr.generator.condition.ConditionalOnRequestedDependency;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.start.site.extension.dependency.taotaocloud.common.condition.ConditionalOnRequestedTaoTaoCloudDependency;
import org.springframework.context.annotation.Bean;

@ProjectGenerationConfiguration
@ConditionalOnRequestedTaoTaoCloudDependency(value = "taotao-cloud")
@ConditionalOnRequestedDependency("taotao-cloud-starter-dingtalk")
public class DingTalkProjectGenerationConfiguration {
    private final InitializrMetadata initializrMetadata;
    private final ProjectDescription projectDescription;
    private final IndentingWriterFactory indentingWriterFactory;
    private final TemplateRenderer templateRenderer;

    public DingTalkProjectGenerationConfiguration(InitializrMetadata metadata,
                                                  ProjectDescription description,
                                                  IndentingWriterFactory indentingWriterFactory,
                                                  TemplateRenderer templateRenderer) {
        this.initializrMetadata = metadata;
        this.projectDescription = description;
        this.indentingWriterFactory = indentingWriterFactory;
        this.templateRenderer = templateRenderer;
    }

    @Bean
    public DingTalkApplicationYmlFileCustomizer dingTalkApplicationYmlFileCustomizer(){
        return new DingTalkApplicationYmlFileCustomizer();
    }
}


