package components.navigationMenu;

import components.base.BaseMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class StoresMenu extends BaseMenu {

    @FindBy(xpath = "//li[@data-ui-id=\"menu-magento-catalog-catalog-attributes-attributes\"]//span")
    @CacheLookup
    private WebElement productsInStoresMenu;

    @FindBy(xpath = "//li[@data-ui-id=\"menu-magento-backend-system-store\"]//span")
    @CacheLookup
    private WebElement allStoresMenu;

    public StoresMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnProductInStoresMenu() {
        waitForVisible(productsInStoresMenu);
        clickByJs(productsInStoresMenu);
    }

    public void clickOnAllStoresMenu() {
        waitForVisible(allStoresMenu);
        clickByJs(allStoresMenu);
    }
}
