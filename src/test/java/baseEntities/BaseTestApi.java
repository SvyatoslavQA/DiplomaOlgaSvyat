package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseTestApi extends BaseTest {

    @BeforeTest
    public void setupUriApi() {

        RestAssured.baseURI = ReadProperties.getUrlApi();

        RestAssured.requestSpecification = given()
                .auth().oauth2(ReadProperties.getToken())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}