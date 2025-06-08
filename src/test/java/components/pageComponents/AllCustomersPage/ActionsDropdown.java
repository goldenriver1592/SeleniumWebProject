package components.pageComponents.AllCustomersPage;

import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActionsDropdown extends BaseComponent {

    @FindBy(css = ".col-xs-2 .action-menu-items > * > *  > span:nth-child(1)")
    private List<WebElement> mainItems;

    public ActionsDropdown(WebDriver driver) {
        super(driver);
    }

    public void selectByIndex(int index) {
        List<WebElement> items = mainItems;
        if (index <0 || index > 4) {
            throw new AssertionError("Index must from 0 - 4");
        } else {
            waitForVisible(items.get(index));
            items.get(index).click();
        }
    }

    /** options: Delete, Subscribe to Newsletter, Unsubscribe from the newsletter, Assign customer group, Edit
     *
     * @param text: option
     */
    public void selectByOptionText(String text) {
        List<WebElement> items = mainItems;
        switch (text) {
            case "Delete":
                selectByIndex(0);
                break;
            case "Subscribe to Newsletter":
                selectByIndex(1);
                break;
            case "Unsubscribe from the newsletter":
                selectByIndex(2);
                break;
            case "Assign customer group":
                selectByIndex(3);
                break;
            case "Edit":
                selectByIndex(4);
                break;
            default:
                throw new AssertionError("Option not existing");
        }
    }
}
