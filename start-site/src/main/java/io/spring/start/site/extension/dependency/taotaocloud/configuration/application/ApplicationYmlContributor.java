package io.spring.start.site.extension.dependency.taotaocloud.configuration.application;

import io.spring.initializr.generator.io.IndentingWriter;
import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.project.contributor.SingleResourceProjectContributor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ApplicationYmlContributor extends SingleResourceProjectContributor {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationYmlContributor.class);

    private final ApplicationConfigurationYmlFile applicationYmlFile;
    private final IndentingWriterFactory indentingWriterFactory;
    private final ApplicationYmlFileWriter applicationYmlFileWriter;
    private final String relativePath;

    public ApplicationYmlContributor(String relativePath,
                                     IndentingWriterFactory indentingWriterFactory,
                                     ApplicationConfigurationYmlFile applicationYmlFile) {
        this(relativePath, relativePath, applicationYmlFile, indentingWriterFactory);
    }

    public ApplicationYmlContributor(String relativePath,
                                     String resourcePattern,
                                     ApplicationConfigurationYmlFile applicationYmlFile,
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

//        Path output = projectRoot.resolve(relativePath);
//        ApplicationYmlServiceContainer applicationYmlServiceContainer = applicationYmlFile.getApplicationYmlServiceContainer();
//        Map<String, List<String>> services = applicationYmlServiceContainer.getServices();
//        logger.info("ApplicationYmlContributor services: {}", services);
//        if (CollectionUtils.isEmpty(services)) {
//            return;
//        }
//            for (Map.Entry<String, List<String>> stringListEntry : services.entrySet()) {
//                List<String> values = stringListEntry.getValue();
//                if (!CollectionUtils.isEmpty(values)) {
//                    values.stream()
//                            .filter(StringUtils::isNotBlank)
//                            .forEach(value -> {
//                                try {
//                                    Files.writeString(output, value, StandardOpenOption.APPEND);
//                                } catch (IOException e) {
//                                    logger.error("ApplicationYmlContributor 追加数据报错", e);
//                                }
//                            });
//                }
//            }

        Path output = projectRoot.resolve(relativePath);
        writeComposeFile(Files.newBufferedWriter(output, StandardOpenOption.APPEND));
    }

    void writeComposeFile(Writer out) throws IOException {
        try (IndentingWriter writer = this.indentingWriterFactory.createIndentingWriter("yaml", out)) {
            this.applicationYmlFileWriter.writeService(writer, this.applicationYmlFile);
        }
    }

}
