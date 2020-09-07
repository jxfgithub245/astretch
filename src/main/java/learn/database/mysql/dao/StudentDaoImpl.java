package learn.database.mysql.dao;

import net.minidev.json.JSONUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    /**
     * 查询所有宠物
     */
    @Override
    public List<Student> findAllStudents() throws Exception {
        Connection conn=BaseDao.getConnection();
        String sql="select * from student_table";
        PreparedStatement stmt= conn.prepareStatement(sql);
        ResultSet rs=    stmt.executeQuery();
        List<Student> studentList=new ArrayList<>();
        while(rs.next()) {
            Student student=new Student(
                    rs.getInt("id"),
                    rs.getString("sname"),
                    rs.getString("sno"),
                    rs.getString("ssex")
            );
            System.out.println(rs.getString("sname"));
            studentList.add(student);
        }
        BaseDao.closeAll(conn, stmt, rs);
        return studentList;
    }

    public static void main(String args[]) throws Exception {
        StudentDaoImpl sdi = new StudentDaoImpl();
        List<Student> ls = sdi.findAllStudents();
        for(int i = 0 ; i <ls.size(); i++ ){
            Student tempObj = ls.get(i);
            int id = tempObj.getId();
            String sname = tempObj.getSname();
            System.out.println(id+sname);
        }
    }
}