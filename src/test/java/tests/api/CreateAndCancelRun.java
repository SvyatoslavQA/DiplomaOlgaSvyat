package tests.api;

import data.StaticProvider;
import io.qameta.allure.*;
import baseEntities.BaseApiTest;

import io.restassured.response.Response;
import models.Run;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAndCancelRun extends BaseApiTest {

    @Test(description = "Creates a new automation run in a target project", dataProvider = "projectNumber", dataProviderClass = StaticProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    public void CreateNewRunTest(int projectID) {
        runsServices.createRunUsingFile(projectID);
    }

    @Test(description = "Checking whether all runs are completed and completing them if not", dataProvider = "projectNumber", dataProviderClass = StaticProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    public void checkAllRunsAndComplete(int projectID) {

        Response response = runsServices.getAllRuns(projectID);
        Run[] actualRunsG = response.getBody().jsonPath().getObject("result", Run[].class);

        for (Run run : actualRunsG) {
            if (!run.isCompleted()) {
                runsServices.completeRunUsingFile(run.getId());
            }
        }

        Response updatedResponse = runsServices.getAllRuns(projectID);
        Run[] updatedRunsG = updatedResponse.getBody().jsonPath().getObject("result", Run[].class);

        for (Run run : updatedRunsG) {
            Assert.assertTrue(run.isCompleted());
        }
    }
}
