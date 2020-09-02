package learn.thymeleaf.form.submit.model;

public class LoginBean {
    String uname;
    String urole;
    public void setUname(String uname){
        this.uname = uname;
    }

    public String getUname(){
        return this.uname;
    }

    public void setUrole(String urole){
        this.urole = urole;
    }

    public String getUrole(){
        return this.urole;
    }
}
