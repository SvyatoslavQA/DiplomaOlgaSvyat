package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;

public class ProjectDetailsPage extends BasePage {
    private final By testmoProjectsTitleLocator = By.xpath("//*[@class='page-header__title']");

    public ProjectDetailsPage() {
        super();
    }

    @Override
    protected By getPageIdentifier() {
        return testmoProjectsTitleLocator;
    }
}