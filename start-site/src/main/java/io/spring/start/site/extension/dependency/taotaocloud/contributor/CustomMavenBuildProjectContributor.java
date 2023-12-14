package io.spring.start.site.extension.dependency.taotaocloud.contributor;

import io.spring.initializr.generator.buildsystem.maven.MavenBuild;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.spring.build.maven.MavenBuildProjectContributor;

/**
 * 创建pom文件，写入pom文件内容
 */
public class CustomMavenBuildProjectContributor extends MavenBuildProjectContributor {


    public CustomMavenBuildProjectContributor(MavenBuild build, IndentingWriterFactory indentingWriterFactory) {
        super(build, indentingWriterFactory);
    }


}