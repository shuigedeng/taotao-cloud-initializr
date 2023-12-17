package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlServiceContainer;
import io.spring.start.site.extension.dependency.taotaocloud.utils.YmlDataUtils;

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
