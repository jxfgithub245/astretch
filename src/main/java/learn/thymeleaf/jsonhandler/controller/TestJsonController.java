package learn.thymeleaf.jsonhandler.controller;

import learn.thymeleaf.jsonhandler.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestJsonController {
    @RequestMapping("/input")
    public String input(){
        return "input";
    }

    @RequestMapping("/testJson")
    @ResponseBody
    public Person testUser(@RequestBody Person user){
        //打印接收的json格式数据
        System.out.println("pname="+user.getPname()+"password="+user.getPassword()+"page="+user.getPage());
        return user;
    }

    @RequestMapping("/testListPerson")
    @ResponseBody
    public ArrayList<Person> testListPerson(@RequestBody Person user){
        //打印接收的json格式数据
        System.out.println("pname="+user.getPname()+"password="+user.getPassword()+"page="+user.getPage());
        ArrayList<Person> allp = new ArrayList<Person>();
        Person p = new Person();
        p.setPname("陈恒 2");
        p.setPassword("78910");
        p.setPage(90);
        allp.add(p);
        return allp;
    }

    @RequestMapping("/testMapPerson")
    @ResponseBody
    public Map<String,Object> testMapPerson(@RequestBody Person user){
        //打印接收的json格式数据
        System.out.println("pname="+user.getPname()+"password="+user.getPassword()+"page="+user.getPage());
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pname","陈恒 2");
        map.put("password","123456");
        map.put("page",25);
        return map;
    }

    @RequestMapping("/testListMapPerson")
    @ResponseBody
    public List<Map<String,Object>> testListMapPerson(@RequestBody Person user){
        //打印接收的json格式数据
        System.out.println("pname="+user.getPname()+"password="+user.getPassword()+"page="+user.getPage());
        ArrayList<Map<String,Object>> allp = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pname","陈恒 2");
        map.put("password","123456");
        map.put("page",25);
        allp.add(map);
        return allp;
    }
}
