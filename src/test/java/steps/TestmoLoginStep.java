package steps;

import baseEntities.BaseStep;
import models.UserForUITest;
import pages.TestmoAuthPage;

public class TestmoLoginStep extends BaseStep {
    public TestmoLoginStep() {
        super();
    }

    public TestmoAuthPage setTestmoAccount( UserForUITest mUser) {
        mTestmoLoginPage.loginAccountAreaClick();
        mTestmoLoginPage.insertTestmoAccount(mUser.getTestmoAccount());
        mTestmoLoginPage.goButtonClick();
        return mTestmoAuthPage;
    }
}

