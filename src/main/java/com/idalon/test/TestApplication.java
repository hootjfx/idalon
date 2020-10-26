package com.idalon.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Siyar
 */
@SpringBootApplication
public class TestApplication {
    public static final String REST_API_VERSION = "/api/v1/";

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
