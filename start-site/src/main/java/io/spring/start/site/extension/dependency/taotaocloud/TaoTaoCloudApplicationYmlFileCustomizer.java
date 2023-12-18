package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.ApplicationConfigurationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.ApplicationYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.ApplicationYmlServiceContainer;
import io.spring.start.site.extension.dependency.taotaocloud.common.utils.YmlDataUtils;

public class TaoTaoCloudApplicationYmlFileCustomizer implements ApplicationYmlFileCustomizer {

    @Override
    public void customize(ApplicationConfigurationYmlFile applicationYmlFile) {
        ApplicationYmlServiceContainer applicationYmlServiceContainer = applicationYmlFile.getApplicationYmlServiceContainer();

        applicationYmlServiceContainer.getServices().put("application-basic", YmlDataUtils.basicData());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
