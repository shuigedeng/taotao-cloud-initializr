package io.spring.start.site.extension.dependency.taotaocloud.web;

import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.application.ApplicationYmlServiceContainer;
import io.spring.start.site.extension.dependency.taotaocloud.application.dev.ApplicationDevYmlFileCustomizer;

import java.util.LinkedList;
import java.util.List;

public class WebApplicationDevYmlFileCustomizer implements ApplicationDevYmlFileCustomizer {
    @Override
    public void customize(ApplicationYmlFile applicationYmlFile) {
        ApplicationYmlServiceContainer applicationYmlServiceContainer = applicationYmlFile.getApplicationYmlServiceContainer();
        List<String> data = new LinkedList<>();
        data.add("    web:");
        data.add("      request:");
        data.add("        enabled: true");
        data.add("        types:");
        data.add("          - redis");
        data.add("          - logger");
        data.add("          - kafka");
        data.add("      interceptor:");
        data.add("        doubt-api: true");
        data.add("        header: true");
        data.add("      filter:");
        data.add("        version: true");
        data.add("        tenant: true");
        data.add("        trace: true");
        data.add("        web-context: true");
        data.add("        report: true");
        data.add("        ping: true");

        applicationYmlServiceContainer.getServices().put("web-dev", data);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}