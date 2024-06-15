package org.example.javaares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class JavaAresApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaAresApplication.class, args);
    }

}
