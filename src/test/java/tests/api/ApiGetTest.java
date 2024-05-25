package tests.api;

import io.qameta.allure.*;
import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;
import static io.restassured.RestAssured.given;


public class ApiGetTest extends BaseApiTest {
    @Test(description = "Get current user info")
    @Description("Get current user info")
    @Severity(SeverityLevel.MINOR)
    public void getUserTest() {

        given()
                .when()
                .get(Endpoints.GET_CURRENT_USER)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(description = "Get list all users")
    @Description("Get list all users")
    @Severity(SeverityLevel.NORMAL)
    public void getAllUsersTest() {

        given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @Description("Get info about user by user id")
    @Severity(SeverityLevel.NORMAL)
    public void getSecondUserTest() {
        int userID = 2;

        given()
                .when()
                .pathParam("userID", userID)
                .get(Endpoints.GET_USER_BY_ID)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(description = "Get info about special user from list" )
    @Description("Get info about special user from list")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllUsersAsArray() {
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .id(2)
                .name("Volha")
                .email("lela_lela@mail.ru")
                .type(3)
                .isApi(false)
                .roleId(4)
                .build();

        Response response = given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        User[] actualUsersG = response.getBody().jsonPath().getObject("result", User[].class); // GSon

        Assert.assertTrue(actualUsersG[1].equals(expectedUser));
    }
}


