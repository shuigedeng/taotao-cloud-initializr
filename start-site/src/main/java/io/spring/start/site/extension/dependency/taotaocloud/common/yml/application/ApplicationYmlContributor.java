package io.spring.start.site.extension.dependency.taotaocloud.common.yml.application;

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
    private final String relativePath;

    public ApplicationYmlContributor(String relativePath,
                                     IndentingWriterFactory indentingWriterFactory,
                                     ApplicationYmlFile applicationYmlFile) {
        this(relativePath, relativePath, applicationYmlFile, indentingWriterFactory);
    }

    public ApplicationYmlContributor(String relativePath,
                                     String resourcePattern,
                                     ApplicationYmlFile applicationYmlFile,
                                     IndentingWriterFactory indentingWriterFactory) {
        super(relativePath, resourcePattern);
        this.relativePath = relativePath;
        this.applicationYmlFile = applicationYmlFile;
        this.indentingWriterFactory = indentingWriterFactory;
        this.applicationYmlFileWriter = new ApplicationYmlFileWriter();
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        super.contribute(projectRoot);

        Path output = projectRoot.resolve(relativePath);
        writeComposeFile(Files.newBufferedWriter(output));
    }

    void writeComposeFile(Writer out) throws IOException {
        try (IndentingWriter writer = this.indentingWriterFactory.createIndentingWriter("yaml", out)) {
            this.applicationYmlFileWriter.writeService(writer, this.applicationYmlFile);
        }
    }

}
