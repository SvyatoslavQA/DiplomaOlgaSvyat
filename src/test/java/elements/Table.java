package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private UIElement uiElement;
    private List<String> columns;


    public Table(By by) {
        this.uiElement = new UIElement(by);
        this.columns = new ArrayList<>();
        for (UIElement element : uiElement.findUIElements(By.tagName("th"))) {
            columns.add(element.getText());
        }
    }

    public Table(WebElement webElement) {
        this.uiElement = new UIElement(webElement);
    }

    public TableCell getCell(int columnIndex, int rowIndex) {
        TableRow tableRow = getRow(rowIndex);
        return tableRow.getCell(columnIndex);
    }

    public TableCell getCell(String columnName, int rowIndex) {
        int columnIndex = columns.indexOf(columnName);
        return getCell(columnIndex, rowIndex);
    }

    public List<String> getColumns() {
        return columns;
    }

    public TableRow getRow(int index) {
        ArrayList<UIElement> list = (ArrayList<UIElement>) uiElement.findUIElements(By.tagName("tr"));
        return new TableRow(list.get(index));
    }

    public int getRowSize() {
        ArrayList<UIElement> list = (ArrayList<UIElement>) uiElement.findUIElements(By.tagName("tr"));
        return list.size();
    }
}