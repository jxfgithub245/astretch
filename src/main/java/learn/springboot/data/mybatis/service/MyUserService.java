package learn.springboot.data.mybatis.service;

import learn.springboot.data.mybatis.entity.MyUser;

import java.util.List;

public interface MyUserService {
    public List<MyUser> findAll();

}
