package learn.springboot.data.conditionquery.entity;

import com.fasterxml.jackson.annotation.JsonTypeId;

import javax.persistence.*;
import java.io.Serializable;
/*
* root@host# mysql -u root -p
Enter password:*******
mysql> use RUNOOB;
Database changed
mysql> CREATE TABLE runoob_tbl(
   -> runoob_id INT NOT NULL AUTO_INCREMENT,
   -> runoob_title VARCHAR(100) NOT NULL,
   -> runoob_author VARCHAR(40) NOT NULL,
   -> submission_date DATE,
   -> PRIMARY KEY ( runoob_id )
   -> )ENGINE=InnoDB DEFAULT CHARSET=utf8;
Query OK, 0 rows affected (0.16 sec)
mysql>
* */
@Entity
@Table(name = "user_table")
public class MyUser implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @JsonTypeId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uname;
    private String usex;
    private int age;
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setUname(String uname){
        this.uname = uname;
    }

    public String getUname(){
        return this.uname;
    }

    public void setUsex(String usex){
        this.usex = usex;
    }

    public String getUsex(){
        return this.usex;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
}

