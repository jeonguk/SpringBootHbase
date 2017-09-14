package com.smmc.vyrl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "/");
        SpringApplication.run(Application.class, args);
    }
}
