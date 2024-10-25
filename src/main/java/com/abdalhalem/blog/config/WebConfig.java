package com.abdalhalem.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abdalhalem.blog.CustomMappingHandler;

@Configuration
public class WebConfig {
    @Bean
    public CustomMappingHandler customMappingHandler() {
        return new CustomMappingHandler();
    }
}
