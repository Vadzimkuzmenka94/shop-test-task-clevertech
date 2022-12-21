package com.example.shoptesttaskclevertech;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "clevertech.com.esm")
@EntityScan(basePackages = "clevertech.com.esm")
@EnableJpaRepositories(basePackages = "clevertech.com.esm.repository")
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
public class ShopTestTaskClevertechApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopTestTaskClevertechApplication.class, args);
    }
}