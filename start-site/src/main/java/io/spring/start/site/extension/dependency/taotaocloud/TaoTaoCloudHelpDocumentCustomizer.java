/*
 * Copyright (c) 2020-2030, Shuigedeng (981376577@qq.com & https://blog.taotaocloud.top/).
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
package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.io.text.MustacheSection;
import io.spring.initializr.generator.spring.documentation.HelpDocument;
import io.spring.initializr.generator.spring.documentation.HelpDocumentCustomizer;

import java.util.Collections;

/**
 * 自定义项目的帮助文档。
 *
 * @author shuigedeng
 * @version 2022.09
 * @since 2023-12-13 21:54
 */
public class TaoTaoCloudHelpDocumentCustomizer implements HelpDocumentCustomizer {
    private final MustacheTemplateRenderer templateRenderer;

    public TaoTaoCloudHelpDocumentCustomizer(MustacheTemplateRenderer templateRenderer) {
        this.templateRenderer = templateRenderer;
    }


    @Override
    public void customize(HelpDocument document) {
        document.addSection(new MustacheSection(this.templateRenderer, "taotao-cloud-help", Collections.emptyMap()));
    }
}
