package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;
import static io.restassured.RestAssured.given;


public class apiGetTest extends BaseApiTest {
    @Test
    public void getUserTest() {
        String endpoint = "/api/v1/user";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUsersTest() {
        String endpoint = "/api/v1/users";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getSecondUserTest() {
        String endpoint = "/api/v1/users/2";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
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


