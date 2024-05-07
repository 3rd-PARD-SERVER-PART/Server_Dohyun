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
                        .title("지옥의 pard 4차 과제 review")
                        .description("이거 어려웠다 진짜...ㄹ")
                        .version("1.0.0"));
    }
}