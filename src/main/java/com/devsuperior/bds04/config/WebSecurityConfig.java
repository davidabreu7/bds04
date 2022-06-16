package com.devsuperior.bds04.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final Environment env;
    final
    BCryptPasswordEncoder passwordEncoder;

    public WebSecurityConfig(BCryptPasswordEncoder passwordEncoder, Environment env) {
        this.passwordEncoder = passwordEncoder;
        this.env = env;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and().csrf().disable();
    }
}
