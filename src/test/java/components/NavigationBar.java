package components;

import components.navigationMenu.*;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends BaseComponent {

    public DashBoardMenu dashBoardMenu;
    public SalesVolumeMenu salesVolumeMenu;
    public CatalogMenu catalogMenu;
    public CustomersMenu customersMenu;
    public MarketingMenu marketingMenu;
    public StoresMenu storesMenu;


    @FindBy(xpath = "//li[@id='menu-magento-sales-sales']//span")
    @CacheLookup
    private WebElement salesMenuElement;

    @FindBy(xpath = "//li[@id='menu-magento-catalog-catalog']//span")
    @CacheLookup
    private WebElement catalogMenuElement;

    @FindBy(xpath = "//li[@id='menu-magento-customer-customer']//span")
    @CacheLookup
    private WebElement customerMenuElement;

    @FindBy(xpath = "//li[@id='menu-magento-backend-marketing']//span")
    @CacheLookup
    private WebElement marketingMenuElement;

    @FindBy(xpath = "//li[@id='menu-magento-backend-stores']//span")
    @CacheLookup
    private WebElement storesMenuElement;

    public NavigationBar(WebDriver driver) {
        super(driver);
        this.dashBoardMenu = new DashBoardMenu(driver);
        this.salesVolumeMenu = new SalesVolumeMenu(driver);
        this.catalogMenu = new CatalogMenu(driver);
        this.customersMenu = new CustomersMenu(driver);
        this.marketingMenu = new MarketingMenu(driver);
        this.storesMenu = new StoresMenu(driver);
    }

    public void clickOnCustomerMenu() {
        waitForVisible(customerMenuElement);
        clickByJs(customerMenuElement);
    }

    public void clickOnCatalogMenu() {
        waitForVisible(catalogMenuElement);
        clickByJs(catalogMenuElement);
    }

    public void clickOnStoresMenu() {
        waitForVisible(storesMenuElement);
        clickByJs(storesMenuElement);
    }

    public void clickOnOrderInSalesMenu() {
        waitForVisible(salesMenuElement);
        clickByJs(salesMenuElement);
    }

    public void clickOnCatalogPriceRuleMenu() {
        waitForVisible(marketingMenuElement);
        clickByJs(marketingMenuElement);
    }

    public void clickOnAllStoresMenu() {
        waitForVisible(storesMenuElement);
        clickByJs(storesMenuElement);
    }
}
