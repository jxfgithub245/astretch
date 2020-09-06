package test.service.TestFrame;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
@Component
public class TestFrameServiceImpl implements TestFrameService {
    File path = new File("");
    String relativePath = path.getAbsolutePath();
    String absolutePath = relativePath+"\\src\\main\\java\\test\\";

    /*
     * 创建测试框架目录集基础方法
     * field -- 测试领域主目录
     * frameworkFile -- 框架分目录
     * projectFile -- 测试项目目录
     * */

    @Override
    public void createTestFrameBasicMethod(String fieldFile,String frameworkFile,String projectFile){
        File path = new File("");
        String absolutePath = path.getAbsolutePath();
        System.out.println(absolutePath);
        String fieldFilePath = this.absolutePath+fieldFile;
        File  createFieldFilePath =new File(fieldFilePath);
        System.out.println(createFieldFilePath);
        if(!createFieldFilePath.exists()){//如果文件夹不存在
            createFieldFilePath.mkdir();//创建文件夹
        }

        String frameworkFilePath = fieldFilePath+"\\"+frameworkFile;
        File  createFrameworkFilePath =new File(frameworkFilePath);
        if(!createFrameworkFilePath.exists()){//如果文件夹不存在
            createFrameworkFilePath.mkdir();//创建文件夹
        }
        String projectFilePath = frameworkFilePath+"\\"+projectFile;
        File  createProjectFilePath =new File(projectFilePath);
        if(!createProjectFilePath.exists()){//如果文件夹不存在
            createProjectFilePath.mkdir();//创建文件夹
        }
    }

    @Override
    public String getTestFramePropertiesValue(String key){
        Properties prop = new Properties();
        String suiteAssmblyPropertiesValue = "";
        String propertiesPath = this.absolutePath+"testframe.properties";
        try {
            prop.load(new FileInputStream(propertiesPath));
            suiteAssmblyPropertiesValue = prop.getProperty(key);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return suiteAssmblyPropertiesValue;
    }

    @Override
    public Map<String,Map<String,List<String>>> constructTestFrameProjectsMap(){
        TestFrameServiceImpl sa = new TestFrameServiceImpl();
        Map<String,Map<String,List<String>>> fieldFrameworksProjectsMap = new HashMap<>();
        String fields = "test.fields";
        String testFields = sa.getTestFramePropertiesValue(fields);
        String[] testFieldList = testFields.split(",");
        for (String testField : testFieldList) {
            Map<String,List<String>> frameworksProjectsMap = new HashMap<>();
            String frameworks = "test."+testField+".frameworks";
            String projects = "test."+testField+".projects";
            String testFrameworks = sa.getTestFramePropertiesValue(frameworks);
            String testProjects = sa.getTestFramePropertiesValue(projects);
            String[] testFrameworkList = testFrameworks.split(",");
            String[] testProjectList = testProjects.split(",");
            List<String> projectsList = new ArrayList<>(Arrays.asList(testProjectList));
            for (String testFramework : testFrameworkList) {
                frameworksProjectsMap.put(testFramework, projectsList);
            }
            fieldFrameworksProjectsMap.put(testField,frameworksProjectsMap);
        }
        return fieldFrameworksProjectsMap;
    }


    /*
     *创建测试框架目录集
     */
    @Override
    public Map<String,Map<String,List<String>>> createTestFrame(){
        TestFrameServiceImpl sa = new TestFrameServiceImpl();
        Map<String,Map<String,List<String>>> fieldFrameworksProjectsMap = sa.constructTestFrameProjectsMap();
        for(Map.Entry<String,Map<String,List<String>>> fieldFrameworksProjects : fieldFrameworksProjectsMap.entrySet()){
            String field = fieldFrameworksProjects.getKey();
            Map<String,List<String>> frameworksProjectsValue = fieldFrameworksProjects.getValue();
            for(Map.Entry<String,List<String>> frameworksProjects : frameworksProjectsValue.entrySet()){
                String framework = frameworksProjects.getKey();
                List<String> projectsValue = frameworksProjects.getValue();
                for (String project : projectsValue) {
                    createTestFrameBasicMethod(field,framework,project);
                }
            }
        }
        System.out.println("fieldFrameworksProjectsMap"+fieldFrameworksProjectsMap);
        return fieldFrameworksProjectsMap;
    }

    public static void main(String args[]){
        TestFrameServiceImpl afsi = new TestFrameServiceImpl();
        afsi.createTestFrame();
    }
}
