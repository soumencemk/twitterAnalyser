package com.soumen.twitterstream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author Soumen Karmakar
 * 21/05/2020
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        return http.httpBasic().disable()
                .authorizeExchange()
                .pathMatchers("/", "/error").permitAll()
                .anyExchange().authenticated()
                .and().oauth2Login()
                .and().formLogin().disable()
                .build();
    }
}
