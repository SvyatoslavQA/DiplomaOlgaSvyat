package tests.gui.positive;

import baseEntities.BaseUITest;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseUITest {

    @Test(description = "Project creation test", groups = "positive")
    public void createProjectTest() {
        defaultUserLogin();
        mProjectsListStep.openAddProjectDialogWindow();
        mProjectsListStep.createProject(DataHelper.getProject()).isPageOpened();
    }
}
