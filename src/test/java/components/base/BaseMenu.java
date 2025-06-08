package components.base;

import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public abstract class BaseMenu extends BaseComponent {

    @FindBy(className = "submenu-title")
    @CacheLookup
    WebElement submenuTitle;

    @FindBy(css = "action-close")
    @CacheLookup
    WebElement closeButton;

    public BaseMenu(WebDriver driver) {
        super(driver);
    }
}
