package core;

import org.openqa.selenium.WebDriver;

public abstract class BaseComponent extends BaseUIObject{
    public BaseComponent(WebDriver driver) {
        super(driver);
    }
}
