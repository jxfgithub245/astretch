package learn.springboot.core.readconfig.difficult.propertiysource.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource({"test.properties","ok.properties"})
public class PropertySourceValueReaderOtherController {
    @Value("${your.msg}")
    private String yourmsg;
    @Value("${my.msg}")
    private String mymsg;

    @RequestMapping("/testPropertySourceValueReaderOtherController")
    public String testPropertySourceValueReaderOtherController(){
        return yourmsg+mymsg;
    }
}
