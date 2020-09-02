package learn.springboot.data.conditionquery.repository;

import learn.springboot.data.conditionquery.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRepository extends JpaRepository<MyUser,Integer>{
    public MyUser findByUname(String uname);
    public List<MyUser> findByUnameLike(String uname);
}
