package com.blogs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.blogs")
@EnableJpaRepositories(basePackages = "com.blogs.repository")
@EntityScan(basePackages = "com.blogs.model")
public class BlogsSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogsSiteApplication.class, args);
    }

}
