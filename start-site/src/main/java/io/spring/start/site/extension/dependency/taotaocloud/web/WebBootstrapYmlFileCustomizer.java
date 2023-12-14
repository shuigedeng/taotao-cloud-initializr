package io.spring.start.site.extension.dependency.taotaocloud.web;

import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.BootstrapYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.BootstrapYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.BootstrapYmlServiceContainer;

import java.util.LinkedList;
import java.util.List;

public class WebBootstrapYmlFileCustomizer implements BootstrapYmlFileCustomizer {
    @Override
    public void customize(BootstrapYmlFile bootstrapYmlFile) {
        BootstrapYmlServiceContainer applicationYmlServiceContainer = bootstrapYmlFile.getApplicationYmlServiceContainer();
        List<String> data = new LinkedList<>();
        data.add("spring:");
        data.add("  cloud:");
        data.add("    circuitbreaker:");
        data.add("      sentinel:");
        data.add("        enabled: true");
        data.add("    loadbalancer:");
        data.add("      enabled: true");
        data.add("    nacos:");
        data.add("      discovery:");
        data.add("        server-addr: 192.168.10.220:8848");
        data.add("        metadata:");
        data.add("          version: ${taotaoCloudVersion}");
        data.add("          user.name: admin");
        data.add("          user.password: 123456");
        data.add("        group: TAOTAO_CLOUD_GROUP");
        data.add("        namespace: taotao-cloud-dev");
        data.add("        username: nacos");
        data.add("        password: nacos");
        data.add("        cluster-name: CQ");
        data.add("      config:");
        data.add("        enabled: true");
        data.add("        server-addr: 192.168.10.220:8848");
        data.add("        namespace: taotao-cloud-dev");
        data.add("        username: nacos");
        data.add("        password: nacos");
        data.add("        group: TAOTAO_CLOUD_GROUP");
        data.add("        file-extension: yml");
        data.add("        cluster-name: CQ");
        data.add("        refresh-enabled: true");
        data.add("    sentinel:");
        data.add("      enabled: true");
        data.add("      eager: true");

        applicationYmlServiceContainer.add("web-boot", data);
    }

    @Override
    public int getOrder() {
        return BootstrapYmlFileCustomizer.super.getOrder();
    }
}
