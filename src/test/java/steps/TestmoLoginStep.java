package steps;

import baseEntities.BaseStep;
import models.UserForUITest;
import pages.TestmoAuthPage;

public class TestmoLoginStep extends BaseStep {
    public TestmoLoginStep() {
        super();
    }

    public TestmoAuthPage setTestmoAccount( UserForUITest mUser) {
        LoginPage.loginAccountAreaClick();
        LoginPage.insertTestmoAccount(mUser.getTestmoAccount());
        LoginPage.goButtonClick();
        return AuthPage;
    }
}

