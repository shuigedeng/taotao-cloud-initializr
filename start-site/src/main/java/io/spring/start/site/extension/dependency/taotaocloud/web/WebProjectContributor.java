package io.spring.start.site.extension.dependency.taotaocloud.web;

import io.spring.initializr.generator.io.template.TemplateRenderer;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.contributor.ProjectContributor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class WebProjectContributor implements ProjectContributor {
    private static final Logger logger = LoggerFactory.getLogger(WebProjectContributor.class);

    private final ProjectDescription description;
    private final TemplateRenderer templateRenderer;
    private final String SOURCE_PATH = "src/main/java/";

    public WebProjectContributor(ProjectDescription description, TemplateRenderer templateRenderer) {
        this.description = description;
        this.templateRenderer = templateRenderer;
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {
        Map<String, Object> data = new HashMap<>();
        String groupId = description.getGroupId();
        String artifactId = description.getArtifactId();
        data.put("groupId", groupId);
        data.put("artifactId", artifactId);
        data.put("uppercaseArtifactId", StringUtils.capitalize(artifactId));
        data.put("version", "2024.01");
        data.put("date", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        logger.info("data======: {}", data);

        createEntity(projectRoot, groupId, artifactId, data);
        createConvert(projectRoot, groupId, artifactId, data);
        createBo(projectRoot, groupId, artifactId, data);
        createMapper(projectRoot, groupId, artifactId, data);
        createRepositoryCls(projectRoot, groupId, artifactId, data);
        createRepositoryInf(projectRoot, groupId, artifactId, data);
        createService(projectRoot, groupId, artifactId, data);
        createServiceImpl(projectRoot, groupId, artifactId, data);
        createManager(projectRoot, groupId, artifactId, data);
        createController(projectRoot, groupId, artifactId, data);

        // Path file = Files.createFile(projectRoot.resolve("README.md"));
        // String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        // Files.createDirectories(projectRoot.resolve(pre + "/controller/"));
        // Path codeFile = Files.createFile(projectRoot.resolve(pre + "/controller/DemoController.java"));
        // String code = this.templateRenderer.render("code/DemoController.java", data);
        // try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file));
        //      PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
        //     writer.println("README");
        //     codeWriter.print(code);
        // }
    }

    private void createEntity(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/model/entity/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/model/entity/" + StringUtils.capitalize(artifactId) + ".java"));
        String code = this.templateRenderer.render("code/model/entity/Demo.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }

    private void createConvert(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/model/convert/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/model/convert/" + StringUtils.capitalize(artifactId) + "Convert.java"));
        String code = this.templateRenderer.render("code/model/convert/DemoConvert.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }

    private void createBo(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/model/bo/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/model/bo/" + StringUtils.capitalize(artifactId) + "BO.java"));
        String code = this.templateRenderer.render("code/model/bo/DemoBO.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }

    private void createMapper(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/mapper/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/mapper/I" + StringUtils.capitalize(artifactId) + "Mapper.java"));
        String code = this.templateRenderer.render("code/mapper/IDemoMapper.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }


    private void createRepositoryCls(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/repository/cls/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/repository/cls/" + StringUtils.capitalize(artifactId) + "Repository.java"));
        String code = this.templateRenderer.render("code/repository/cls/DemoRepository.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }

    private void createRepositoryInf(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/repository/inf/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/repository/inf/I" + StringUtils.capitalize(artifactId) + "Repository.java"));
        String code = this.templateRenderer.render("code/repository/inf/IDemoRepository.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }

    private void createService(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/service/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/service/I" + StringUtils.capitalize(artifactId) + "Service.java"));
        String code = this.templateRenderer.render("code/service/IDemoService.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }

    private void createServiceImpl(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/service/impl/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/service/impl/" + StringUtils.capitalize(artifactId) + "ServiceImpl.java"));
        String code = this.templateRenderer.render("code/service/impl/DemoServiceImpl.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }

    private void createManager(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/manager/"));
        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/manager/" + StringUtils.capitalize(artifactId) + "Manager.java"));
        String code = this.templateRenderer.render("code/manager/DemoManager.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }

    private void createController(Path projectRoot, String groupId, String artifactId, Map<String, Object> data) throws IOException {
        String pre = SOURCE_PATH + groupId.replace(".", "/") + "/" + artifactId;
        Files.createDirectories(projectRoot.resolve(pre + "/controller/"));

        Path codeFile = Files.createFile(projectRoot.resolve(pre + "/controller/" + StringUtils.capitalize(artifactId) + "Controller.java"));
        String code = this.templateRenderer.render("code/controller/DemoController.java", data);
        try (PrintWriter codeWriter = new PrintWriter(Files.newBufferedWriter(codeFile));) {
            codeWriter.print(code);
        }
    }


}
