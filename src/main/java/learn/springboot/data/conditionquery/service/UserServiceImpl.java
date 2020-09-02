package learn.springboot.data.conditionquery.service;

import learn.springboot.data.conditionquery.entity.MyUser;
import learn.springboot.data.conditionquery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveAll(){
        MyUser mu1 = new MyUser();
        mu1.setUname("陈恒 1");
        mu1.setUsex("男");
        mu1.setAge(28);
        MyUser mu2 = new MyUser();
        mu2.setUname("陈恒 2");
        mu2.setUsex("女");
        mu2.setAge(18);
        MyUser mu3 = new MyUser();
        mu3.setUname("陈恒 3");
        mu3.setUsex("男");
        mu3.setAge(99);
        List<MyUser> users = new ArrayList<MyUser>();
        users.add(mu1);
        users.add(mu2);
        users.add(mu3);
        userRepository.saveAll(users);
    }
    @Override
    public List<MyUser> findAll(){
        return userRepository.findAll();
    }

    @Override
    public MyUser findByUname(String uname) {
        return userRepository.findByUname(uname);
    }

    @Override
    public List<MyUser> findByUnameLike(String uname){
        return userRepository.findByUnameLike("%"+uname+"%");
    }

    @Override
    public MyUser getOne(int id){
        return userRepository.getOne(id);
    }
}
