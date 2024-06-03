package pages;

import baseEntities.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class StartPage extends BasePage {
    private final By loginButtonLocator = By.xpath("//*[@class='navbar-item navbar-item--small is-hidden-until-widescreen']");

    public StartPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator;
    }


    public WebElement getLoginButton() {
        return $(loginButtonLocator);
    }

    public void loginButtonClick() {
        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        executor.executeScript("arguments[0].click();", getLoginButton());
    }
}