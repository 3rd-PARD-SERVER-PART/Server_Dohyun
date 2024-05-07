package com.pard.seminar5.config;

import com.pard.seminar5.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalOauth2UserService principalOauth2UserService;
    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable);
        http.addFilter(corsConfig.corsFilter());
        http.authorizeHttpRequests(
                an -> an.anyRequest().permitAll()
        );
        http.oauth2Login(
                oauth -> oauth
                        .loginPage("")
                        .defaultSuccessUrl("/home")
                        .userInfoEndpoint(
                                userInfoEndpointConfig ->
                                        userInfoEndpointConfig.userService(principalOauth2UserService)
                        )
        );
        return http.build();
    }
}
