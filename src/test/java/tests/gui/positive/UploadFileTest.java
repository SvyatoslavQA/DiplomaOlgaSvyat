package tests.gui.positive;

import baseEntities.BaseUITest;
import data.DataProviderForUploadImage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileTest extends BaseUITest {


    @Test(description = "Upload file during project creation test",
            groups = "positive",
            dataProvider = "Data for upload image",
            dataProviderClass = DataProviderForUploadImage.class)
    public void handleUploadFileTest(String path) {
        defaultUserLogin();
        mProjectsListStep.openAddProjectDialogWindow();
        mProjectsListStep.uploadImage(path);
        Assert.assertTrue(mProjectsListStep.checkSuccessUpload());
    }
}
