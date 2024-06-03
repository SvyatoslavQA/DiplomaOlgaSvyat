package services;

import configuration.ReadProperties;
import models.Run;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class RunsServices implements IRunsServices {
    protected Logger logger = LogManager.getLogger(this);

    @Override
    public Run completeRunUsingFile(int runID) {
        logger.info("Post complete active automation run");
        return given()
                .body(ReadProperties.class.getClassLoader().getResourceAsStream("CompleteActiveRun.json"))
                .when()
                .pathParam("runID", runID)
                .post(Endpoints.COMPLETE_ACTIVE_RUN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .extract()
                .as(Run.class);
    }

    @Override
    public Run getAllProjectRuns(int projectID) {
        logger.info("Get RS with all runs");
        return given()
                .when()
                .pathParam("projectID", projectID)
                .get(Endpoints.CREATE_NEW_RUN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .as(Run.class);
    }

    @Override
    public Run createRunUsingFile(int projectID) {
        logger.info("Post create a new automation run in a target project");
        return given()
                .body(ReadProperties.class.getClassLoader().getResourceAsStream("CreateNewRun.json"))
                .pathParam("projectID", projectID)
                .post(Endpoints.CREATE_NEW_RUN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response()
                .as(Run.class);
    }

    @Override
    public Run createRunUsingFileNeg(int projectID) {
        logger.info("Post create a new automation run in a project that doesn't exist");
        return given()
                .body(ReadProperties.class.getClassLoader().getResourceAsStream("CreateNewRun.json"))
                .pathParam("projectID", projectID)
                .post(Endpoints.CREATE_NEW_RUN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .response()
                .as(Run.class);
    }
}
