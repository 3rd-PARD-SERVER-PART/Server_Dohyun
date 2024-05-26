package com.pard.shortkathon.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("즐거운의 pard shortkathon")
                        .description("ㅅㅣ작~~~~~ 하겠습니다~~~~~~")
                        .version("1.0.0"));
    }
}
