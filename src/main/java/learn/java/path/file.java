package learn.java.path;

import java.io.File;
import java.io.IOException;

public class file {
    public void getPath(){
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
    }
    public static void main(String args[]) throws IOException {
        File file = new File("/");
        System.out.println("/ 代表的绝对路径为：" + file.getAbsolutePath());
        File file2 = new File("");
        String a = file2.getCanonicalPath();
        System.out.println("CanonicalPath"+a);
        System.out.println("user.dir"+System.getProperty("user.dir"));
        File f = new File(file.class.getResource("").getPath());
        System.out.println(f);
        file f2 = new file();
        System.out.println(file2.getPath());

    }
}
