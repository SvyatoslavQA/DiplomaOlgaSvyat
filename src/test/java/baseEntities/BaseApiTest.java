package baseEntities;

import services.RunsServices;
import services.UsersServices;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected UsersServices usersServices;
    protected RunsServices runsServices;
    protected Logger logger = LogManager.getLogger(this);
    @BeforeTest
    public void setupApi() {
        logger.info("Login before test");
        usersServices = new UsersServices();
        runsServices = new RunsServices();

        RestAssured.baseURI = ReadProperties.getUrlApi();

        RestAssured.requestSpecification = given()
                .headers(HTTP.CONTENT_TYPE, ContentType.JSON, "Authorization", "Bearer " + ReadProperties.getToken());
    }
}