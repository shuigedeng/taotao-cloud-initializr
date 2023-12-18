package io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap;

import io.spring.start.site.extension.dependency.taotaocloud.configuration.ConfigurationYmlFile;

public class BootstrapConfigurationYmlFile extends ConfigurationYmlFile {

    private final BootstrapYmlServiceContainer bootstrapYmlServiceContainer = new BootstrapYmlServiceContainer();

    public BootstrapYmlServiceContainer getApplicationYmlServiceContainer() {
        return bootstrapYmlServiceContainer;
    }
}
