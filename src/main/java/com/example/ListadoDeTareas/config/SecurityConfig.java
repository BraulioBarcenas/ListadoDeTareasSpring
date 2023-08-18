package com.example.ListadoDeTareas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(auth -> {
            auth.anyRequest().authenticated();
        }).csrf(csrf->{
            csrf.disable();
        })
        .formLogin(login ->{
            login.successHandler(successHandler()); // Se llama a otra funcion que define a donde se va a mandar una vez inicie sesion
        })
        .sessionManagement( session ->{
            session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS); // Tipo de creacion de sesiones, ALWAYS, IF-REQUIRED, NEVER, STATELESS
            session.invalidSessionUrl("/login");
            session.maximumSessions(1);  
    
            session.sessionConcurrency(sessionConcurrency ->{
                sessionConcurrency.expiredUrl("/login");
                sessionConcurrency.sessionRegistry(sessionRegistry());
            });
            session.sessionFixation(Fixation -> { // Vulnerabilidad web para evitar secuestro de sesion
                Fixation.migrateSession(); // crea una nueva sesion identica
                // Fixation.newSession(); // crea una nueva sesion en blanco
                // Fixation.none(); // Desactiva la fijacion
            });
            
        }).httpBasic(t -> {
            Customizer.withDefaults();
        })
        .build();
    }
    

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }

    public AuthenticationSuccessHandler successHandler(){
        return ((request, response, authentication) -> {
            response.sendRedirect("/session");
        });
    }
}
