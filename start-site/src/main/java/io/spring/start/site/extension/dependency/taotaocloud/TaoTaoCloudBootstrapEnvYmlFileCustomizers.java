package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap.BootstrapConfigurationYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap.dev.BootstrapDevYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap.local.BootstrapLocalYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap.pre.BootstrapPreYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap.pro.BootstrapProYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.configuration.bootstrap.sit.BootstrapSitYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.common.utils.YmlDataUtils;


public class TaoTaoCloudBootstrapEnvYmlFileCustomizers {

    public static class TaoTaoCloudBootstrapDevYmlFileCustomizer implements BootstrapDevYmlFileCustomizer {

        @Override
        public void customize(BootstrapConfigurationYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-dev", YmlDataUtils.bootstrapDevData());
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }

    public static class TaoTaoCloudBootstrapLocalYmlFileCustomizer implements BootstrapLocalYmlFileCustomizer {

        @Override
        public void customize(BootstrapConfigurationYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-local", YmlDataUtils.bootstrapLocalData());
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }

    public static class TaoTaoCloudBootstrapPreYmlFileCustomizer implements BootstrapPreYmlFileCustomizer {

        @Override
        public void customize(BootstrapConfigurationYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-local", YmlDataUtils.bootstrapLocalData());
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }

    public static class TaoTaoCloudBootstrapProYmlFileCustomizer implements BootstrapProYmlFileCustomizer {

        @Override
        public void customize(BootstrapConfigurationYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-local", YmlDataUtils.bootstrapLocalData());
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }


    public static class TaoTaoCloudBootstrapSitYmlFileCustomizer implements BootstrapSitYmlFileCustomizer {

        @Override
        public void customize(BootstrapConfigurationYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-local", YmlDataUtils.bootstrapLocalData());
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }
}


