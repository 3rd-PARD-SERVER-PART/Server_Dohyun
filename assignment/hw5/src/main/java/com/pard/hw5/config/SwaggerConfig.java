package com.pard.hw5.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("즐거운의 pard 5차 과제")
                        .description("행복한 도서관에 오신 걸 환영합니다~")
                        .version("1.0.0"));
    }
}