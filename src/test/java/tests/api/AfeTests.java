package tests.api;

import baseEntities.BaseApiTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class AfeTests extends BaseApiTest {
    @Test(description = "Get for deleted project")
    @Description("Get for deleted project")
    @Severity(SeverityLevel.MINOR)
    public void getForDeletedProjectTest() {
        int projectID = 1;

        given()
                .when()
                .pathParam("projectID", projectID)
                .get(Endpoints.CREATE_NEW_RUN)
                .then().log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test(description = "Complete already completed run")
    @Description("Complete already completed run")
    @Severity(SeverityLevel.CRITICAL)
    public void completeCompletedRunTest() {
        int runID = 25;

        given()
                .body(ReadProperties.class.getClassLoader().getResourceAsStream("CompleteActiveRun.json"))
                .when()
                .pathParam("runID", runID)
                .post(Endpoints.COMPLETE_ACTIVE_RUN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }
}
