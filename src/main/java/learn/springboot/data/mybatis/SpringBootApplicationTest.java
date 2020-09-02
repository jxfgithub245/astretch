package learn.springboot.data.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "learn.springboot.data.mybatis.repository")
public class SpringBootApplicationTest {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootApplicationTest.class, args);
    }
}