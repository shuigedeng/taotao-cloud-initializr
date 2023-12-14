package io.spring.start.site.extension.dependency.taotaocloud.bootstrap;

import io.spring.start.site.extension.dependency.taotaocloud.yml.YmlFile;

public class BootstrapYmlFile extends YmlFile {

    private final BootstrapYmlServiceContainer bootstrapYmlServiceContainer = new BootstrapYmlServiceContainer();

    public BootstrapYmlServiceContainer getApplicationYmlServiceContainer() {
        return bootstrapYmlServiceContainer;
    }
}
