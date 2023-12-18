package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.start.site.extension.dependency.taotaocloud.common.yml.application.ApplicationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.common.yml.application.ApplicationYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.common.yml.application.ApplicationYmlServiceContainer;
import io.spring.start.site.extension.dependency.taotaocloud.common.utils.YmlDataUtils;

public class TaoTaoCloudApplicationYmlFileCustomizer implements ApplicationYmlFileCustomizer {

    @Override
    public void customize(ApplicationYmlFile applicationYmlFile) {
        ApplicationYmlServiceContainer applicationYmlServiceContainer = applicationYmlFile.getApplicationYmlServiceContainer();

        applicationYmlServiceContainer.getServices().put("application-basic", YmlDataUtils.basicData());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
