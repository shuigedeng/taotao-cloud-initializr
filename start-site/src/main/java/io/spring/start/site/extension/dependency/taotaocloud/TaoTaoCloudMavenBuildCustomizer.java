/*
 * Copyright (c) 2020-2030, Shuigedeng (981376577@qq.com & https://blog.taotaocloud.top/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.spring.start.site.extension.dependency.taotaocloud;

import io.spring.initializr.generator.buildsystem.DependencyScope;
import io.spring.initializr.generator.buildsystem.maven.MavenBuild;
import io.spring.initializr.generator.spring.build.BuildCustomizer;

/**
 * 定义Maven/Gradle构建过程，如增加maven build插件
 *
 * @author shuigedeng
 * @version 2022.09
 * @since 2023-12-13 22:06
 */
public class TaoTaoCloudMavenBuildCustomizer implements BuildCustomizer<MavenBuild> {
    @Override
    public void customize(MavenBuild build) {
        build.dependencies().add("com.taotao.xxx", "xxxx", "xxx", DependencyScope
                .RUNTIME);

//        if (build.dependencies().has("myBatisGenerator")){
//            build.dependencies().remove("myBatisGenerator");
//            build.plugins().add("org.mybatis.generator",
//                    "mybatis-generator-maven-plugin",(plugin) -> plugin
//                            .dependency("mysql","mysql-connector-java","${mysql.version}"));
//        }
    }
}
