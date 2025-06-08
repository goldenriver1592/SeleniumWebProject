package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumDemo {

    @Test
    public void testDemo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "N:\\WebAutomation\\chromedriver-win64\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get("https://github.com/");
        Thread.sleep(1500);
        WebElement title = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(By.tagName("h1"));
                    return element.isDisplayed() ? element : null;
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    return null;
                }
            }
        });
        System.out.println(title.getText());
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header-search-button")));
        searchButton.click();
        WebElement searchText = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#query-builder-test"))));
        searchText.sendKeys("Selenium TestNG");
        searchText.submit();
//        List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[data-testid=\"results-list\"] a")));
//        WebElement firstOne = results.get(1);
//        firstOne.click();
        Thread.sleep(1500);
        WebElement nextBtn = webDriver.findElement(By.xpath("//*[@rel=\"next\"]"));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        js.executeScript("arguments[0].scrollIntoView();", nextBtn);
//        WebElement firstOne = (WebElement) js.executeScript("return document.querySelector('[data-testid=\\\"results-list\\\"] a').click()");
//        nextBtn.click();
        new Actions(webDriver).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
//        webDriver.close();

    }
}
