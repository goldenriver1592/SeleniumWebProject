package components.navigationMenu;

import components.base.BaseMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SalesVolumeMenu extends BaseMenu {

    @FindBy(css = ".item-sales-order span")
    @CacheLookup
    WebElement orders;

    @FindBy(css = "item-paymentservicesdashboard span")
    @CacheLookup
    WebElement paymentServices;

    @FindBy(css = ".item-idealo-order span")
    @CacheLookup
    WebElement idealOder;

    @FindBy(css = ".item-sales-invoice span")
    @CacheLookup
    WebElement invoices;

    @FindBy(css = ".item-sales-shipment span")
    @CacheLookup
    WebElement shipments;

    @FindBy(css = ".item-sales-creditmemo span")
    @CacheLookup
    WebElement credits;

    @FindBy(css = ".item-paypal-billing-agreement span")
    @CacheLookup
    WebElement billingAgreement;

    @FindBy(css = ".item-sales-transactions span")
    @CacheLookup
    WebElement transactions;

    @FindBy(css = ".item-virtual-terminal span")
    @CacheLookup
    WebElement virtualTerminal;

    public SalesVolumeMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnOrderInSalesMenu() {
        waitForVisible(orders);
        clickByJs(orders);
    }


}
