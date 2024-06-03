package tests.gui.negative;

import baseEntities.BaseUITest;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class DeleteProjectTest extends BaseUITest {
    private final static String pagePath = "admin/projects";

    @Test(description = "delete project with no page refresh test", groups = "negative")
    public void deleteProjectTest() {
        defaultUserLogin();
        open(WebDriverRunner.getWebDriver().getCurrentUrl() + pagePath);
        mAdminProjectStep.removeLastProjectFromTable();
    }
}
