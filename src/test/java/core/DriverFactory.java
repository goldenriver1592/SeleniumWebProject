package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> tlWait = new ThreadLocal<>();

    public static void initDriver(String browserName, DesiredCapabilities caps) throws MalformedURLException {
        String runMode = System.getProperty("runMode", "local");

        if (runMode.equalsIgnoreCase("grid")) {
            tlDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
            tlWait.set(new WebDriverWait(tlDriver.get(), Duration.ofSeconds(20)));
        } else {
            WebDriver driver = switch (browserName.toLowerCase()) {
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    yield new FirefoxDriver();
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    yield new EdgeDriver();
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    yield new ChromeDriver();
                }
            };
            tlDriver.set(driver);
        }
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }
}
