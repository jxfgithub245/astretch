package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SpringBootApplicationTest {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootApplicationTest.class, args);
    }
}