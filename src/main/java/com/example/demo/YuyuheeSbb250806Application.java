package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackageClasses = {sbb_250806_config.class})
public class YuyuheeSbb250806Application {

    public static void main(String[] args) {
        SpringApplication.run(sbb_250806_config.class, args);
    }

}
