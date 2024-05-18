package tests.api;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class apiTest extends BaseApiTest {
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
}


