package pages;

import components.Table;
import components.pageComponents.AllCustomersPage.ActionsDropdown;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AllCustomersPage extends BasePage {

    public Table customersTable;
    public ActionsDropdown actionsDropdown;

    @FindBy(xpath = "//button[@id=\"add\"]")
    @CacheLookup
    private WebElement addNewCustomer;

    @FindBy(xpath = "(//input[@id=\"fulltext\"])[1]")
    @CacheLookup
    private WebElement searchBox;

    @FindBy(xpath = "//td//a[@class=\"action-menu-item\"]")
    @CacheLookup
    private WebElement toEditButton;

    @FindBy(css = ".col-xs-2 .action-select")
    @CacheLookup
    private WebElement actionsButton;

    @FindBy(css = ".action-accept")
    private WebElement okButton;

    public AllCustomersPage(WebDriver driver) {
        super(driver);
        this.customersTable = new Table(driver);
        this.actionsDropdown = new ActionsDropdown(driver);
    }

    public void clickOnAddNewCustomer() {
        waitForVisible(addNewCustomer);
        addNewCustomer.click();
    }

    public void clickOnToEditButton() {
        waitForVisible(toEditButton);
        toEditButton.click();
    }

    public void inputSearchKey(String searchValue) {
        waitForVisible(searchBox);
        searchBox.clear();
        searchBox.sendKeys(searchValue);
    }

    public void deleteSelectedCustomer() {
        waitForVisible(actionsButton);
        if (customersTable.getSelectedRowsText().isEmpty()) {
            throw new AssertionError("Did not select an user");
        } else {
            waitForVisible(actionsButton);
            actionsButton.click();
            actionsDropdown.selectByOptionText("Delete");
            waitForVisible(okButton);
            okButton.click();
        }
    }
}
