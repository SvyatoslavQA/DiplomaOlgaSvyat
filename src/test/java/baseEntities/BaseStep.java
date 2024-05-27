package baseEntities;

import pages.*;

public class BaseStep {
    protected StartPage StartPage;
    protected TestmoLoginPage LoginPage;
    protected TestmoAuthPage AuthPage;
    protected ProjectsListPage ProjectsListPage;
    protected ProjectDetailsPage ProjectDetailsPage;
    protected AdminProjectPage AdminProjectPage;

    public BaseStep() {
        StartPage = new StartPage();
        LoginPage = new TestmoLoginPage();
        AuthPage = new TestmoAuthPage();
        ProjectsListPage = new ProjectsListPage();
        ProjectDetailsPage = new ProjectDetailsPage();
        AdminProjectPage = new AdminProjectPage();
    }
}