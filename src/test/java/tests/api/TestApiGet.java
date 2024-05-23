package tests.api;

import baseEntities.BaseTestApi;
import configuration.ReadProperties;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class TestApiGet extends BaseTestApi {
    static Logger logger = LogManager.getLogger(TestApiGet.class);

    @Test(groups = "positive")
    public void getUsers() {

        logger.info(authentication);

        given()
                .when()
                .get(Endpoints.GET_USERS)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = "positive")
    public void getUsersId() {

        int autoRunID = 30;
        String endpoint = "/api/v1/automation/runs/" + autoRunID;

        logger.info(authentication);

        given()
                .when()
                .get(endpoint)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = "negative")
    public void getRoles() {

        logger.info(authentication);

        given()
                .auth().oauth2(ReadProperties.getTokenFalse())
                .when()
                .get(Endpoints.GET_ROLES)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}