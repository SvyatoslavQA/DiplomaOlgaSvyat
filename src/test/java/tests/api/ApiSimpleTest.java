package tests.api;

import io.qameta.allure.*;
import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Arrays;

public class ApiSimpleTest extends BaseApiTest {
    User expectedUser;

    @BeforeClass
    public void setupTestData() {
        expectedUser = User.builder()
                .id(2)
                .name("Volha")
                .email("lela_lela@mail.ru")
                .type(3)
                .isApi(false)
                .roleId(4)
                .build();
    }

    @Test(description = "Get current user info")
    @Severity(SeverityLevel.MINOR)
    public void getUserTest() {
        usersServices.getUser();
    }

    @Test(description = "Get list all users")
    @Severity(SeverityLevel.NORMAL)
    public void getAllUsersTest() {
        usersServices.getUser();
    }

    @Test(description = "Get info about user by user id")
    @Severity(SeverityLevel.NORMAL)
    public void getSecondUserTest() {
        int userID = 1;
        usersServices.getUserByID(userID);
    }

    @Test(description = "Get info about special user from list")
    @Severity(SeverityLevel.CRITICAL)
    public void getSpecialUserFromList() {
        Response response = usersServices.getUserListResponse();
        User[] actualUsers = response.getBody().jsonPath().getObject("result", User[].class);

        Assert.assertTrue(Arrays.asList(actualUsers).contains(expectedUser));
    }

    @Test(description = "Get all projects runs")
    @Severity(SeverityLevel.MINOR)
    public void getAllProjectRunsTest() {
        int projectID = 29;
        runsServices.getAllProjectRuns(projectID);
    }

    @Test(description = "Try creating a new rub in a project that doesn't exist")
    @Severity(SeverityLevel.MINOR)
    public void createRunNegativeTest() {
        int projectID = 13;
        runsServices.createRunUsingFileNeg(projectID);
    }

    @Test(description = "Complete already completed run")
    @Severity(SeverityLevel.CRITICAL)
    public void completeRunUsingFileNeg() {
        int runID = 1;
        runsServices.completeRunUsingFile(runID);
    }

    @Test(description = "Creates a new automation run in a target project")
    @Severity(SeverityLevel.CRITICAL)
    public void createRunUsingFileTest() {
        int projectID = 1;
        runsServices.createRunUsingFile(projectID);
    }

    @Test(description = "Complete active automation run. Negative.")
    @Severity(SeverityLevel.CRITICAL)
    public void completeRunUsingFileTest() {
        int runID = 88;
        runsServices.completeRunUsingFile(runID);
    }
}



