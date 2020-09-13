package learn.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Iterator;

public class IteratorObject {
    @DataProvider(name = "dp",parallel = true)
    public Object[][] createData(Method m) {
        System.out.println(m.getName());  // print test method name
        return new Object[][] { new Object[] { "Cedric" }};
    }

    @Test(dataProvider = "dp")
    public void test2(String s) {
        System.out.println(s);
    }

    @Test(dataProvider = "dp")
    public void test3(String s) {
        System.out.println(s);
    }


}
