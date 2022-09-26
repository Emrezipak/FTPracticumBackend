package com.java.practicumfinalcase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
public class HttpEntityConfig {

    @Value("${service.token}")
    private String TOKEN;

    @Value("${service.user-agent}")
    private String USER_AGENT;

    @Bean
    public HttpEntity<String> createHttpEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("content-type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("authorization", TOKEN);
        headers.add("user-agent",USER_AGENT);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }
}
