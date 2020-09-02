package learn.springboot.thymeleaf.jsonhandler.model;

public class Person {
    private String pname;
    private String password;
    private Integer page;
    public void setPname(String pname){
        this.pname = pname;
    }

    public String getPname(){
        return this.pname;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPage(Integer page){
        this.page = page;
    }

    public Integer getPage(){
        return this.page;
    }
}
