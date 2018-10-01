package com.rozzer.config;

import com.rozzer.spring.DBServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DBServiceFactory transferService() {
        return new DBServiceFactory();
    }
}
