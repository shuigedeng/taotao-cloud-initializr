package io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap;

import io.spring.start.site.extension.dependency.taotaocloud.common.yml.YmlFile;

public class BootstrapYmlFile extends YmlFile {

    private final BootstrapYmlServiceContainer bootstrapYmlServiceContainer = new BootstrapYmlServiceContainer();

    public BootstrapYmlServiceContainer getApplicationYmlServiceContainer() {
        return bootstrapYmlServiceContainer;
    }
}
