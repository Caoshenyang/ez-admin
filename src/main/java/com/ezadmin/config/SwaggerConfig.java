package com.ezadmin.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        // 建造者模式构建Docket
        return GroupedOpenApi.builder()
                .addOpenApiCustomizer(openApi -> openApi.setInfo(apiInfo()))
                .group("EZ-ADMIN")
                // 需要放出的接口
                .packagesToScan("com.ezadmin.modules.*.controller")
                .build();
    }

    private Info apiInfo() {
        return new Info()
                .title("接口文档")
                .description("EZ-ADMIN API描述")
                .contact(new Contact().url("https://www.csyblog.cn").name("申阳").email("2417254000@qq.com"))
                // MIT 协议
                .license(new License().name("MIT License").url("https://opensource.org/licenses/MIT"))
                .version("v1.0");
    }
}