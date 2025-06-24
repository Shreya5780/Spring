package org.example.quizeapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.repository")
@ComponentScan(basePackages = "com")
public class QuizeAppApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(QuizeAppApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
