package tests.gui.positive;

import baseEntities.BaseUITest;
import com.codeborne.selenide.WebDriverRunner;
import data.BoundaryValues;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class BoundaryProjectTest extends BaseUITest {

    @Test(description = "Boundary value test", groups = "positive")
    public void boundaryProjectTest() {
        defaultUserLogin();
        mProjectsListStep.openAddProjectDialogWindow();
        Assert.assertEquals(mProjectsListStep.createProject(BoundaryValues.EMPTY_NEGATIVE.getSize()), "The name field is required.");
        Assert.assertEquals(mProjectsListStep.createProject(BoundaryValues.START_POSITIVE.getSize()), "");
        open(WebDriverRunner.getWebDriver().getCurrentUrl());
        mProjectsListStep.openAddProjectDialogWindow();
        Assert.assertEquals(mProjectsListStep.createProject(BoundaryValues.MIDDLE_POSITIVE.getSize()), "");
        open(WebDriverRunner.getWebDriver().getCurrentUrl() );
        mProjectsListStep.openAddProjectDialogWindow();
        Assert.assertEquals(mProjectsListStep.createProject(BoundaryValues.END_POSITIVE.getSize()), "");
        open(WebDriverRunner.getWebDriver().getCurrentUrl());
        mProjectsListStep.openAddProjectDialogWindow();
        Assert.assertEquals(mProjectsListStep.createProject(BoundaryValues.RANGE_NEGATIVE.getSize()), "The name may not be greater than 750 characters.");
    }
}
