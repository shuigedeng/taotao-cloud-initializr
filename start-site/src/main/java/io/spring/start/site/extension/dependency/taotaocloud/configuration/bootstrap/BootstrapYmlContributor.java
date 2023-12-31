package io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap;

import io.spring.initializr.generator.io.IndentingWriter;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.project.contributor.SingleResourceProjectContributor;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class BootstrapYmlContributor extends SingleResourceProjectContributor {

    private final BootstrapConfigurationYmlFile bootstrapYmlFile;
    private final IndentingWriterFactory indentingWriterFactory;
    private final BootstrapYmlFileWriter bootstrapYmlFileWriter;
    private final String relativePath;

    public BootstrapYmlContributor(String relativePath,
                                     IndentingWriterFactory indentingWriterFactory,
                                   BootstrapConfigurationYmlFile bootstrapYmlFile) {
        this(relativePath, relativePath, bootstrapYmlFile, indentingWriterFactory);
    }

    public BootstrapYmlContributor(String relativePath,
                                     String resourcePattern,
                                   BootstrapConfigurationYmlFile bootstrapYmlFile,
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
        writeComposeFile(Files.newBufferedWriter(output, StandardOpenOption.APPEND));
    }

    void writeComposeFile(Writer out) throws IOException {
        try (IndentingWriter writer = this.indentingWriterFactory.createIndentingWriter("yaml", out)) {
            this.bootstrapYmlFileWriter.writeService(writer, this.bootstrapYmlFile);
        }
    }

}
