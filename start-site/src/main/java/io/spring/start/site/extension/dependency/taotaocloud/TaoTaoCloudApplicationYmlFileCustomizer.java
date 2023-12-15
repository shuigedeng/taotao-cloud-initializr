package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlServiceContainer;

import java.util.LinkedList;
import java.util.List;

public class TaoTaoCloudApplicationYmlFileCustomizer implements ApplicationYmlFileCustomizer {
    @Override
    public void customize(ApplicationYmlFile applicationYmlFile) {
        ApplicationYmlServiceContainer applicationYmlServiceContainer = applicationYmlFile.getApplicationYmlServiceContainer();
        List<String> data = new LinkedList<>();
        data.add("taotao:");
        data.add("  cloud:");

        applicationYmlServiceContainer.getServices().put("taotao-cloud", data);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
