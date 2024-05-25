package tests.api;

import io.qameta.allure.*;
import baseEntities.BaseApiTest;
import configuration.ReadProperties;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ApiPostTest extends BaseApiTest {

    @Test
    @Description("Creates a new automation run in a target project")
    @Severity(SeverityLevel.CRITICAL)
    public void createRunUsingFileTest() {
        int projectID = 29;

        given()
                .body(ReadProperties.class.getClassLoader().getResourceAsStream("CreateNewRun.json"))
                .when()
                .pathParam("projectID", projectID)
                .post(Endpoints.CREATE_NEW_RUN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    @Description("Complete active automation run")
    @Severity(SeverityLevel.CRITICAL)
    public void completeRunUsingFileTest() {
        int runID = 25;

        given()
                .body(ReadProperties.class.getClassLoader().getResourceAsStream("CompleteActiveRun.json"))
                .when()
                .pathParam("runID", runID)
                .post(Endpoints.COMPLETE_ACTIVE_RUN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
