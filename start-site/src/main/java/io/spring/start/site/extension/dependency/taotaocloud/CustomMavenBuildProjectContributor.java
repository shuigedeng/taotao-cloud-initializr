//package io.spring.start.site.extension.dependency.taotaocloud;
//
//import io.spring.initializr.generator.buildsystem.BuildWriter;
//import io.spring.initializr.generator.io.IndentingWriter;
//import io.spring.initializr.generator.io.IndentingWriterFactory;
//import io.spring.initializr.generator.project.contributor.ProjectContributor;
//
//import java.io.IOException;
//import java.io.Writer;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//public class CustomMavenBuildProjectContributor implements BuildWriter, ProjectContributor {
//
//    private final ModuleMavenBuild build;
//
//    private final IndentingWriterFactory indentingWriterFactory;
//
//    private final CustomMavenBuildWriter buildWriter = new CustomMavenBuildWriter();
//
//
//    public CustomMavenBuildProjectContributor(ModuleMavenBuild build, IndentingWriterFactory indentingWriterFactory) {
//        this.build = build;
//        this.indentingWriterFactory = indentingWriterFactory;
//    }
//
//
//    @Override
//    public void writeBuild(Writer out) throws IOException {
//        try (IndentingWriter writer = this.indentingWriterFactory.createIndentingWriter("maven", out)) {
//            this.buildWriter.writeTo(writer, this.build);
//        }
//    }
//
//    @Override
//    public void contribute(Path projectRoot) throws IOException {
//        Path pomFile = Files.createFile(projectRoot.resolve("pom.xml"));
//        writeBuild(Files.newBufferedWriter(pomFile));
//    }
//}
