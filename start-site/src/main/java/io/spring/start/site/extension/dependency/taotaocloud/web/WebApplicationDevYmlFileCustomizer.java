package io.spring.start.site.extension.dependency.taotaocloud.web;

import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.ApplicationConfigurationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.ApplicationYmlServiceContainer;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.application.dev.ApplicationDevYmlFileCustomizer;

import java.util.LinkedList;
import java.util.List;

public class WebApplicationDevYmlFileCustomizer implements ApplicationDevYmlFileCustomizer {
    @Override
    public void customize(ApplicationConfigurationYmlFile applicationYmlFile) {
        ApplicationYmlServiceContainer applicationYmlServiceContainer = applicationYmlFile.getApplicationYmlServiceContainer();
        List<String> data = new LinkedList<>();
        data.add("    web:");
        data.add("      request:");
        data.add("        enabled: true");
        data.add("        types:");
        data.add("          - redis");
        data.add("          - logger");
        data.add("          - kafka");

        applicationYmlServiceContainer.getServices().put("web-dev", data);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
