package com.project.web_app;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
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
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(registry ->{
            registry.requestMatchers("/").permitAll();
            registry.requestMatchers("/courses/show").hasRole("USER");
            registry.requestMatchers("/courses/login").hasRole("USER");

            registry.requestMatchers("/courses/get_add").hasRole("ADMIN");
            registry.requestMatchers("/courses/show").hasRole("ADMIN");
            registry.requestMatchers("/courses/all").hasRole("ADMIN");
            registry.requestMatchers("/courses/delete_show").hasRole("ADMIN");
            registry.requestMatchers("/courses/update/{id}").hasRole("ADMIN");
            registry.requestMatchers("/courses/delete/{id}").hasRole("ADMIN");
            registry.anyRequest().authenticated();
        })
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer.loginPage("/login").successHandler(new AuthanticationSuccesHandler())
                            .permitAll();
                })
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails1 = User.builder().username("user").
                password("$2a$12$WkeHPH6Sgc5R5picdr/Ene0bzdWGeFqRPkMf83NlZUugd/b6bHOea").roles("USER").build();

        UserDetails userDetails = User.builder().username("burak").
                password("$2a$12$07ir3rm7zmvXC1rKXAtcFuo.POsIiXL95xrFvd3M14lTuZVM//TiC").roles("ADMIN", "USER").build();

        return new InMemoryUserDetailsManager(userDetails, userDetails1);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
