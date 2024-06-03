package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.Condition;
import elements.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AdminProjectPage extends BasePage {

    private final By tableLocator = By.xpath("//*[@data-target='components--table.table']");
    private final By removeDialogLocator = By.xpath("//*[@class='dialog dialog--negative dialog--compact']");
    private final By approveRemoveCheckBoxLocator = By.xpath("//*[@class='ui checkbox']");
    private final By approveRemoveButtonLocator = By.xpath("//*[@class='ui negative button']");

    public AdminProjectPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return tableLocator;
    }

    public WebElement getRemoveDialogLocator() {
        return $(removeDialogLocator);
    }

    public WebElement getApproveRemoveCheckBoxLocator() {
        return $(approveRemoveCheckBoxLocator);
    }

    public WebElement getApproveRemoveButtonLocator() {
        return $(approveRemoveButtonLocator);
    }

    public int parseTable() {
        Table table = new Table(tableLocator);
        int startTableRowSize = table.getRowSize();
        if (startTableRowSize > 1) {
            table.getCell(table.getColumns().size() - 2, startTableRowSize - 1).getAsUIElement().click();
        }
        return startTableRowSize;
    }

    public int calculateTableRows() {
        Table table = new Table(tableLocator);
        return table.getRowSize();
    }

    public void isDialogVisible() {
        $(getRemoveDialogLocator()).shouldBe(Condition.visible);
    }

    private void disableCheckBox() {
        if (getApproveRemoveCheckBoxLocator().isSelected() == false) {
            getApproveRemoveCheckBoxLocator().click();
        }
    }

    private void removeButtonClick() {
        $(getRemoveDialogLocator()).shouldBe(Condition.enabled);
        getApproveRemoveButtonLocator().click();
    }

    public void removeProject() {
        disableCheckBox();
        removeButtonClick();
    }

    public int removeWorkflow() {
        removeButtonClick();
        synchronized (getWebDriver()) {
            try {
                getWebDriver().wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return calculateTableRows();
    }
}