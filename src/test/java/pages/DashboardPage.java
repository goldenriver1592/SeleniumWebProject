package pages;

import components.NavigationBar;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    @CacheLookup
    private WebElement tittle;

    public boolean verifyLoginSuccess(String tittlePage) {
        waitForVisible(tittle);
        return tittle.getText().equals(tittlePage);
    }

}
