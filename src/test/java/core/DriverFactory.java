package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> tlWait = new ThreadLocal<>();
    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);

    public static void initDriver(String runMode, String browserName, DesiredCapabilities caps) throws MalformedURLException {

        if (runMode.equalsIgnoreCase("grid")) {
            try {
                String hubHost = System.getProperty("hub.host", "localhost");
                String hubPort = System.getProperty("hub.port", "4444");
                URL gridUrl = new URL("http://" + hubHost + ":" + hubPort + "/wd/hub");
                System.out.println("Grid URL: " + gridUrl);
                tlDriver.set(new RemoteWebDriver(gridUrl, caps));
                tlWait.set(new WebDriverWait(tlDriver.get(), Duration.ofSeconds(20)));
            } catch (SessionNotCreatedException e) {
                log.error("Session Not Created Exception: ", e);
            }
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
