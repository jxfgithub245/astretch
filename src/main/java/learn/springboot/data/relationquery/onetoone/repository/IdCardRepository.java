package learn.springboot.data.relationquery.onetoone.repository;

import learn.springboot.data.relationquery.onetoone.entity.IdCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdCardRepository  extends JpaRepository<IdCard,Integer> {
    public IdCard findByPerson_id(Integer id);
    public List<IdCard> findByAddressAndCode(String address, String code);
}
