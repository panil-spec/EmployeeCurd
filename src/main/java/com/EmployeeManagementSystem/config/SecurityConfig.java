package com.EmployeeManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("Bigil"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.withUsername("Anil")
                .password(encoder.encode("Bigil"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.DELETE,"/employees/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/employees/**").hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.PUT,"/employees/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/employees/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(httpBasic -> {});

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

