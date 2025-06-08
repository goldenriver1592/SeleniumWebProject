package tests;

import core.BaseTest;
import org.testng.annotations.Test;

public class DemoTest extends BaseTest {

    @Test
    public void TestOne() {
        System.out.println("This is test number 1");
    }

    @Test
    public void testLogin() {
        driver.get("https://google.com/");
        System.out.println("Running on browser: " + driver);
    }
}
