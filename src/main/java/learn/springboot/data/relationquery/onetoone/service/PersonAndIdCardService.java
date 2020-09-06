package learn.springboot.data.relationquery.onetoone.service;

import learn.springboot.data.relationquery.onetoone.entity.IdCard;
import learn.springboot.data.relationquery.onetoone.entity.Person;

import java.util.List;

public interface PersonAndIdCardService {
    public void saveAll();
    public List<Person> findAllPerson();
    public List<IdCard> findAllIdCard();
    public IdCard findByPerson_id(Integer id);
    public List<IdCard> findByAddressAndCode(String address,String code);
    public Person findByIdCard_id(Integer id);
    public List<Person> findByPnameAndPsex(String pname,String psex);
    public IdCard getOneIdCard(Integer id);
    public Person getOnePerson(Integer id);
}
