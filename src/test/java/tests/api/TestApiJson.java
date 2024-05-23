package tests.api;

import baseEntities.BaseTestApi;
import io.restassured.mapper.ObjectMapperType;
import models.AutoRun;
import models.User;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;
import static io.restassured.RestAssured.*;

public class TestApiJson extends BaseTestApi {

    static Logger logger = LogManager.getLogger(TestApiJson.class);

    @Test(groups = "positive")
    public void postAutoRunGson() {

        logger.info(authentication);

        AutoRun expectedAutoRun = new AutoRun();
        expectedAutoRun.setAutoRunName("Run 1");
        expectedAutoRun.setSourceName("frontend");

        int id = given()
                .body(expectedAutoRun, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.CREATE_AUTO_RUN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .jsonPath()
                .getInt("id");

        logger.info(id);
    }

    @Test(groups = "positive")
    public void getUser() {
        User expectedUser = User.builder()
                .name("Natalie")
                .timezone("Europe/Minsk")
                .build();

        User actualUser = given()
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class);

        System.out.println(actualUser.toString());
        Assert.assertTrue(expectedUser.equals(actualUser));
    }
}