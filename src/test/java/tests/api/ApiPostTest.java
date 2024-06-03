package tests.api;

import io.qameta.allure.*;
import baseEntities.BaseApiTest;
import org.testng.annotations.Test;

public class ApiPostTest extends BaseApiTest {

    @Test(description = "Creates a new automation run in a target project")
    @Severity(SeverityLevel.CRITICAL)
    public void createRunUsingFileTest() {
        int projectID = 29;
        runsServices.createRunUsingFile(projectID);
    }

    @Test(description = "Complete active automation run")
    @Severity(SeverityLevel.CRITICAL)
    public void completeRunUsingFileTest() {
        int runID = 72;
        runsServices.completeRunUsingFile(runID);
    }
}
