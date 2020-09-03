package learn.springboot.core.readconfig.difficult.configurationProperties.controller;

import learn.springboot.core.readconfig.difficult.configurationProperties.model.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationPropertiesController {
       @Autowired
       StudentProperties studentProperties;
       @RequestMapping("/testConfigurationProperties")
       public String testConfigurationProperties(){
           return studentProperties.toString();
       }
}
