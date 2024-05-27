package tests.gui.negative;

import baseEntities.BaseUITest;
import helper.DataHelper;
import models.UserForUITest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncorrectDataTest extends BaseUITest {

    @Test(description = "Incorrect data during login test", groups = "negative")
    public void incorrectDataTest() {
        UserForUITest mUser = DataHelper.getFirsCorrectUser();
        mStartStep.loginButtonClick().isPageOpened();
        mTestmoLoginStep.setTestmoAccount(mUser).isPageOpened();
        Assert.assertEquals(mTestmoAuthStep.loginWithIncorrectData(mUser), "The email must be a valid email address.");
    }
}
