package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public abstract class BaseUIObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseUIObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void waitForVisible(WebElement webElement) {
        waitForPageLoaded();
        waitForJQueryComplete();
        waitForElementToStopMoving(webElement);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForPageLoaded() {
        wait.until(
                webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState"), "complete")
        );
    }

    public void waitForJQueryComplete() {
        wait.until(
                webDriver -> (Boolean) ((JavascriptExecutor) webDriver)
                        .executeScript("return typeof jQuery != 'undefined' && jQuery.active === 0;")
        );
    }

    public void waitUntilPageStable() {
        waitForPageLoaded();
        waitForJQueryComplete();
    }

    public void waitForElementToStopMoving(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> {
            Point p1 = element.getLocation();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Point p2 = element.getLocation();
            return p1.equals(p2);
        });
    }


    public void clickByJs(WebElement webElement) {
        if (webElement.isDisplayed() && webElement.isEnabled()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", webElement);
        } else {
            throw new IllegalStateException("Element is not be able to click by JS");
        }
    }
}
