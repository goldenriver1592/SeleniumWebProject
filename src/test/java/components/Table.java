package components;

import core.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Table extends BaseComponent {

    @FindBy(css = "[data-role='grid-wrapper'] .data-grid")
    private WebElement tableRoot;

    @FindBy(css = "[data-role='grid-wrapper'] .data-grid tr")
    private List<WebElement> rowLocators;

    private final By checkboxInRow = By.cssSelector("input[type='checkbox']");

    private final By cellTextLocator = By.cssSelector("td:nth-child(3)");

    public Table(WebDriver driver) {
        super(driver);
    }

    public void waitUntilTableVisible() {
        waitForVisible(tableRoot);
    }

    public void selectCheckboxByText(String targetText) {
        List<WebElement> rows = rowLocators;
        for (WebElement row : rows) {
            WebElement nameValue;
            try {
                nameValue = row.findElement(cellTextLocator);
            } catch (Exception e) {
                continue;
            }
            String rowText = nameValue.getText().trim();
            if (rowText.equalsIgnoreCase(targetText)) {
                WebElement checkbox = row.findElement(checkboxInRow);
                if (!checkbox.isSelected()) {
                    checkbox.click();
                    break;
                }
                break;
            }
        }
    }

    public List<String> getSelectedRowsText() {
        List<String> result = new ArrayList<>();
        List<WebElement> rows = rowLocators;
        for (WebElement row : rows) {
            WebElement nameValue;
            try {
                nameValue = row.findElement(cellTextLocator);
            } catch (Exception e) {
                continue;
            }
            String text = nameValue.getText().trim();
            if (!text.isEmpty()) {
                result.add(nameValue.getText().trim());
            }
        }
        return result;
    }
}
