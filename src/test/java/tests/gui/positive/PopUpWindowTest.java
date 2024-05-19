package tests.gui.positive;

import baseEntities.BaseUITest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopUpWindowTest extends BaseUITest {

    @Test(description = "Тест на проверку всплывающего сообщения создания проекта", groups = "positive")
    public void popUpTest() {
        defaultUserLogin();
        mProjectsListStep.openAddProjectDialogWindow();
        Assert.assertEquals(mProjectsListStep.getAddProjectDialogPopUpText(),
                "You can assign project-specific permissions to users and groups. All users without project-specific permissions automatically use this configured default access (e.g. their global role).");
    }
}
