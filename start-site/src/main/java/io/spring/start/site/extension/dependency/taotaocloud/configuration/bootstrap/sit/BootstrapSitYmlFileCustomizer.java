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

package io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap.sit;

import io.spring.initializr.generator.container.docker.compose.ComposeFile;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap.BootstrapConfigurationYmlFile;
import org.springframework.core.Ordered;

/**
 * Callback for customizing a project's {@link ComposeFile}. Invoked with an
 * {@link Ordered order} of {@code 0} by default, considering overriding
 * {@link #getOrder()} to customize this behaviour.
 *
 * @author Moritz Halbritter
 */
@FunctionalInterface
public interface BootstrapSitYmlFileCustomizer extends Ordered {

	/**
	 * Customizes the given {@link ComposeFile}.
	 * @param applicationYmlFile the compose file to customize
	 */
	void customize(BootstrapConfigurationYmlFile bootstrapYmlFile);

	@Override
	default int getOrder() {
		return 0;
	}

}
