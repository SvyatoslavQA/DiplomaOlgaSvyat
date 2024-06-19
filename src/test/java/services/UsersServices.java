package services;

import io.restassured.response.Response;
import models.User;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class UsersServices implements IUserSevices {
    protected Logger logger = LogManager.getLogger(this);

    @Override
    public User getUser() {
        logger.info("Get current user info");
        return given()
                .when()
                .get(Endpoints.GET_CURRENT_USER)
                .then()
                .log().body()
                .statusCode(org.apache.http.HttpStatus.SC_OK)
                .extract()
                .response()
                .as(User.class);
    }

    @Override
    public User getUserByID(int userID) {
        logger.info("Get RS with special user");
        return given()
                .when()
                .pathParam("userID", userID)
                .get(Endpoints.GET_USER_BY_ID)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .as(User.class);
    }

    public Response getUserListResponse() {
        logger.info("Get RS with all users");
        return given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().ifError()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }
}

