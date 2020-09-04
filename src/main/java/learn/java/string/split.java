package learn.java.string;

public class split {

    public static void main(String args[]){
        String testfield = "apitest,androidtest";
        String[] a = testfield.split(",");
        System.out.println(a[0]+a[1]+a.length);
    }
}
