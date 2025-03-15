package com.ezadmin.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EZ-ADMIN API 文档")
                        .description("API Documentation for Spring Boot 3 Application")
                        .contact(new Contact().name("shenyang"))
                        .version("1.0.0"));
    }
}
