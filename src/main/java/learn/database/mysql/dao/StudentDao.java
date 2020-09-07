package learn.database.mysql.dao;


import java.util.List;

public interface StudentDao {
    /**
     * 查询所有宠物
     */
    List<Student> findAllStudents() throws Exception;
}