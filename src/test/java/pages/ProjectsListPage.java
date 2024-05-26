package pages;

import baseEntities.BasePage;
import models.create_project.Project;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProjectsListPage extends BasePage {
    private final By testmoProjectsTitleLocator = By.xpath("//*[@class='page-title__title']");
    private final By popUpLocator = By.xpath("//*[@class='popup__border']");
    private final By addProjectButtonLocator = By.xpath("//*[@class='ui basic compact button']");
    private final By uploadImageWindowLocator = By.xpath("//*[@class='admin-projects-dialog-avatar__action']");
    private final By projectImageLocator = By.xpath("//*[@class='admin-projects-dialog-avatar__avatar']/descendant::img");
    private final By fileUploadLocator = By.xpath("//input[@type='file']");
    private final By projectNameLocator = By.xpath("//input[@placeholder='Project name']");
    private final By projectSummaryLocator = By.xpath("//*[@data-target='note behavior--maxlength-counter.control']");
    private final By createProjectButtonLocator = By.xpath("//*[@class='ui button primary']");
    private final By createProjectDialogWindowLocator = By.xpath("//*[@class='dialog']");
    private final By createProjectDialogWindowTitleLocator = By.xpath("//*[@class='dialog__header__content']");
    private final By createProjectPopUpLocator = By.xpath("//*[@class='inline-tip help']");
    private final By createProjectInfoButtonLocator = By.xpath("//*[@class='fas fa-info-circle icon-inline-tip']");
    private final By createProjectNameFieldErrorLocator = By.xpath("//*[@class='message-block message-block--negative message-block--scroll']/descendant::li");

    public ProjectsListPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return testmoProjectsTitleLocator;
    }

    public WebElement getAddProjectButtonLocator() {
        return $(addProjectButtonLocator);
    }

    public WebElement getUploadImageWindowLocator() {
        return $(uploadImageWindowLocator);
    }

    public WebElement getProjectImageLocator() {
        return $(projectImageLocator);
    }

    public WebElement getFileUploadLocator() {
        return $(fileUploadLocator);
    }

    public WebElement getProjectNameLocator() {
        return $(projectNameLocator);
    }

    public WebElement getProjectSummaryLocator() {
        return $(projectSummaryLocator);
    }

    public WebElement getCreateProjectButtonLocator() {
        return $(createProjectButtonLocator);
    }

    public WebElement getCreateProjectDialogWindowTitleLocator() {
        return $(createProjectDialogWindowTitleLocator);
    }

    public WebElement geCreateProjectPopUpLocator() {
        return $(createProjectPopUpLocator);
    }

    public WebElement getCreateProjectInfoButtonLocator() {
        return $(createProjectInfoButtonLocator);
    }

    public WebElement getCreateProjectNameFieldErrorLocator() {
        return $(createProjectNameFieldErrorLocator);
    }


    public void addProjectButtonClick() {
        getAddProjectButtonLocator().click();
    }

    public String checkDialogWindowOpen() {
        $(createProjectDialogWindowLocator).shouldBe(visible);
        return getCreateProjectDialogWindowTitleLocator().getText();
    }

    public String checkPopUpOpen() {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(getCreateProjectInfoButtonLocator()).perform();
        $(createProjectPopUpLocator).shouldBe(visible);
        return geCreateProjectPopUpLocator().getAttribute("data-content");
    }

    public void uploadImage(String pathToFile) {
        getUploadImageWindowLocator().click();
        getFileUploadLocator().sendKeys(pathToFile);
        synchronized (getWebDriver()) {
            try {
                getWebDriver().wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkSuccessUpload() {
        return getProjectImageLocator().getAttribute("src").contains("attachments");
    }

    public void initProjectFields(Project mProject) {
        getProjectNameLocator().sendKeys(mProject.getmName());
        getProjectSummaryLocator().sendKeys(mProject.getmSummary());
        uploadImage(mProject.getmImagePath());
        getCreateProjectButtonLocator().click();
    }

    public String initProjectNameFieldEmpty() {
        getProjectNameLocator().sendKeys("");
        getCreateProjectButtonLocator().click();
        $(getCreateProjectNameFieldErrorLocator()).shouldBe(visible);
        return getCreateProjectNameFieldErrorLocator().getText();
    }

    public String initProjectNameFieldRangeNegative(int size) {
        getProjectNameLocator().sendKeys(StringUtils.repeat("*", size));
        getCreateProjectButtonLocator().click();
        $(getCreateProjectNameFieldErrorLocator()).shouldBe(visible);
        return getCreateProjectNameFieldErrorLocator().getText();
    }

    public String initProjectNameFieldPositive(int size) {
        getProjectNameLocator().sendKeys(StringUtils.repeat("*", size));
        getCreateProjectButtonLocator().click();
        $(getCreateProjectNameFieldErrorLocator()).shouldBe(hidden);
        return "";
    }
}