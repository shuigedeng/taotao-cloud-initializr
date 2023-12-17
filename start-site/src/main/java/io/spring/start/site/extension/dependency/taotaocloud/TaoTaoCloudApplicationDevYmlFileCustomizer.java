package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.application.dev.ApplicationDevYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.utils.YmlDataUtils;

import java.util.LinkedList;
import java.util.List;


public class TaoTaoCloudApplicationDevYmlFileCustomizer implements ApplicationDevYmlFileCustomizer {

    @Override
    public void customize(ApplicationYmlFile applicationYmlFile) {
        applicationYmlFile.getApplicationYmlServiceContainer().getServices().put("application-taotao-cloud-basic", YmlDataUtils.taotaoCloudBasicData());
    }

    @Override
    public int getOrder() {
        return ApplicationDevYmlFileCustomizer.super.getOrder();
    }
}


