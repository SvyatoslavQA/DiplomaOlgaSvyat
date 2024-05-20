package steps;

import baseEntities.BaseStep;
import models.UserForUITest;
import pages.ProjectsListPage;

public class TestmoAuthStep extends BaseStep {
    public TestmoAuthStep() {
        super();
    }

    public ProjectsListPage login(UserForUITest user) {
        AuthPage.insertTestmoLoginAndPassword(user);
        AuthPage.disableCheckBox();
        AuthPage.loginButtonClick();
        return ProjectsListPage;
    }

    public String loginWithIncorrectData(UserForUITest user) {
        AuthPage.insertTestmoLoginAndPasswordIncorrectData(user);
        AuthPage.disableCheckBox();
        return AuthPage.loginButtonIncorrectDataClick();
    }
}

