package learn.java.string;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class string {
    public String getPath(){
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
        String a = f.toString();
        return a;
    }
    public static void main(String args[]) throws IOException {
        String path = System.getProperty("user.dir");
        String b = "classes";
        string s = new string();
        String t = s.getPath();
        System.out.println(t);

    }
}
