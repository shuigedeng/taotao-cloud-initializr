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

package io.spring.start.site.extension.dependency.taotaocloud.bootstrap;

import io.spring.initializr.generator.container.docker.compose.ComposeService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * A container for {@linkplain ComposeService Docker Compose services}.
 *
 * @author Stephane Nicoll
 */
public class BootstrapYmlServiceContainer {

    private final Map<String, List<String>> services = new LinkedHashMap<>();

    /**
     * Specify if this container is empty.
     *
     * @return {@code true} if no service is registered
     */
    public boolean isEmpty() {
        return this.services.isEmpty();
    }

    /**
     * Specify if this container has a service customization with the specified
     * {@code name}.
     *
     * @param name the name of a service
     * @return {@code true} if a customization for a service with the specified
     * {@code name} exists
     */
    public boolean has(String name) {
        return this.services.containsKey(name);
    }

    /**
     * Add a {@link ComposeService} with the specified name and {@link Consumer} to
     * customize the object. If the service has already been added, the consumer can be
     * used to further tune the existing service configuration.
     *
     * @param name    the name of the service
     * @param service a {@link Consumer} to customize the {@link ComposeService}
     */
    public void add(String name, List<String> values) {
		services.put(name, values);
    }

    public Map<String, List<String>> getServices() {
        return services;
    }
}
