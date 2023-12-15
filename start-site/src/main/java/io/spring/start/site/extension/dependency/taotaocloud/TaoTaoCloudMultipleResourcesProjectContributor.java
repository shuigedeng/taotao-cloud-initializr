package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.project.contributor.MultipleResourcesProjectContributor;

import java.util.function.Predicate;

/**
 * 多文件复制，可以增加 可执行文件名称
 */
public class TaoTaoCloudMultipleResourcesProjectContributor extends MultipleResourcesProjectContributor {
    public TaoTaoCloudMultipleResourcesProjectContributor(String rootResource) {
        super(rootResource);
    }

    public TaoTaoCloudMultipleResourcesProjectContributor(String rootResource, Predicate<String> executable) {
        super(rootResource, executable);
    }
}
