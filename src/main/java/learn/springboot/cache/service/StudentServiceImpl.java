package learn.springboot.cache.service;

import learn.springboot.cache.entity.Student;
import learn.springboot.cache.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    @CachePut(value = "student",key = "#student.id")
    public Student saveStudent(Student student){
        Student s = studentRepository.save(student);
        System.out.println("为key="+student.getId()+"数据做了缓存");
        return s;
    }

    @Override
    @CacheEvict(value = "student",key = "#student.id")
    public void deleteCache(Student student){
        Student s = studentRepository.save(student);
        System.out.println("删除了key="+student.getId());
    }

    @Override
    @Cacheable(value = "student")
    public Student selectOneStudent(Integer id){
        Student s = studentRepository.getOne(id);
        System.out.println("为key="+id+"数据做了缓存");
        return s;
    }
}
