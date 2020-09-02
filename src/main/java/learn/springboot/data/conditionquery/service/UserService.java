package learn.springboot.data.conditionquery.service;

import learn.springboot.data.conditionquery.entity.MyUser;

import java.util.List;

public interface UserService {
    public void saveAll();
    public List<MyUser> findAll();
    public MyUser findByUname(String uname);
    public List<MyUser> findByUnameLike(String uname);
    public MyUser getOne(int id);
}
