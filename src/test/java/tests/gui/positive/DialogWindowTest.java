package tests.gui.positive;

import baseEntities.BaseUITest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DialogWindowTest extends BaseUITest {

    @Test(description = "Dialog popup test", groups = "positive")
    public void dialogWindowTest() {
        defaultUserLogin();
        mProjectsListStep.openAddProjectDialogWindow();
        Assert.assertEquals(mProjectsListStep.getAddProjectDialogTitleTextWindow(), "Add project");
    }
}
