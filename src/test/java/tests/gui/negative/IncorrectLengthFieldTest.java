package tests.gui.negative;

import baseEntities.BaseUITest;
import data.BoundaryValues;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class IncorrectLengthFieldTest extends BaseUITest {

    @Test(description = "Тест на ввод данных превышающих допустимые", groups = "negative")
    public void incorrectLengthFieldTest() {
        defaultUserLogin();
        mProjectsListStep.openAddProjectDialogWindow();
        Assert.assertEquals(mProjectsListStep.createProject(BoundaryValues.RANGE_NEGATIVE.getSize()), "The name may not be greater than 750 characters.");
    }
}
