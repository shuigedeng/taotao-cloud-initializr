package io.spring.start.site.extension.dependency.taotaocloud.common.yml.application;

import io.spring.start.site.extension.dependency.taotaocloud.common.yml.YmlFile;

public class ApplicationYmlFile extends YmlFile {

    private final ApplicationYmlServiceContainer applicationYmlServiceContainer = new ApplicationYmlServiceContainer();

    public ApplicationYmlServiceContainer getApplicationYmlServiceContainer() {
        return applicationYmlServiceContainer;
    }
}
