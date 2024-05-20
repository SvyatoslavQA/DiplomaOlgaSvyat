package pages;

import baseEntities.BasePage;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class TestmoLoginPage extends BasePage {

    private final By testmoAccountButtonLocator = By.xpath("//*[@class='login-choice__selection__option']");
    private final By testmoAccountEmailFieldLocator = By.xpath("//*[@class='input']");
    private final By testmoGOButtonLocator = By.xpath("//*[@class='button is-success']");

    public TestmoLoginPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return testmoAccountButtonLocator;
    }

    public WebElement getTestmoAccountButtonLocatorButton() {
        return $(testmoAccountButtonLocator);
    }

    public WebElement getTestmoAccountEmailFieldLocator() {
        return $(testmoAccountEmailFieldLocator);
    }

    public WebElement getTestmoGOButtonLocator() {
        return $(testmoGOButtonLocator);
    }

    public void loginAccountAreaClick() {
        getTestmoAccountButtonLocatorButton().click();
    }

    public void insertTestmoAccount(String testmoAccount) {
        getTestmoAccountEmailFieldLocator().sendKeys(testmoAccount);
    }


    public void goButtonClick() {
        getTestmoGOButtonLocator().click();
    }
}