package learn.springboot.cache.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_table")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Student implements Serializable {
    private static final long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sno;
    private String sname;
    private String ssex;
    public Student(){
        super();
    }

    public Student(int id, String sno, String sname, String ssex){
        super();
        this.id=id;
        this.sname = sname;
        this.sno = sno;
        this.ssex = ssex;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setSno(String sno){
        this.sno = sno;
    }

    public String getSno(){
        return this.sno;
    }

    public void setSname(String sname){
        this.sname = sname;
    }

    public String getSname(){
        return this.sname;
    }

    public void setSsex(String ssex){
        this.ssex = ssex;
    }

    public String getSsex(){
        return this.ssex;
    }
}
