package learn.springboot.thymeleaf.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestThymeleafController {
    @RequestMapping("/")
    public String test(){
        return "index";
    }
}
