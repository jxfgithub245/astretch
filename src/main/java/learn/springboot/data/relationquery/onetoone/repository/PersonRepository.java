package learn.springboot.data.relationquery.onetoone.repository;

import learn.springboot.data.relationquery.onetoone.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    public Person findByIdCard_id(Integer id);
    public List<Person> findByPnameAndPsex(String pname, String psex);
}
