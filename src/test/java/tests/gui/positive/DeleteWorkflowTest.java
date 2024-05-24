package tests.gui.positive;

import baseEntities.BaseUITest;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class DeleteWorkflowTest extends BaseUITest {
    private final static String pagePath = "admin/workflows";

    @Test(description = "delete workflow test", groups = "positive")
    public void deleteWorkflowTest() {
        defaultUserLogin();
        open(WebDriverRunner.getWebDriver().getCurrentUrl() + pagePath);
        Assert.assertTrue(mAdminProjectStep.removeWorkflowFromTable(), "Ошибка удаления");
    }
}
