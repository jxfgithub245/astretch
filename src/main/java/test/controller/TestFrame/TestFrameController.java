package test.controller.TestFrame;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.service.TestFrame.TestFrameServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
public class TestFrameController {

    @RequestMapping("/testFrame/createTestFrameMethod")
    public Map<String, Map<String, List<String>>> createTestFrameMethod(){
        TestFrameServiceImpl afsi = new TestFrameServiceImpl();
        Map<String,Map<String,List<String>>> TestFrame = afsi.createTestFrame();
        return TestFrame;
    };
}
