package com.example.fullstackdemosystem;

import com.googlecode.flyway.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullStackDemoSystemApplication {

    public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/employee_db","root","root");
        flyway.migrate();
        SpringApplication.run(FullStackDemoSystemApplication.class, args);
    }
}
