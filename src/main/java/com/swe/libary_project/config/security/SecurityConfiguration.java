package com.swe.libary_project.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico", "register/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin((form) -> form.loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?error")
                        .permitAll())
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
