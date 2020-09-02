package learn.springboot.data.mybatis.controller;

import learn.springboot.data.mybatis.entity.MyUser;
import learn.springboot.data.mybatis.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyUserController {
    @Autowired
    private MyUserService myUserService;
    @RequestMapping("/findMybatisAll")
    public List<MyUser> findMybatisAll(){
        return myUserService.findAll();
    }
}
