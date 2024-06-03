package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import models.UserForUITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import steps.*;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseUITest extends BaseTest{
    protected StartStep mStartStep;
    protected TestmoLoginStep mTestmoLoginStep;
    protected TestmoAuthStep mTestmoAuthStep;
    protected ProjectsListStep mProjectsListStep;
    protected ProjectDetailsStep mProjectDetailsStep;
    protected AdminProjectStep mAdminProjectStep;
    static Logger logger = Logger.getLogger(BaseUITest.class);

    @BeforeMethod
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        org.apache.log4j.BasicConfigurator.configure();
        initSteps();
        setConfigurationProp();
        open("/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        closeWebDriver();
    }


    private void setConfigurationProp() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 8000;
        Configuration.browserSize = "1920x1080";
        Configuration.fastSetValue = true;
        Configuration.headless = false;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    private void initSteps() {
        mStartStep = new StartStep();
        mTestmoLoginStep = new TestmoLoginStep();
        mTestmoAuthStep = new TestmoAuthStep();
        mProjectsListStep = new ProjectsListStep();
        mProjectDetailsStep = new ProjectDetailsStep();
        mAdminProjectStep = new AdminProjectStep();
    }

    protected void defaultUserLogin() {
        UserForUITest mUser = DataHelper.getFirsCorrectUser();
        mStartStep.loginButtonClick().isPageOpened();
        mTestmoLoginStep.setTestmoAccount(mUser).isPageOpened();
        mTestmoAuthStep.login(mUser).isPageOpened();
    }
}
