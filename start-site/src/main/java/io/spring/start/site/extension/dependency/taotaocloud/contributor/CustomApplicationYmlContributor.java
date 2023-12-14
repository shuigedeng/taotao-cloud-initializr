package io.spring.start.site.extension.dependency.taotaocloud.contributor;

import io.spring.initializr.generator.project.contributor.SingleResourceProjectContributor;

public class CustomApplicationYmlContributor extends SingleResourceProjectContributor {
    public CustomApplicationYmlContributor() {
        this("classpath:configuration/application.yml");
    }

    public CustomApplicationYmlContributor(String resourcePattern) {
        super("src/main/resources/application.yml", resourcePattern);
    }
}