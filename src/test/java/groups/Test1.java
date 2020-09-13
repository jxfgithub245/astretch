package groups;


import org.testng.annotations.Test;

/*
 *包名:com.kdzwy.practice
 *作者:Adien_cui
 *时间:2017-3-28  下午5:41:26
 *描述:testng分组
 **/
public class Test1 {
    @Test(groups = { "functest", "checkintest" })
    public void testMethod1() {
        System.out.println("method1checkintest");
    }

    @Test(groups = {"functest", "checkintest"} )
    public void testMethod2() {
        System.out.println("method2checkintest");
    }

    @Test(groups = { "functest" })
    public void testMethod3() {
        System.out.println("method3functest");
    }
}

