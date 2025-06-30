package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeMethod
    @Parameters({"runMode", "browserName"})
    public void setUp(@Optional("grid") String runMode, @Optional("chrome") String browserName) throws MalformedURLException {
        DesiredCapabilities caps = CapabilityFactory.getCapabilities(browserName);
        DriverFactory.initDriver(runMode, browserName, caps);
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
        WebDriver driver = null;
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}


