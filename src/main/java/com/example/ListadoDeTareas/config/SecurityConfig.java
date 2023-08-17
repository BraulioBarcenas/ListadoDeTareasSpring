package com.example.ListadoDeTareas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(auth -> {
            auth.anyRequest().authenticated();
        })
        .formLogin(login ->{
            login.successHandler(successHandler()); // Se llama a otra funcion que define a donde se va a mandar una vez inicie sesion
        })
        .sessionManagement( session ->{
            session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS); // Tipo de creacion de sesiones, ALWAYS, IF-REQUIRED, NEVER, STATELESS
            session.invalidSessionUrl("/login");
            session.maximumSessions(1);
        })
        .build();
    }
    
    public AuthenticationSuccessHandler successHandler(){
        return ((request, response, authentication) -> {
            response.sendRedirect("/getTasks");
        });
    }
}
