package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional("edge") String browserName) throws MalformedURLException {
        DesiredCapabilities caps = CapabilityFactory.getCapabilities(browserName);
        DriverFactory.initDriver(browserName, caps);
        driver = DriverFactory.getDriver();
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


