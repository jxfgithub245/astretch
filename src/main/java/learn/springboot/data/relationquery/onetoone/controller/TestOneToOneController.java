package learn.springboot.data.relationquery.onetoone.controller;

import learn.springboot.data.relationquery.onetoone.entity.IdCard;
import learn.springboot.data.relationquery.onetoone.entity.Person;
import learn.springboot.data.relationquery.onetoone.service.PersonAndIdCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestOneToOneController {
    @Autowired
    private PersonAndIdCardService personAndIdCardService;
    @RequestMapping("/onetoone/save")
    public String save(){
        personAndIdCardService.saveAll();
        return "人员和身份保存成功";
    }

    @RequestMapping("/onetoone/findAllPerson")
    public List<Person> findAllPerson(){
        return personAndIdCardService.findAllPerson();
    }

    @RequestMapping("/onetoone/findAllIdCard")
    public List<IdCard> findAllIdCard(){
        return personAndIdCardService.findAllIdCard();
    }

    @RequestMapping("/onetoone/findByPerson_id")
    public IdCard findByPerson_id(Integer id){
        return personAndIdCardService.findByPerson_id(id);
    }

    @RequestMapping("/onetoone/findByAddressAndCode")
    public List<IdCard> findByAddressAndCode(String address,String code){
        return personAndIdCardService.findByAddressAndCode(address,code);
    }
    @RequestMapping("/onetoone/findByIdCard_id")
    public Person findByIdCard_id(Integer id){
        return personAndIdCardService.findByIdCard_id(id);
    }

    @RequestMapping("/onetoone/findByPnameAndPsex")
    public List<Person> findByPnameAndPsex(String pname,String psex){
        return personAndIdCardService.findByPnameAndPsex(pname,psex);
    }


    @RequestMapping("/getOneIdCard")
    public IdCard getOneIdCard(Integer id){
        return personAndIdCardService.getOneIdCard(id);
    }

    @RequestMapping("/getOnePerson")
    public Person getOnePerson(Integer id){
        return personAndIdCardService.getOnePerson(id);
    }

}
