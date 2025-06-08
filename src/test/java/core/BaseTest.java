package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional("edge") String browserName) {
        driver = DriverFactory.initDriver(browserName);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
        driver = null;
    }

    public WebDriver getDriver() {
        return driver;
    }
}


