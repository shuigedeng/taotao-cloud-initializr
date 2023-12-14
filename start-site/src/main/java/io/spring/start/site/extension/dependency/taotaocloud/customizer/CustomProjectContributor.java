package io.spring.start.site.extension.dependency.taotaocloud.customizer;

import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import io.spring.initializr.metadata.InitializrMetadata;

import java.io.IOException;
import java.nio.file.Path;

/**
 * 定义一些个性化的项目目录或者文件
 */
public class CustomProjectContributor implements ProjectContributor {

    private final ProjectDescription projectDescription;
    private final IndentingWriterFactory indentingWriterFactory;
    private final InitializrMetadata initializrMetadata;

    public CustomProjectContributor(ProjectDescription projectDescription, IndentingWriterFactory indentingWriterFactory, InitializrMetadata initializrMetadata) {
        this.projectDescription = projectDescription;
        this.indentingWriterFactory = indentingWriterFactory;
        this.initializrMetadata = initializrMetadata;
    }


    @Override
    public void contribute(Path projectRoot) throws IOException {
        String artifactIdName = projectDescription.getArtifactId();
        // for (ModuleEnum value : ModuleEnum.values()) {
        //     String moduleName = value.moduleName(artifactIdName);
        //     try {
        //         Constructor<? extends ModuleStruct> constructor = value.getModuleStructClass()
        //                 .getConstructor(ProjectDescription.class, String.class, IndentingWriterFactory.class, InitializrMetadata.class);
        //         ModuleStruct moduleStruct = constructor.newInstance(projectDescription, moduleName, indentingWriterFactory, initializrMetadata);
        //         moduleStruct.build(projectRoot.resolve(moduleName));
        //     } catch (Exception e) {
        //         // 暂不处理
        //         throw new IOException(e);
        //     }
        // }
    }
}