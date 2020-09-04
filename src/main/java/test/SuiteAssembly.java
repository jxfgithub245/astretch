package test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class SuiteAssembly {
    @Value("${test.field}")
    private String testFields;
    @Value("${test.framework}")
    private String testFrameworks;
    @Value("${test.project}")
    private String testProjects;
    File path = new File("");
    String relativePath = path.getAbsolutePath();
    String absolutePath = relativePath+"\\src\\main\\java\\test\\";

    /*
    * 创建测试框架目录集基础方法
    * field -- 测试领域主目录
    * mainFile -- 框架分目录
    * projectFile -- 测试项目目录
    * */
    public void createSuiteAssemblyBasicMethod(String fieldFile,String frameworkFile,String projectFile){
        File path = new File("");
        String absolutePath = path.getAbsolutePath();
        System.out.println(absolutePath);
        String fieldFilePath = this.absolutePath+fieldFile;
        File  createFieldFilePath =new File(fieldFilePath);
        System.out.println(createFieldFilePath);
        if(!createFieldFilePath.exists()){//如果文件夹不存在
            createFieldFilePath.mkdir();//创建文件夹
        }

        String mainFilePath = fieldFilePath+"\\"+frameworkFile;
        File  createMainFilePath =new File(mainFilePath);
        System.out.println(mainFilePath);
        if(!createMainFilePath.exists()){//如果文件夹不存在
            createMainFilePath.mkdir();//创建文件夹
        }
        String secondaryFilePath = mainFilePath+"\\"+projectFile;
        File  createSecondaryFilePath =new File(secondaryFilePath);
        if(!createSecondaryFilePath.exists()){//如果文件夹不存在
            createSecondaryFilePath.mkdir();//创建文件夹
        }
    }

    public String getSuiteAssmblyPropertiesValue(String key){
            Properties prop = new Properties();
            String suiteAssmblyPropertiesValue = "";
            String propertiesPath = this.absolutePath+"suiteassembly.properties";
            try {
                prop.load(new FileInputStream(propertiesPath));
                suiteAssmblyPropertiesValue = prop.getProperty(key);
            } catch(IOException e) {
                e.printStackTrace();
            }
            return suiteAssmblyPropertiesValue;
        }

    /*
    * 测试目录集构建集合
    * # {${test.field}:{${test.framework}:[${test.project}]}}
    * */
    public Map<String,Map<String,List<String>>> constructContentAssembly(){
        SuiteAssembly sa = new SuiteAssembly();
        Map<String,Map<String,List<String>>> fieldFrameworksProjectsMap = new HashMap<>();
        Map<String,List<String>> frameworksProjectsMap = new HashMap<>();
        String fields = "test.fields";
        String frameworks = "test.api.frameworks";
        String projects = "test.api.projects";
        String testFields = sa.getSuiteAssmblyPropertiesValue(fields);
        String testFrameworks = sa.getSuiteAssmblyPropertiesValue(frameworks);
        String testProjects = sa.getSuiteAssmblyPropertiesValue(projects);
        String[] testFieldList = testFields.split(",");
        String[] testFrameworkList = testFrameworks.split(",");
        String[] testProjectList = testProjects.split(",");
        List<String> projectsList = new ArrayList<>(Arrays.asList(testProjectList));
        for (String testFramework : testFrameworkList) {
            frameworksProjectsMap.put(testFramework, projectsList);
        }

        for (String testField : testFieldList) {
            fieldFrameworksProjectsMap.put(testField, frameworksProjectsMap);
        }

        return fieldFrameworksProjectsMap;
    }

    /*
    *创建测试框架目录集
     */
    public void createSuiteAssembly(){
        //createSuiteAssemblyBasicMethod(String field,String mainFile,String projectFile)
        SuiteAssembly sa = new SuiteAssembly();
        Map<String,Map<String,List<String>>> fieldFrameworksProjectsMap = sa.constructContentAssembly();
        System.out.println(fieldFrameworksProjectsMap);
        for(Map.Entry<String,Map<String,List<String>>> fieldFrameworksProjects : fieldFrameworksProjectsMap.entrySet()){
            String field = fieldFrameworksProjects.getKey();
            Map<String,List<String>> frameworksProjectsValue = fieldFrameworksProjects.getValue();
            for(Map.Entry<String,List<String>> frameworksProjects : frameworksProjectsValue.entrySet()){
                String framework = frameworksProjects.getKey();
                List<String> projectsValue = frameworksProjects.getValue();
                for (String project : projectsValue) {
                    System.out.println(field+"---"+framework+"---"+project);
                    createSuiteAssemblyBasicMethod(field,framework,project);
                }
            }
        }
    }

    public static void main(String args[]){
        SuiteAssembly sa = new SuiteAssembly();
        sa.createSuiteAssembly();
    }
}
