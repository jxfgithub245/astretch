package test;

import java.io.File;

public class SuiteAssembly {


    //创建测试框架主目录
    public void createFile(String field,String mainFile,String secondaryFile){
        File path = new File("");
        String absolutePath = path.getAbsolutePath();
        System.out.println(absolutePath);
        String fieldFilePath = absolutePath+"\\src\\main\\java\\test\\"+field;
        File  createFieldFilePath =new File(fieldFilePath);
        System.out.println(createFieldFilePath);
        if(!createFieldFilePath.exists()){//如果文件夹不存在
            createFieldFilePath.mkdir();//创建文件夹
        }

        String mainFilePath = fieldFilePath+"\\"+mainFile;
        File  createMainFilePath =new File(mainFilePath);
        System.out.println(mainFilePath);
        if(!createMainFilePath.exists()){//如果文件夹不存在
            createMainFilePath.mkdir();//创建文件夹
        }
        String secondaryFilePath = mainFilePath+"\\"+secondaryFile;
        File  createSecondaryFilePath =new File(secondaryFilePath);
        if(!createSecondaryFilePath.exists()){//如果文件夹不存在
            createSecondaryFilePath.mkdir();//创建文件夹
        }
    }

    public static void main(String args[]){
        SuiteAssembly sa = new SuiteAssembly();
        String field = "apitest";
        String mainFile = "database";
        String secondaryFile = "project";
        sa.createFile(field,mainFile,secondaryFile);
    }
}
