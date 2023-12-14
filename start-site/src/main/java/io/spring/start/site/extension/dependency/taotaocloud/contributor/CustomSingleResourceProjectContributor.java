package io.spring.start.site.extension.dependency.taotaocloud.contributor;

import io.spring.initializr.generator.project.contributor.SingleResourceProjectContributor;

/**
 * 单文件处理
 */
public class CustomSingleResourceProjectContributor extends SingleResourceProjectContributor {
    public CustomSingleResourceProjectContributor(String relativePath, String resourcePattern) {
        super(relativePath, resourcePattern);
    }
}
