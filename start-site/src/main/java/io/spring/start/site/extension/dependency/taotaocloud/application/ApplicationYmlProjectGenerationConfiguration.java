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

package io.spring.start.site.extension.dependency.taotaocloud.application;

import io.spring.initializr.generator.io.IndentingWriterFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for generation of projects that depend on Docker Compose.
 *
 * @author Moritz Halbritter
 */
@Configuration(proxyBeanMethods = false)
class ApplicationYmlProjectGenerationConfiguration {

    @Bean
    ApplicationYmlFile applicationYmlFile(ObjectProvider<ApplicationYmlFileCustomizer> applicationYmlFileCustomizers) {
        ApplicationYmlFile applicationYmlFile = new ApplicationYmlFile();
        applicationYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(applicationYmlFile));
        return applicationYmlFile;
    }

    @Bean
    ApplicationYmlContributor applicationYmlContributor(IndentingWriterFactory indentingWriterFactory,
                                                              ApplicationYmlFile applicationYmlFile) {
        return new ApplicationYmlContributor(indentingWriterFactory, applicationYmlFile);
    }

}
