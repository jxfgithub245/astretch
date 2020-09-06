package learn.springboot.data.relationquery.onetoone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_table")
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
public class Person  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pname;
    private String psex;
    private int page;
    @OneToOne(
            optional = true,
            fetch = FetchType.LAZY,
            targetEntity = IdCard.class,
            cascade = CascadeType.ALL
    )

    @JoinColumn(
            name = "id_Card_id",
            referencedColumnName = "id",
            unique = true
    )
    @JsonIgnore
    private IdCard idCard;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public void setPname(String pname){
        this.pname = pname;
    }
    public String getPname(){
        return this.pname;
    }

    public void setPsex(String psex){
        this.psex = psex;
    }
    public String getPsex(){
        return this.psex;
    }

    public void setPage(int page){
        this.page = page;
    }
    public int getPage(){
        return this.page;
    }

    public void setIdCard(IdCard idCard){
        this.idCard = idCard;
    }
    public IdCard getIdCard(){
        return this.idCard;
    }


}
