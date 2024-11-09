package com.aventon.platform.u202215823;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AventonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AventonApplication.class, args);
    }

}
