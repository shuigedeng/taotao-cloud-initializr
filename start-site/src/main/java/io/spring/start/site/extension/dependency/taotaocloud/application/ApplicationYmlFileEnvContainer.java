package io.spring.start.site.extension.dependency.taotaocloud.application;

import io.spring.initializr.generator.io.IndentingWriterFactory;
import io.spring.initializr.generator.project.ProjectGenerationContext;
import io.spring.start.site.extension.dependency.taotaocloud.enums.Env;
import io.spring.start.site.extension.dependency.taotaocloud.application.dev.ApplicationDevYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.application.local.ApplicationLocalYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.application.pre.ApplicationPreYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.application.pro.ApplicationProYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.application.sit.ApplicationSitYmlFileCustomizer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationYmlFileEnvContainer implements InitializingBean, ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationYmlFileEnvContainer.class);

    private final ObjectProvider<ApplicationYmlFileCustomizer> applicationYmlFileCustomizers;
    private final ObjectProvider<ApplicationDevYmlFileCustomizer> applicationDevYmlFileCustomizers;
    private final ObjectProvider<ApplicationLocalYmlFileCustomizer> applicationLocalYmlFileCustomizers;
    private final ObjectProvider<ApplicationPreYmlFileCustomizer> applicationPreYmlFileCustomizers;
    private final ObjectProvider<ApplicationProYmlFileCustomizer> applicationProYmlFileCustomizers;
    private final ObjectProvider<ApplicationSitYmlFileCustomizer> applicationSitYmlFileCustomizers;
    private final IndentingWriterFactory indentingWriterFactory;

    public ApplicationYmlFileEnvContainer(ObjectProvider<ApplicationYmlFileCustomizer> applicationYmlFileCustomizers,
                                          ObjectProvider<ApplicationDevYmlFileCustomizer> applicationDevYmlFileCustomizers,
                                          ObjectProvider<ApplicationLocalYmlFileCustomizer> applicationLocalYmlFileCustomizers,
                                          ObjectProvider<ApplicationPreYmlFileCustomizer> applicationPreYmlFileCustomizers,
                                          ObjectProvider<ApplicationProYmlFileCustomizer> applicationProYmlFileCustomizers,
                                          ObjectProvider<ApplicationSitYmlFileCustomizer> applicationSitYmlFileCustomizers,
                                          IndentingWriterFactory indentingWriterFactory) {
        this.applicationYmlFileCustomizers = applicationYmlFileCustomizers;
        this.applicationDevYmlFileCustomizers = applicationDevYmlFileCustomizers;
        this.applicationLocalYmlFileCustomizers = applicationLocalYmlFileCustomizers;
        this.applicationPreYmlFileCustomizers = applicationPreYmlFileCustomizers;
        this.applicationProYmlFileCustomizers = applicationProYmlFileCustomizers;
        this.applicationSitYmlFileCustomizers = applicationSitYmlFileCustomizers;
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
                ApplicationYmlFile applicationYmlFile = new ApplicationYmlFile();
                Env env = Env.valueOf(s);

                switch (env) {
                    case none:
                        applicationYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(applicationYmlFile));
                        break;
                    case dev:
                        applicationDevYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(applicationYmlFile));
                        break;
                    case local:
                        applicationLocalYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(applicationYmlFile));
                        break;
                    case pre:
                        applicationPreYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(applicationYmlFile));
                        break;
                    case pro:
                        applicationProYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(applicationYmlFile));
                        break;
                    case sit:
                        applicationSitYmlFileCustomizers.orderedStream().forEach((customizer) -> customizer.customize(applicationYmlFile));
                        break;
                    default:
                        break;
                }

                String relativePath = s.equals(Env.none.name()) ? "src/main/resources/application.yml" : String.format("src/main/resources/application-%s.yml", s);
                String resourcePattern = s.equals(Env.none.name()) ? "classpath:configuration/application.yml" : String.format("classpath:configuration/application-%s.yml", s);
                ApplicationYmlContributor applicationYmlContributor = new ApplicationYmlContributor(relativePath,
                        resourcePattern,
                        applicationYmlFile,
                        indentingWriterFactory);

                DefaultListableBeanFactory defaultListableBeanFactory =
                        (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
                String beanName = s.equals(Env.none.name()) ? "applicationYmlContributor" : String.format("application%sYmlContributor", StringUtils.capitalize(s));
                defaultListableBeanFactory.registerSingleton(beanName, applicationYmlContributor);
            }
        }
    }
}
