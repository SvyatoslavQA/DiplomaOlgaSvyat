package tests.api;

import baseEntities.BaseTestApi;
import models.AutoRun;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.Endpoints;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class TestApiPost extends BaseTestApi {

    static Logger logger = LogManager.getLogger(TestApiPost.class);

    @Test(groups = "positive")
    public void postAutoRun() {

        logger.info(authentication);

        AutoRun expectedAutoRun = new AutoRun();
        expectedAutoRun.setAutoRunName("Run 1");
        expectedAutoRun.setSourceName("frontend");

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", expectedAutoRun.getAutoRunName());
        jsonMap.put("source", expectedAutoRun.getSourceName());

        given()
                .body(jsonMap)
                .when()
                .post(Endpoints.CREATE_AUTO_RUN)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED);
    }
}