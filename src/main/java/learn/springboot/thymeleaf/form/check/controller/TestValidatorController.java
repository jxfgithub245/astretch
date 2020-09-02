package learn.springboot.thymeleaf.form.check.controller;

import learn.springboot.thymeleaf.form.check.model.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestValidatorController {
    @RequestMapping("/testValidator")
    public String testValidator(@ModelAttribute("goodsInfo") Goods goods){
        //goods.setGname("商品初始化");
        //goods.setGprice(0.0);
        return "testValidator";
    }
    @RequestMapping(value = "/add")
    public String add(@ModelAttribute("goodsInfo") @Validated Goods goods, BindingResult rs){
        if(rs.hasErrors()){
            return "testValidator";
        }
        return "testValidator";
    }
}
