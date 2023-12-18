package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap.BootstrapYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap.BootstrapYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap.BootstrapYmlServiceContainer;
import io.spring.start.site.extension.dependency.taotaocloud.common.utils.YmlDataUtils;

public class TaoTaoCloudBootstrapYmlFileCustomizer implements BootstrapYmlFileCustomizer {
    @Override
    public void customize(BootstrapYmlFile bootstrapYmlFile) {
        BootstrapYmlServiceContainer applicationYmlServiceContainer = bootstrapYmlFile.getApplicationYmlServiceContainer();
        applicationYmlServiceContainer.add("bootstrap-basic", YmlDataUtils.basicData());
    }

    @Override
    public int getOrder() {
        return BootstrapYmlFileCustomizer.super.getOrder();
    }
}
