package learn.springboot.thymeleaf.form.submit.controller;

import learn.springboot.thymeleaf.form.submit.model.LoginBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("loginBean",new LoginBean());
        return "login";
    }

    @RequestMapping("/login")
    public String greetingSubmit(@ModelAttribute LoginBean loginbean){
        System.out.println("测试提交的数据"+loginbean.getUname());
        return "result";
    }
}
