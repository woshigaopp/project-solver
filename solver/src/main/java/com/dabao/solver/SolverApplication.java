package com.dabao.solver;

import dabao.beanloader.anotation.EnableSpi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dabao.solver.*")
@EnableSpi(basePackages = "com.dabao.api")
public class SolverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolverApplication.class, args);
    }

}
