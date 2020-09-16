package groups;


import io.qameta.allure.Story;
import org.testng.annotations.Test;
import io.qameta.allure.Link;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;

/*
 *包名:com.kdzwy.practice
 *作者:Adien_cui
 *时间:2017-3-28  下午5:41:26
 *描述:testng分组
 **/
public class Test1 {
    @Test(groups = { "functest", "checkintest" })
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Story("Base support for bdd annotations")
    public void testMethod1() {
        System.out.println("method1checkintest");
    }

    @Test(groups = {"functest", "checkintest"} )
    @Issue("123")
    @Issue("432")
    @Story("Advanced support for bdd annotations")
    public void testMethod2() {
        System.out.println("method2checkintest");
    }

    @Test(groups = { "functest" })
    @TmsLink("test-1")
    @TmsLink("test-2")
    @Story("Base support for bdd annotations")
    @Story("Advanced support for bdd annotations")
    public void testMethod3() {
        System.out.println("method3functest");
    }
}

