package tests.gui.positive;

import baseEntities.BaseUITest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DialogWindowTest extends BaseUITest {

    @Test(description = "Тест на проверку всплывающего сообщения создания проекта", groups = "positive")
    public void dialogWindowTest() {
        defaultUserLogin();
        mProjectsListStep.openAddProjectDialogWindow();
        Assert.assertEquals(mProjectsListStep.getAddProjectDialogTitleTextWindow(), "Add project");
    }
}
