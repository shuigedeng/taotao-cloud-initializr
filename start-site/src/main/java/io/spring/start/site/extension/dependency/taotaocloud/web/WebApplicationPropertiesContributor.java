package io.spring.start.site.extension.dependency.taotaocloud.web;

import io.spring.initializr.generator.spring.configuration.ApplicationPropertiesContributor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WebApplicationPropertiesContributor extends ApplicationPropertiesContributor {
    @Override
    public void contribute(Path projectRoot) throws IOException {
        super.contribute(projectRoot);

        Path output = projectRoot.resolve("src/main/resources/application.properties");

        Files.writeString(output, "taotao.cloud.web.enabled: true");
    }

}
