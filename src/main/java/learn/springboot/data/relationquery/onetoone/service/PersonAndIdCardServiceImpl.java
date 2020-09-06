package learn.springboot.data.relationquery.onetoone.service;

import learn.springboot.data.relationquery.onetoone.entity.IdCard;
import learn.springboot.data.relationquery.onetoone.entity.Person;
import learn.springboot.data.relationquery.onetoone.repository.IdCardRepository;
import learn.springboot.data.relationquery.onetoone.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PersonAndIdCardServiceImpl implements PersonAndIdCardService{
    @Autowired
    private IdCardRepository idCardRepository;
    @Autowired
    private PersonRepository personRepository;
    @Override
    public void saveAll(){
        IdCard ic1 = new IdCard();
        ic1.setCode("123456789");
        ic1.setAddress("北京");
        Calendar c1 = Calendar.getInstance();
        c1.set(2019,9,13);
        ic1.setBirthday(c1);

        IdCard ic2 = new IdCard();
        ic2.setCode("000123456789");
        ic2.setAddress("上海");
        Calendar c2 = Calendar.getInstance();
        c2.set(2019,8,14);
        ic2.setBirthday(c2);

        IdCard ic3 = new IdCard();
        ic3.setCode("111123456789");
        ic3.setAddress("广州");
        Calendar c3 = Calendar.getInstance();
        c3.set(2019,8,15);
        ic3.setBirthday(c3);

        List<IdCard> idCards = new ArrayList<IdCard>();
        idCards.add(ic1);
        idCards.add(ic2);
        idCards.add(ic3);
        idCardRepository.saveAll(idCards);


        Person p1 = new Person();
        p1.setPname("陈恒1");
        p1.setPsex("男");
        p1.setPage(88);
        p1.setIdCard(ic1);

        Person p2 = new Person();
        p2.setPname("陈恒1");
        p2.setPsex("男");
        p2.setPage(88);
        p2.setIdCard(ic2);
        Person p3 = new Person();
        p3.setPname("陈恒1");
        p3.setPsex("男");
        p3.setPage(88);
        p3.setIdCard(ic3);

        List<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        personRepository.saveAll(persons);
    }

    @Override
    public List<Person> findAllPerson(){
        return personRepository.findAll();
    }

    @Override
    public List<IdCard> findAllIdCard(){
        return idCardRepository.findAll();
    }

    @Override
    public IdCard findByPerson_id(Integer id){
        return idCardRepository.findByPerson_id(id);
    }

    @Override
    public List<IdCard> findByAddressAndCode(String address,String code){
        return idCardRepository.findByAddressAndCode(address,code);
    }

    @Override
    public Person findByIdCard_id(Integer id){
        return personRepository.findByIdCard_id(id);
    }

    @Override
    public List<Person> findByPnameAndPsex(String pname,String psex){
        return personRepository.findByPnameAndPsex(pname,psex);
    }

    @Override
    public IdCard getOneIdCard(Integer id){
        return idCardRepository.getOne(id);
    }

    @Override
    public Person getOnePerson(Integer id){
        return personRepository.getOne(id);
    }
}
