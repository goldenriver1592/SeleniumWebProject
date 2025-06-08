package components.navigationMenu;

import components.base.BaseMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomersMenu extends BaseMenu {

    @FindBy(xpath = "//li[@data-ui-id=\"menu-magento-customer-customer-manage\"]//span")
    @CacheLookup
    private WebElement allCustomersMenu;

    public CustomersMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnAllCustomersMenu() {
        waitForVisible(allCustomersMenu);
        clickByJs(allCustomersMenu);
    }
}
