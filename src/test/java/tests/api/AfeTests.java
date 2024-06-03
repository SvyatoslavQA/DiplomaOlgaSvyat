package tests.api;

import baseEntities.BaseApiTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class AfeTests extends BaseApiTest {
    @Test(description = "Try creating a new rub in a project that doesn't exist")
    @Severity(SeverityLevel.MINOR)
    public void createRunNegativeTest() {
        int projectID = 1;
        runsServices.createRunUsingFileNeg(projectID);
    }

    @Test(description = "Complete already completed run")
    @Severity(SeverityLevel.CRITICAL)
    public void completeCompletedRunTest() {
        int runID = 25;
        runsServices.completeRunUsingFile(runID);
    }
}
