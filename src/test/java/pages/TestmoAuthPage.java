package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.Condition;
import models.UserForUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class TestmoAuthPage extends BasePage {

    private final By testmoAuthLogoLocator = By.xpath("//*[@class='auth-form-frame__logo']");
    private final By testmoLogintButtonLocator = By.xpath("//*[@class='ui primary button']");
    private final By testmoEmailLocator = By.xpath("//input[@placeholder='Email']");
    private final By testmoPasswordLocator = By.xpath("//input[@placeholder='Password']");
    private final By testmoCheckBoxLocator = By.xpath("//*[@class='ui checkbox checked']");
    private final By testmoLoginErrorMessageLocator = By.xpath("//*[@class='message-block message-block--negative message-block--scroll']");

    public TestmoAuthPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return testmoAuthLogoLocator;
    }

    public WebElement getTestmoEmailFieldLocator() {
        return $(testmoEmailLocator);
    }

    public WebElement getTestmoPasswordFieldLocator() {
        return $(testmoPasswordLocator);
    }

    public WebElement getTestmoLogintButtonLocator() {
        return $(testmoLogintButtonLocator);
    }

    public WebElement getTestmoCheckBoxLocator() {
        return $(testmoCheckBoxLocator);
    }

    public WebElement getTestmoLoginErrorMessageLocator() {
        return $(testmoLoginErrorMessageLocator);
    }


    public void insertTestmoLoginAndPassword(UserForUITest user) {
        getTestmoEmailFieldLocator().sendKeys(user.getLogin());
        getTestmoPasswordFieldLocator().sendKeys(user.getPassword());
    }

    public void insertTestmoLoginAndPasswordIncorrectData(UserForUITest user) {
        getTestmoEmailFieldLocator().sendKeys("incorrect_data");
        getTestmoPasswordFieldLocator().sendKeys(user.getPassword());
    }


    public void loginButtonClick() {
        getTestmoLogintButtonLocator().click();
    }

    public String loginButtonIncorrectDataClick() {
        getTestmoLogintButtonLocator().click();
        $(getTestmoLoginErrorMessageLocator()).shouldBe(Condition.visible);
        return getTestmoLoginErrorMessageLocator().getText();
    }

    public void disableCheckBox() {
        if (getTestmoCheckBoxLocator().isSelected() == false) {
            getTestmoCheckBoxLocator().click();
        }
    }
}