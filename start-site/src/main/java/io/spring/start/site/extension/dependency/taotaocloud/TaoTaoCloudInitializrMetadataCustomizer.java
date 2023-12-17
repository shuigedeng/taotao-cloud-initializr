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

import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.metadata.InitializrMetadataCustomizer;

/**
 * 自定义项目初始化配置元数据；这个 Customizer 比较特殊，框架会在首次加载元数据配置时调用。
 *
 * @author shuigedeng
 * @version 2022.09
 * @since 2023-12-13 21:55
 */
public class TaoTaoCloudInitializrMetadataCustomizer implements InitializrMetadataCustomizer {
    @Override
    public void customize(InitializrMetadata metadata) {

    }
}
