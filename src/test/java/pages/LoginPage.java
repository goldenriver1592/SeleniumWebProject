package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "logo-img")
    @CacheLookup
    private WebElement logo;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement username;

    @FindBy(id = "login")
    @CacheLookup
    private WebElement password;

    @FindBy(className = "action-forgotpassword")
    @CacheLookup
    private WebElement forgotPWLink;

    @FindBy(css = ".action-login")
    @CacheLookup
    private WebElement loginButton;

    public boolean isAllLoginLocatorsDisplay() {
        List<WebElement> loginElements = Arrays.asList(logo, username, password, forgotPWLink, loginButton);
        return allElementsDisplay(loginElements);
    }

    public void login(String usernameInput, String passwordInput) {
        clearAndInput(usernameInput,username);
        clearAndInput(passwordInput,password);
        loginButton.click();
    }
}
