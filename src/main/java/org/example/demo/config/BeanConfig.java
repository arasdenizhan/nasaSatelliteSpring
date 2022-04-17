package org.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.example.demo.util.H2Connector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;

@Configuration
@EnableScheduling
public class BeanConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public Gson getGson(){
        return new GsonBuilder().setPrettyPrinting().create();
    }

    @Bean
    public JsonParser getJsonParser(){
        return new JsonParser();
    }

    @Bean
    public Connection getConnection(){
        return H2Connector.getConnection();
    }
}
