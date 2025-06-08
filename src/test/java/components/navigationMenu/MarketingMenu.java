package components.navigationMenu;

import components.base.BaseMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MarketingMenu extends BaseMenu {

    @FindBy(xpath = "//li[@data-ui-id=\"menu-magento-catalogrule-promo-catalog\"]//span")
    @CacheLookup
    private WebElement catalogPriceRuleMenu;

    public MarketingMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnCatalogPriceRuleMenu() {
        waitForVisible(catalogPriceRuleMenu);
        clickByJs(catalogPriceRuleMenu);
    }
}
