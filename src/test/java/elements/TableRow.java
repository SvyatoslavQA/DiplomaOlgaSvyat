package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TableRow {
    private UIElement uiElement;

    public TableRow(By by) {
        this.uiElement = new UIElement(by);
    }

    public TableRow(UIElement uiElement) {
        this.uiElement = uiElement;
    }

    public TableCell getCell(int index) {
        ArrayList<UIElement> list = (ArrayList<UIElement>) uiElement.findUIElements(By.xpath("td"));
        return new TableCell(list.get(index));
    }
}