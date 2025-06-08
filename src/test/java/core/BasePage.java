package core;

import components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BasePage extends BaseUIObject {

    public NavigationBar navigationBar;

    public BasePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public boolean allElementsDisplay(List<WebElement> listElement) {
        boolean displayAll = true;
        for (WebElement element : listElement) {
            if (!element.isDisplayed()) {
                System.out.println(element + " is not displayed");
                displayAll = false;
            }
        }
        return displayAll;
    }

    public void clearAndInput(String inputValue, WebElement webElement) {
        waitForVisible(webElement);
        webElement.clear();
        webElement.sendKeys(inputValue);
    }
}

