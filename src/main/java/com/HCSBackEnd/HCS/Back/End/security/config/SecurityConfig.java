package com.HCSBackEnd.HCS.Back.End.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import com.HCSBackEnd.HCS.Back.End.security.google2FA.CustomWebAuthenticationDetailsSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.HCSBackEnd.HCS.Back.End.security.google2FA.CustomAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        @Autowired
        private UserDetailsService userDetailsService;

        @Autowired
        private CustomWebAuthenticationDetailsSource authenticationDetailsSource;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http
                                .formLogin((formLogin) -> formLogin.loginPage("/login")
                                                .authenticationDetailsSource(authenticationDetailsSource)
                                                .permitAll())
                                .sessionManagement(sessionManagement -> sessionManagement
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authorizeHttpRequests(auth -> auth
                                                .anyRequest().permitAll())

                                .build();
        }

        @Bean
        public DaoAuthenticationProvider authProvider() {
                final CustomAuthenticationProvider authProvider = new CustomAuthenticationProvider();
                authProvider.setUserDetailsService(userDetailsService);
                authProvider.setPasswordEncoder(passwordEncoder);
                return authProvider;
        }

        

}
