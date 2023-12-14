package io.spring.start.site.extension.dependency.taotaocloud.application;

import io.spring.start.site.extension.dependency.taotaocloud.yml.YmlFile;

public class ApplicationYmlFile extends YmlFile {

    private final ApplicationYmlServiceContainer applicationYmlServiceContainer = new ApplicationYmlServiceContainer();

    public ApplicationYmlServiceContainer getApplicationYmlServiceContainer() {
        return applicationYmlServiceContainer;
    }
}
