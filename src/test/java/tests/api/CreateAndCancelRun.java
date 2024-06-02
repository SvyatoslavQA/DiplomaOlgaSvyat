package tests.api;

import data.StaticProvider;
import io.qameta.allure.*;
import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import configuration.ReadProperties;
import io.restassured.response.Response;
import models.Run;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class CreateAndCancelRun extends BaseApiTest {

    @Test(description = "Creates a new automation run in a target project", dataProvider = "projectNumber", dataProviderClass = StaticProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    public void CreateNewRunTest(int projectID) {

        given()
                .body(ReadProperties.class.getClassLoader().getResourceAsStream("CreateNewRun.json"))
                .when()
                .pathParam("projectID", projectID)
                .post(Endpoints.CREATE_NEW_RUN)
                .then()
                .log().ifError()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test(description = "Checking whether all runs are completed and completing them if not", dataProvider = "projectNumber", dataProviderClass = StaticProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    public void checkAllRunsAndComplete(int projectID) {

        Gson gson = new Gson();

        Response response = given()
                .pathParam("projectID", projectID)
                .get(Endpoints.GET_ALL_RUNS)
                .then()
                .log().ifError()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Run[] actualRunsG = response.getBody().jsonPath().getObject("result", Run[].class);

        for (Run run : actualRunsG) {
            if (!run.isCompleted()) {
                given()
                        .body(ReadProperties.class.getClassLoader().getResourceAsStream("CompleteActiveRun.json"))
                        .when()
                        .pathParam("runID", run.getId())
                        .post(Endpoints.COMPLETE_ACTIVE_RUN)
                        .then()
                        .log().ifError()
                        .statusCode(HttpStatus.SC_NO_CONTENT);
            }
        }

        Response updatedResponse = given()
                .pathParam("projectID", projectID)
                .get(Endpoints.GET_ALL_RUNS)
                .then()
                .log().ifError()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Run[] updatedRunsG = updatedResponse.getBody().jsonPath().getObject("result", Run[].class);

        for (Run run : updatedRunsG) {
            Assert.assertTrue(run.isCompleted());
        }
    }
}
