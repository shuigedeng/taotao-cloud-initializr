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

package io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap;

import io.spring.initializr.generator.container.docker.compose.ComposeFile;
import io.spring.initializr.generator.io.IndentingWriter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

/**
 * A {@link ComposeFile} writer for {@code compose.yaml}.
 *
 * @author Stephane Nicoll
 * @author Moritz Halbritter
 */
public class BootstrapYmlFileWriter {
    private static final Logger logger = LoggerFactory.getLogger(BootstrapYmlFileWriter.class);

    public void writeService(IndentingWriter writer, BootstrapConfigurationYmlFile bootstrapYmlFile) {
        BootstrapYmlServiceContainer bootstrapYmlServiceContainer = bootstrapYmlFile.getApplicationYmlServiceContainer();
        bootstrapYmlServiceContainer.getServices().forEach((key, values) -> {
            if (CollectionUtils.isEmpty(values)) {
                return;
            }
            values.stream()
                    .filter(StringUtils::isNotBlank)
                    .forEach(writer::println);
        });
    }
}
