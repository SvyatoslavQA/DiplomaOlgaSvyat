package steps;

import baseEntities.BaseStep;
import models.UserForUITest;
import pages.ProjectsListPage;

public class TestmoAuthStep extends BaseStep {
    public TestmoAuthStep() {
        super();
    }

    public ProjectsListPage login(UserForUITest user) {
        mTestmoAuthPage.insertTestmoLoginAndPassword(user);
        mTestmoAuthPage.disableCheckBox();
        mTestmoAuthPage.loginButtonClick();
        return mProjectsListPage;
    }

    public String loginWithIncorrectData(UserForUITest user) {
        mTestmoAuthPage.insertTestmoLoginAndPasswordIncorrectData(user);
        mTestmoAuthPage.disableCheckBox();
        return mTestmoAuthPage.loginButtonIncorrectDataClick();
    }
}

