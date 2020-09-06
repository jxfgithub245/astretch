package learn.springboot.data.relationquery.onetoone.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "idcard_table")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class IdCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;

    @Temporal(value=TemporalType.DATE)
    private Calendar birthday;
    private String address;
    @OneToOne(
            optional = true,
            fetch = FetchType.LAZY,
            targetEntity = Person.class,
            cascade = CascadeType.ALL
    )
    private Person person;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }

    public void setBirthday(Calendar birthday){
        this.birthday = birthday;
    }
    public Calendar getBirthday(){
        return this.birthday;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }

    public void setPerson(Person person){
        this.person = person;
    }
    public Person getPerson(){
        return this.person;
    }
}
