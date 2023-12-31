package io.spring.start.site.extension.dependency.taotaocloud.dingtalk;

import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.ApplicationConfigurationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.ApplicationYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.ApplicationYmlServiceContainer;

import java.util.LinkedList;
import java.util.List;

public class DingTalkApplicationYmlFileCustomizer implements ApplicationYmlFileCustomizer {
    @Override
    public void customize(ApplicationConfigurationYmlFile applicationYmlFile) {
        ApplicationYmlServiceContainer applicationYmlServiceContainer = applicationYmlFile.getApplicationYmlServiceContainer();
        List<String> data = new LinkedList<>();
        data.add("    ding-talk:");
        data.add("      request:");
        data.add("        enabled: true");
        data.add("        types:");
        data.add("          - redis");
        data.add("          - logger");
        data.add("          - kafka");

        applicationYmlServiceContainer.getServices().put("dingtalk", data);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
