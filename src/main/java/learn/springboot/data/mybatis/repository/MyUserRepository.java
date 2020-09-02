package learn.springboot.data.mybatis.repository;

import learn.springboot.data.mybatis.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyUserRepository {
    public List<MyUser> findAll();
}
