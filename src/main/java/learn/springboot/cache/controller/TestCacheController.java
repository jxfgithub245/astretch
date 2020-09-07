package learn.springboot.cache.controller;

import learn.springboot.cache.entity.Student;
import learn.springboot.cache.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCacheController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/savePut")
    public Student save(Student student){
        return studentService.saveStudent(student);
    }
    @RequestMapping("/selectAble")
    public Student select(Integer id){
        return studentService.selectOneStudent(id);
    }
    @RequestMapping("/deleteEvict")
    public String deleteCache(Student student){
        studentService.deleteCache(student);
        return "ok";
    }




}
