package learn.springboot.core.readconfig.difficult.configurationProperties.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "obj")
public class StudentProperties {
    private String sname;
    private int sage;

    public void setSname(String sname){
        this.sname=sname;
    }

    public String getSname(){
        return this.sname;
    }

    public void setSage(int sage){
        this.sage=sage;
    }

    public int getSage(){
        return this.sage;
    }

    @Override
    public String toString(){
        return "StudentProperties[sname="+sname+",sage="+sage+"]";
    }
}
