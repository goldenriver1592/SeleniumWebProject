package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class NewCustomerPage extends BasePage {

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@name=\"customer[website_id]\"]")
    @CacheLookup
    private WebElement assignSite;

    @FindBy(xpath = "//select[@name=\"customer[group_id]\"]")
    @CacheLookup
    private WebElement group;

    @FindBy(xpath = "//input[@name=\"customer[firstname]\"]")
    @CacheLookup
    private WebElement firstName;

    @FindBy(xpath = "//input[@name=\"customer[lastname]\"]")
    @CacheLookup
    private WebElement lastName;

    @FindBy(xpath = "//input[@name=\"customer[email]\"]")
    @CacheLookup
    private WebElement email;

    @FindBy(id = "save")
    @CacheLookup
    private WebElement saveCustomer;

    @FindBy(xpath = "//div[@data-ui-id=\"messages-message-success\"]")
    @CacheLookup
    private WebElement successMessage;


    public void inputCustomerInformation(String firstNameInput ,String lastNameInput ,String emailInput) {
        waitForVisible(assignSite);
        waitForVisible(firstName);
        waitForVisible(lastName);
        waitForVisible(email);
        waitForVisible(saveCustomer);

        Select assignSiteSelect = new Select(assignSite);
        assignSiteSelect.selectByIndex(0);

        Select groupSelect = new Select(group);
        groupSelect.selectByIndex(1);

        firstName.sendKeys(firstNameInput);
        lastName.sendKeys(lastNameInput);
        email.sendKeys(emailInput);
        saveCustomer.click();
    }

    public boolean verifyInput() {
        waitForVisible(successMessage);
        return successMessage.isDisplayed();
    }
}
