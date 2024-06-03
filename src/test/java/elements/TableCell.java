package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TableCell {
    private UIElement uiElement;

    public TableCell(UIElement uiElement) {
        this.uiElement = uiElement;
    }

    public UIElement getAsUIElement() {
        return uiElement;
    }

    public UIElement getLink() {
        return uiElement.findElement(By.tagName("a"));
    }
}