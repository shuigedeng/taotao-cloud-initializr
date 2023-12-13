package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.io.IndentingWriter;

import java.util.List;

public class CustomMavenBuildWriter{
    public void writeTo(IndentingWriter writer, ModuleMavenBuild build) {
    //     MavenBuildSettings settings = build.getSettings();
    //     writeProject(writer, () -> {
    //         writeParent(writer, build);
    //         writeProjectCoordinates(writer, settings);
    //         writePackaging(writer, settings);
    //         writeProjectName(writer, settings);
    //         writeProperties(writer, build.properties());
    //         writeModule(writer, build.getModuleContainer());
    //         writeDependencyManagement(writer, build.boms());
    //     });
    }

    private void writeModule(IndentingWriter writer, List<ModuleMavenBuild.ModuleContainer> moduleContainer) {
        // writeCollectionElement(writer, "modules", moduleContainer, (writ, module) -> {
        //     writeSingleElement(writ, "module", module.getModuleName());
        // });
    }


}