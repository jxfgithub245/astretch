package test.service.TestFrame;

import java.util.*;


public interface TestFrameService {
    //构造测试框架基础方法
    public void createTestFrameBasicMethod(String fieldFile,String frameworkFile,String projectFile);

    //获取测试框架目录集
    public String getTestFramePropertiesValue(String key);

    //构造测试框架目录集
    public Map<String,Map<String,List<String>>> constructTestFrameProjectsMap();

    //创建测试框架目录集
    public Map<String,Map<String,List<String>>> createTestFrame();


}
