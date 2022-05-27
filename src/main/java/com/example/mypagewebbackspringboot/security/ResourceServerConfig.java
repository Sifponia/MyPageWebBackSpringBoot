package com.example.mypagewebbackspringboot.security;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import java.util.Arrays;

@Configuration
@EnableResourceServer

public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {
        //PUBLIC
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/message").permitAll()
                .antMatchers(HttpMethod.POST, "/api/users/**").hasAnyRole("ADMIN")
               // .antMatchers(HttpMethod.POST, "/oauth/token/**").hasAnyRole("ADMIN")


                .antMatchers(HttpMethod.GET, "/api/users").hasAnyRole("ADMIN")

                .anyRequest().authenticated()
                .and()
                .cors().configurationSource(corsConfigurationSource());


    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }


    @Bean
    public FilterRegistrationBean<CorsFilter> filter() {
        FilterRegistrationBean<CorsFilter> beans =
                new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        beans.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return beans;

    }


}
