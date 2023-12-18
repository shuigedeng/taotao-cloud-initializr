package io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap;

import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.project.ProjectGenerationContext;
import io.spring.start.site.extension.dependency.taotaocloud.common.enums.Env;
import io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap.pre.BootstrapPreYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap.dev.BootstrapDevYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap.local.BootstrapLocalYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap.pro.BootstrapProYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.common.yml.bootstrap.sit.BootstrapSitYmlFileCustomizer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BootstrapYmlFileEnvContainer implements InitializingBean, ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(BootstrapYmlFileEnvContainer.class);

    private final ObjectProvider<BootstrapYmlFileCustomizer> bootstrapYmlFileCustomizers;
    private final ObjectProvider<BootstrapDevYmlFileCustomizer> bootstrapDevYmlFileCustomizers;
    private final ObjectProvider<BootstrapLocalYmlFileCustomizer> bootstrapLocalYmlFileCustomizers;
    private final ObjectProvider<BootstrapPreYmlFileCustomizer> bootstrapPreYmlFileCustomizers;
    private final ObjectProvider<BootstrapProYmlFileCustomizer> bootstrapProYmlFileCustomizers;
    private final ObjectProvider<BootstrapSitYmlFileCustomizer> bootstrapSitYmlFileCustomizers;
    private final IndentingWriterFactory indentingWriterFactory;

    public BootstrapYmlFileEnvContainer(ObjectProvider<BootstrapYmlFileCustomizer> bootstrapYmlFileCustomizers,
                                        ObjectProvider<BootstrapDevYmlFileCustomizer> bootstrapDevYmlFileCustomizers,
                                        ObjectProvider<BootstrapLocalYmlFileCustomizer> bootstrapLocalYmlFileCustomizers,
                                        ObjectProvider<BootstrapPreYmlFileCustomizer> bootstrapPreYmlFileCustomizers,
                                        ObjectProvider<BootstrapProYmlFileCustomizer> bootstrapProYmlFileCustomizers,
                                        ObjectProvider<BootstrapSitYmlFileCustomizer> bootstrapSitYmlFileCustomizers,
                                        IndentingWriterFactory indentingWriterFactory) {
        this.bootstrapYmlFileCustomizers = bootstrapYmlFileCustomizers;
        this.bootstrapDevYmlFileCustomizers = bootstrapDevYmlFileCustomizers;
        this.bootstrapLocalYmlFileCustomizers = bootstrapLocalYmlFileCustomizers;
        this.bootstrapPreYmlFileCustomizers = bootstrapPreYmlFileCustomizers;
        this.bootstrapProYmlFileCustomizers = bootstrapProYmlFileCustomizers;
        this.bootstrapSitYmlFileCustomizers = bootstrapSitYmlFileCustomizers;
        this.indentingWriterFactory = indentingWriterFactory;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof ProjectGenerationContext) {
            ProjectGenerationContext context = (ProjectGenerationContext) applicationContext;

            for (String s : Env.nameList()) {
                BootstrapYmlFile bootstrapYmlFile = new BootstrapYmlFile();
                Env env = Env.valueOf(s);

                switch (env) {
                    case none:
                        bootstrapYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(bootstrapYmlFile));
                        break;
                    case dev:
                        bootstrapDevYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(bootstrapYmlFile));
                        break;
                    case local:
                        bootstrapLocalYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(bootstrapYmlFile));
                        break;
                    case pre:
                        bootstrapPreYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(bootstrapYmlFile));
                        break;
                    case pro:
                        bootstrapProYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(bootstrapYmlFile));
                        break;
                    case sit:
                        bootstrapSitYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(bootstrapYmlFile));
                        break;
                    default:
                        break;
                }

                String relativePath = s.equals(Env.none.name()) ? "src/main/resources/bootstrap.yml" : String.format("src/main/resources/bootstrap-%s.yml", s);
                String resourcePattern = s.equals(Env.none.name()) ? "classpath:configuration/bootstrap.yml" : String.format("classpath:configuration/bootstrap-%s.yml", s);
                BootstrapYmlContributor applicationYmlContributor = new BootstrapYmlContributor(relativePath,
                        resourcePattern,
                        bootstrapYmlFile,
                        indentingWriterFactory);

                DefaultListableBeanFactory defaultListableBeanFactory =
                        (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
                String beanName = s.equals(Env.none.name()) ? "bootstrapYmlContributor" : String.format("bootstrap%sYmlContributor", StringUtils.capitalize(s));
                defaultListableBeanFactory.registerSingleton(beanName, applicationYmlContributor);
            }
        }
    }
}
