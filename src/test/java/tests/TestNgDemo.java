package tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgDemo {

    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }

    @Test (priority = 0)
    public void testZero() {
        System.out.println("Test");
    }

//    @Parameters({"browserName"})
//    @Test(groups = {"Smoke"}, priority = 1)
//    public void testOne(String browserName) {
//        System.out.println(browserName);
//        Assert.fail("test fail");
//    }

    @Test(dependsOnMethods = "testZero", dataProvider = "getData", priority = 2)
    public void testTwo(String browserName, String speed) {
        System.out.println("depend on: " + browserName + "\nspeed: " + speed);
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][] {{"chrome", "Slow"}, {"Firefox", "Fast"}};
    }

}
