package com.kakeibo.kakeibo_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // すべてのリクエストを許可
            .csrf(csrf -> csrf.disable()) // CSRFも一旦無効
            .formLogin(form -> form.disable()); // ログイン画面の表示も無効
        return http.build();
    }
}
