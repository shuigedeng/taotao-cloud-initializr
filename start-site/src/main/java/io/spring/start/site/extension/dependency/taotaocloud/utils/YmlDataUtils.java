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
package io.spring.start.site.extension.dependency.taotaocloud.utils;

import java.util.LinkedList;
import java.util.List;

/**
 * YmlDataUtils
 *
 * @author shuigedeng
 * @version 2022.09
 * @since 2023-12-16 10:43
 */
public class YmlDataUtils {

    public static List<String> taotaoCloudBasicData(){
        List<String> data = new LinkedList<>();
        data.add("taotao:");
        data.add("  cloud:");
        return data;
    }


    public static List<String> basicData(){
        List<String> data = new LinkedList<>();
        data.add("spring:");
        data.add("  profiles:");
        data.add("    active: dev");
        return data;
    }


    public static List<String> bootstrapLocalData(){
        List<String> data = new LinkedList<>();
        data.add("spring:");
        data.add("  cloud:");
        data.add("    circuitbreaker:");
        data.add("      sentinel:");
        data.add("        enabled: true");
        data.add("    loadbalancer:");
        data.add("      enabled: true");
        data.add("    nacos:");
        data.add("      discovery:");
        data.add("        server-addr: 127.0.0.1:8848");
        data.add("        metadata:");
        data.add("          version: ${taotaoCloudVersion}");
        data.add("          user.name: admin");
        data.add("          user.password: 123456");
        data.add("        group: TAOTAO_CLOUD_GROUP");
        data.add("        namespace: taotao-cloud-dev");
        data.add("        username: nacos");
        data.add("        password: nacos");
        data.add("        cluster-name: CQ");
        data.add("      config:");
        data.add("        enabled: true");
        data.add("        server-addr: 127.0.0.1:8848");
        data.add("        namespace: taotao-cloud-dev");
        data.add("        username: nacos");
        data.add("        password: nacos");
        data.add("        group: TAOTAO_CLOUD_GROUP");
        data.add("        file-extension: yml");
        data.add("        cluster-name: CQ");
        data.add("        refresh-enabled: true");
        data.add("    sentinel:");
        data.add("      enabled: true");
        data.add("      eager: true");
        return data;
    }

    public static List<String> bootstrapDevData(){
        List<String> data = new LinkedList<>();
        data.add("server:");
        data.add("  port: 33337");
        data.add("  http2:");
        data.add("    enabled: true");
        data.add("  undertow:");
        data.add("    buffer-size: 2048");
        data.add("    direct-buffers: true");
        data.add("");
        data.add("spring:");
        data.add("  config:");
        data.add("    activate:");
        data.add("      on-profile: dev");
        data.add("  pid:");
        data.add("    file: ${user.home}/logs/${spring.application.name}/${spring.application.name}.pid");
        data.add("  main:");
        data.add("    allow-circular-references: true");
        data.add("    allow-bean-definition-overriding: true");
        data.add("    banner-mode: off");
        data.add("    register-shutdown-hook: true");
        data.add("  application:");
        data.add("    name: taotao-cloud-sys);");
        data.add("  cloud:");
        data.add("    circuitbreaker:");
        data.add("      sentinel:");
        data.add("        enabled: true");
        data.add("    loadbalancer:");
        data.add("      enabled: true");
        data.add("    nacos:");
        data.add("      discovery:");
        data.add("        server-addr: 192.168.10.220:8848");
        data.add("        metadata:");
        data.add("          version: ${taotaoCloudVersion}");
        data.add("          user.name: admin");
        data.add("          user.password: 123456");
        data.add("        group: TAOTAO_CLOUD_GROUP");
        data.add("        namespace: taotao-cloud-dev");
        data.add("        username: nacos");
        data.add("        password: nacos");
        data.add("        cluster-name: CQ");
        data.add("        naming-load-cache-at-start: false");
        data.add("      config:");
        data.add("        enabled: true");
        data.add("        server-addr: 192.168.10.220:8848");
        data.add("        namespace: taotao-cloud-dev");
        data.add("        username: nacos");
        data.add("        password: nacos");
        data.add("        group: TAOTAO_CLOUD_GROUP");
        data.add("        file-extension: yml");
        data.add("        cluster-name: CQ");
        data.add("        refresh-enabled: true");
        data.add("        #使用nacos配置中心配置 dynamic-tp-nacos-cloud-demo-dtp-dev.yml");
        data.add("        #extension-configs:");
        data.add("        #  - dataId: ${spring.application.name}-dtp-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}");
        data.add("        #    group: DEFAULT_GROUP");
        data.add("        #    refresh: true  # 必须配置，负责自动刷新不生效");
        data.add("    sentinel:");
        data.add("      enabled: true");
        data.add("      eager: true");
        data.add("      #      datasource:");
        data.add("      #        #流控 名称随意");
        data.add("      #        flow:");
        data.add("      #          nacos:");
        data.add("      #            server-addr: 192.168.10.220:8848");
        data.add("      #            dataId: ${spring.application.name}-flow-rules.json");
        data.add("      #            namespace: 4c21599b-c836-4f1a-a72f-1260d5474f0f");
        data.add("      #            username: nacos");
        data.add("      #            password: nacos");
        data.add("      #            groupId: SENTINEL_GROUP");
        data.add("      #            data-type: json");
        data.add("      #            # 规则类型，取值见： org.springframework.cloud.alibaba.sentinel.datasource.RuleType");
        data.add("      #            rule-type: flow");
        data.add("      #        #熔断降级 名称随意");
        data.add("      #        degrade:");
        data.add("      #          nacos:");
        data.add("      #            server-addr: 192.168.10.220:8848");
        data.add("      #            dataId: ${spring.application.name}-degrade-rules.json");
        data.add("      #            namespace: 4c21599b-c836-4f1a-a72f-1260d5474f0f");
        data.add("      #            username: nacos");
        data.add("      #            password: nacos");
        data.add("      #            groupId: SENTINEL_GROUP");
        data.add("      #            data-type: json");
        data.add("      #            rule-type: degrade");
        data.add("      #        #系统规则 名称随意");
        data.add("      #        system:");
        data.add("      #          nacos:");
        data.add("      #            server-addr: 192.168.10.220:8848");
        data.add("      #            dataId: ${spring.application.name}-system-rules.json");
        data.add("      #            namespace: 4c21599b-c836-4f1a-a72f-1260d5474f0f");
        data.add("      #            username: nacos");
        data.add("      #            password: nacos");
        data.add("      #            groupId: SENTINEL_GROUP");
        data.add("      #            data-type: json");
        data.add("      #            rule-type: system");
        data.add("      #        #授权规则 名称随意");
        data.add("      #        authority:");
        data.add("      #          nacos:");
        data.add("      #            server-addr: 192.168.10.220:8848");
        data.add("      #            dataId: ${spring.application.name}-authority-rules.json");
        data.add("      #            namespace: 4c21599b-c836-4f1a-a72f-1260d5474f0f");
        data.add("      #            username: nacos");
        data.add("      #            password: nacos");
        data.add("      #            groupId: SENTINEL_GROUP");
        data.add("      #            data-type: json");
        data.add("      #            rule-type: authority");
        data.add("      #        #参数规则 名称随意");
        data.add("      #        param-flow:");
        data.add("      #          nacos:");
        data.add("      #            server-addr: 192.168.10.220:8848");
        data.add("      #            dataId: ${spring.application.name}-param-flow-rules.json");
        data.add("      #            namespace: 4c21599b-c836-4f1a-a72f-1260d5474f0f");
        data.add("      #            username: nacos");
        data.add("      #            password: nacos");
        data.add("      #            groupId: SENTINEL_GROUP");
        data.add("      #            data-type: json");
        data.add("      #            rule-type: param-flow");
        data.add("      transport:");
        data.add("        dashboard: 192.168.10.220:8858");
        data.add("        port: 8712");
        data.add("      metric:");
        data.add("        file-single-size: 1024 * 1024 * 50");
        data.add("        file-total-count: 10");
        data.add("      flow:");
        data.add("        cold-factor: 3");
        data.add("      log:");
        data.add("        dir: ${user.home}/logs/${spring.application.name}/sentinel");
        data.add("        switch-pid: false");
        data.add("");
        data.add("logging:");
        data.add("  file:");
        data.add("    name: ${user.home}/logs/${spring.application.name}/${spring.application.name}.all.log");
        data.add("    path: ${user.home}/logs/${spring.application.name}/");
        data.add("  logback:");
        data.add("    rollingpolicy:");
        data.add("      max-file-size: 10GB");
        data.add("      max-history: 30");
        data.add("      clean-history-on-start: true");
        data.add("      total-size-cap: 20GB");
        data.add("  level:");
        data.add("    root: INFO");
        data.add("    org.apache.zookeeper.ZooKeeper: info");
        data.add("    com.taotao.cloud.sys.api.feign: debug");
        data.add("    net.ttddyy.dsproxy.listener: debug");
        data.add("    net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener: debug");
        data.add("    org.springframework.core.log.LogAccessor: error");
        data.add("    com.alibaba.nacos.common.utils.LoggerUtils: error");
        data.add("    org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer: error");
        data.add("    org.springframework.amqp.rabbit.connection: error");
        data.add("    org.springframework.cloud.stream.binder.rabbit.provisioning.RabbitExchangeQueueProvisioner: error");
        data.add("    org.apache.rocketmq.logging.Slf4jLoggerFactory: error");
        data.add("    org.apache.rocketmq.client.consumer.store: error");
        data.add("    org.apache.kafka.clients.consumer: error");
        data.add("    org.apache.kafka.clients.Metadata: error");
        data.add("    org.apache.kafka.common.utils.AppInfoParser: error");
        data.add("    # hibernate log org.apache.kafka.clients.consumer");
        data.add("    #org.hibernate.SQL: debug");
        data.add("    #org.hibernate.type: info");
        data.add("    #org.hibernate.type.descriptor.sql.BasicBinder: trace");
        data.add("    #org.hibernate.type.descriptor.sql.BasicExtractor: debug");
        data.add("    #org.hibernate.engine.QueryParameters: debug");
        data.add("    #org.hibernate.engine.query.HQLQueryPlan: debug");
        data.add("    # mybatis log");
        data.add("    #com.apache.ibatis: trace");
        data.add("    #java.sql.Connection: debug");
        data.add("    #java.sql.Statement: debug");
        data.add("    #java.sql.PreparedStatement: debug");
        data.add("    # kafka log");
        data.add("    #kafka.server.KafkaConfig: info");
        data.add("    #kafka.admin.AdminClient.AdminConfig: info");
        data.add("    #org.apache.kafka: off");
        data.add("    #org.I0Itec.zkclient: info");
        data.add("    # springframework log");
        data.add("    #org.springframework.cloud.openfeign: debug");
        data.add("    #org.springframework.web: off");
        data.add("    #org.springframework.security: off");
        data.add("    #org.springframework.security.oauth2: off");
        data.add("    #org.springframework.boot.autoconfigure: off");
        data.add("    #org.elasticsearch.client: debug");
        return data;
    }

}
