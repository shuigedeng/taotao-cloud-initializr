package io.spring.start.site.extension.dependency.taotaocloud.configuration.application;

import io.spring.start.site.extension.dependency.taotaocloud.configuration.ConfigurationYmlFile;

public class ApplicationConfigurationYmlFile extends ConfigurationYmlFile {

    private final ApplicationYmlServiceContainer applicationYmlServiceContainer = new ApplicationYmlServiceContainer();

    public ApplicationYmlServiceContainer getApplicationYmlServiceContainer() {
        return applicationYmlServiceContainer;
    }
}
