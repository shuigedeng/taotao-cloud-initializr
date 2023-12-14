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
package io.spring.start.site.extension.dependency.taotaocloud.web;

import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.language.ClassName;
import io.spring.initializr.generator.language.java.JavaTypeDeclaration;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.spring.code.MainApplicationTypeCustomizer;

/**
 * 自定义 MainApplication 类。 生成main方法，主方法
 *
 * @author shuigedeng
 * @version 2022.09
 * @since 2023-12-13 21:44
 */
public class WebMainApplicationTypeCustomizer implements MainApplicationTypeCustomizer<JavaTypeDeclaration> {

    private final ProjectDescription description;
    private final TemplateRenderer templateRenderer;

    public WebMainApplicationTypeCustomizer(ProjectDescription description, TemplateRenderer templateRenderer) {
        this.description = description;
        this.templateRenderer = templateRenderer;
    }

    @Override
    public void customize(JavaTypeDeclaration typeDeclaration) {
        String groupId = description.getGroupId();
        String artifactId = description.getArtifactId();
        String path = groupId + "." + artifactId;
        String value = path + ".dao";

        typeDeclaration.annotations().add(ClassName.of("org.mybatis.spring.annotation.MapperScan"), builder -> {
            builder.add("basePackages", value);
        });

    }
}
