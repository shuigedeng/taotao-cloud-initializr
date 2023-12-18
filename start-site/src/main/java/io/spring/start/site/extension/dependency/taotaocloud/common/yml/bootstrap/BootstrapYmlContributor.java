package io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap;

import io.spring.initializr.generator.io.IndentingWriter;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.project.contributor.SingleResourceProjectContributor;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class BootstrapYmlContributor extends SingleResourceProjectContributor {

    private final BootstrapYmlFile bootstrapYmlFile;
    private final IndentingWriterFactory indentingWriterFactory;
    private final BootstrapYmlFileWriter bootstrapYmlFileWriter;
    private final String relativePath;

    public BootstrapYmlContributor(String relativePath,
                                     IndentingWriterFactory indentingWriterFactory,
                                   BootstrapYmlFile bootstrapYmlFile) {
        this(relativePath, relativePath, bootstrapYmlFile, indentingWriterFactory);
    }

    public BootstrapYmlContributor(String relativePath,
                                     String resourcePattern,
                                   BootstrapYmlFile bootstrapYmlFile,
                                     IndentingWriterFactory indentingWriterFactory) {
        super(relativePath, resourcePattern);
        this.relativePath = relativePath;
        this.bootstrapYmlFile = bootstrapYmlFile;
        this.indentingWriterFactory = indentingWriterFactory;
        this.bootstrapYmlFileWriter = new BootstrapYmlFileWriter();
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        super.contribute(projectRoot);

        Path output = projectRoot.resolve(relativePath);
        writeComposeFile(Files.newBufferedWriter(output));
    }

    void writeComposeFile(Writer out) throws IOException {
        try (IndentingWriter writer = this.indentingWriterFactory.createIndentingWriter("yaml", out)) {
            this.bootstrapYmlFileWriter.writeService(writer, this.bootstrapYmlFile);
        }
    }

}
