package tests.api;

import io.qameta.allure.*;
import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Arrays;

public class ApiGetTest extends BaseApiTest {
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
}


