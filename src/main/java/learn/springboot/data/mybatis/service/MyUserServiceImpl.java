package learn.springboot.data.mybatis.service;

import learn.springboot.data.mybatis.entity.MyUser;
import learn.springboot.data.mybatis.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService{
    @Autowired
    private MyUserRepository myUserRepository;
    @Override
    public List<MyUser> findAll(){
        return myUserRepository.findAll();
    }
}
