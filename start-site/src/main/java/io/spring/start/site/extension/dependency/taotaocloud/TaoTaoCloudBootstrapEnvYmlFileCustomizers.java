package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.BootstrapYmlFile;
import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.BootstrapYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.dev.BootstrapDevYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.local.BootstrapLocalYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.pre.BootstrapPreYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.pro.BootstrapProYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.bootstrap.sit.BootstrapSitYmlFileCustomizer;
import io.spring.start.site.extension.dependency.taotaocloud.utils.YmlDataUtils;


public class TaoTaoCloudBootstrapEnvYmlFileCustomizers {

    public static class TaoTaoCloudBootstrapDevYmlFileCustomizer implements BootstrapDevYmlFileCustomizer {

        @Override
        public void customize(BootstrapYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-dev", YmlDataUtils.bootstrapDevData());
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }

    public static class TaoTaoCloudBootstrapLocalYmlFileCustomizer implements BootstrapLocalYmlFileCustomizer {

        @Override
        public void customize(BootstrapYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-local", YmlDataUtils.bootstrapLocalData());
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }

    public static class TaoTaoCloudBootstrapPreYmlFileCustomizer implements BootstrapPreYmlFileCustomizer {

        @Override
        public void customize(BootstrapYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-local", YmlDataUtils.bootstrapLocalData());
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }

    public static class TaoTaoCloudBootstrapProYmlFileCustomizer implements BootstrapProYmlFileCustomizer {

        @Override
        public void customize(BootstrapYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-local", YmlDataUtils.bootstrapLocalData());
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }


    public static class TaoTaoCloudBootstrapSitYmlFileCustomizer implements BootstrapSitYmlFileCustomizer {

        @Override
        public void customize(BootstrapYmlFile bootstrapYmlFile) {
            bootstrapYmlFile.getApplicationYmlServiceContainer().add("bootstrap-local", YmlDataUtils.bootstrapLocalData());
        }

        @Override
        public int getOrder() {
            return 1;
        }
    }
}

