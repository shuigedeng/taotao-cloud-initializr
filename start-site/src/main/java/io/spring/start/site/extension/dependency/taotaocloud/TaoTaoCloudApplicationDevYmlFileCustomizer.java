package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.ApplicationConfigurationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.dev.ApplicationDevYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.common.utils.YmlDataUtils;


public class TaoTaoCloudApplicationDevYmlFileCustomizer implements ApplicationDevYmlFileCustomizer {

    @Override
    public void customize(ApplicationConfigurationYmlFile applicationYmlFile) {
        applicationYmlFile.getApplicationYmlServiceContainer().getServices().put("application-taotao-cloud-basic", YmlDataUtils.taotaoCloudBasicData());
    }

    @Override
    public int getOrder() {
        return ApplicationDevYmlFileCustomizer.super.getOrder();
    }
}


