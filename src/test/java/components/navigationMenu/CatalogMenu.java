package components.navigationMenu;

import components.base.BaseMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CatalogMenu extends BaseMenu {

    @FindBy(xpath = "//li[@data-ui-id=\"menu-magento-catalog-catalog-products\"]//span")
    @CacheLookup
    private WebElement productsMenu;

    public CatalogMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnProductsMenu() {
        waitForVisible(productsMenu);
        clickByJs(productsMenu);
    }
}
