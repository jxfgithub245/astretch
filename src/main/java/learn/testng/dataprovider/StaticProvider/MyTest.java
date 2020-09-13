package learn.testng.dataprovider.StaticProvider;

import org.testng.annotations.Test;

public class MyTest {
    @Test(dataProvider = "create", dataProviderClass = StaticProvider.class)
    public void test(Integer n) {
        System.out.println(n);
    }
}

