package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.buildsystem.maven.MavenBuild;

import java.util.List;

public class ModuleMavenBuild extends MavenBuild {

    private List<ModuleContainer> moduleContainer;

    public List<ModuleContainer> getModuleContainer() {
        return moduleContainer;
    }

    public ModuleMavenBuild setModuleContainer(List<ModuleContainer> moduleContainer) {
        this.moduleContainer = moduleContainer;
        return this;
    }

    public static class ModuleContainer {

        private String moduleName;

        public ModuleContainer(String moduleName) {
            this.moduleName = moduleName;
        }

        public String getModuleName() {
            return moduleName;
        }

        public ModuleContainer setModuleName(String moduleName) {
            this.moduleName = moduleName;
            return this;
        }
    }

}