package learn.thymeleaf.jsonhandler.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationTest.class, args);
    }
}