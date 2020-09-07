package learn.springboot.cache.service;

import learn.springboot.cache.entity.Student;

public interface StudentService {
    public Student saveStudent(Student student);
    public void deleteCache(Student student);
    public Student selectOneStudent(Integer id);
}
