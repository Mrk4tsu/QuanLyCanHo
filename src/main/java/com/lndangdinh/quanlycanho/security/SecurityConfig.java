package com.lndangdinh.quanlycanho.security;

import com.lndangdinh.quanlycanho.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Autowired
    private CustomUserDetailService userDetailService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(cfrs -> cfrs.disable()).authorizeHttpRequests((auth) -> auth.
                        requestMatchers("/*").permitAll().
                        requestMatchers("/admin/**").permitAll().
                        anyRequest().authenticated());

        return httpSecurity.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web
                .ignoring()
                .requestMatchers("/static/**", "/assets/**");
    }

}
