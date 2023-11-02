package com.springrestapi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springrestapi.controller", "com.springrestapi.service",
        "com.springrestapi.impl", "com.springrestapi.repository"})
@EnableJpaRepositories("com.springrestapi.repository")
@EntityScan("com.springrestapi.model")
public class SpringrestapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringrestapiApplication.class, args);
    }
}