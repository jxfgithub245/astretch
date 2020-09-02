package learn.springboot.thymeleaf.form.check.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class Goods {
    @NotBlank(message = "商品必须输入")
    @Length(min=1,max=5,message = "商品名长度在1到5之间")
    private String gname;
    @Range(min=0,max = 100,message = "商品价格在0到100之间")
    private double gprice;

    public void setGname(String gname){
        this.gname = gname;
    }
    public String getGname(){
        return this.gname;
    }

    public void setGprice(double gprice){
        this.gprice = gprice;
    }
    public double getGprice(){
        return this.gprice;
    }


}
