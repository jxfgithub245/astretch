package learn.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @DataProvider(name = "test2")
    public Object[][] createData1() {
        return new Object[][] {
                { "Cedric", new Integer(36) },
                { "Anne", new Integer(37)},
        };
    }

    //This test method declares that its data should be supplied by the Data Provider
//named "test1"
    @Test(dataProvider = "test2")
    public void verifyData1(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }

}
