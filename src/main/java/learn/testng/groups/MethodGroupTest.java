package learn.testng.groups;

import org.testng.annotations.Test;

public class MethodGroupTest {
    @Test(groups = { "windows.functest"})
    public void testMethod1() {
        System.out.println("windows下的functest");
    }

    @Test(groups = {"linux.checkintest"} )
    public void testMethod2() {
        System.out.println("linux下的checkintest");
    }

    @Test(groups = { "windows.functest" })
    public void testMethod3() {
        System.out.println("windows下的functest");
    }
}
