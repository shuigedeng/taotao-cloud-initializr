/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.start.site.extension.dependency.taotaocloud.configuration.application;

import io.spring.initializr.generator.container.docker.compose.ComposeFile;
import io.spring.initializr.generator.io.IndentingWriter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * A {@link ComposeFile} writer for {@code compose.yaml}.
 *
 * @author Stephane Nicoll
 * @author Moritz Halbritter
 */
public class ApplicationYmlFileWriter {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationYmlFileWriter.class);

    public void writeService(IndentingWriter writer, ApplicationConfigurationYmlFile applicationYmlFile) {
        ApplicationYmlServiceContainer applicationYmlServiceContainer = applicationYmlFile.getApplicationYmlServiceContainer();
        Map<String, List<String>> services = applicationYmlServiceContainer.getServices();
        if (CollectionUtils.isEmpty(services)) {
            return;
        }

        for (Map.Entry<String, List<String>> stringListEntry : services.entrySet()) {
            List<String> values = stringListEntry.getValue();
            if (!CollectionUtils.isEmpty(values)) {
                values.stream()
                        .filter(StringUtils::isNotBlank)
                        .forEach(writer::println);
            }

        }
    }
}
