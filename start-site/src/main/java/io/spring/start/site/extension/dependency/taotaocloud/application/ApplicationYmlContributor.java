package io.spring.start.site.extension.dependency.taotaocloud.application;

import io.spring.initializr.generator.io.IndentingWriter;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.project.contributor.SingleResourceProjectContributor;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class ApplicationYmlContributor extends SingleResourceProjectContributor {

    private final ApplicationYmlFile applicationYmlFile;
    private final IndentingWriterFactory indentingWriterFactory;
    private final ApplicationYmlFileWriter applicationYmlFileWriter;

    public ApplicationYmlContributor(IndentingWriterFactory indentingWriterFactory, ApplicationYmlFile applicationYmlFile) {
        this("classpath:configuration/application.yml", applicationYmlFile, indentingWriterFactory);
    }

    public ApplicationYmlContributor(String resourcePattern, ApplicationYmlFile applicationYmlFile, IndentingWriterFactory indentingWriterFactory) {
        super("src/main/resources/application.yml", resourcePattern);
        this.applicationYmlFile = applicationYmlFile;
        this.indentingWriterFactory = indentingWriterFactory;
        applicationYmlFileWriter = new ApplicationYmlFileWriter();
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        super.contribute(projectRoot);

        Path output = projectRoot.resolve("src/main/resources/application.yml");
        writeComposeFile(Files.newBufferedWriter(output));
    }

    void writeComposeFile(Writer out) throws IOException {
        try (IndentingWriter writer = this.indentingWriterFactory.createIndentingWriter("yaml", out)) {
            this.applicationYmlFileWriter.writeService(writer, this.applicationYmlFile);
        }
    }

}