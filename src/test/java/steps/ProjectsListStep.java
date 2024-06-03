package steps;

import baseEntities.BaseStep;
import models.create_project.Project;
import pages.ProjectDetailsPage;


public class ProjectsListStep extends BaseStep {
    public ProjectsListStep() {
        super();
    }

    public void openAddProjectDialogWindow() {
        ProjectsListPage.addProjectButtonClick();
    }

    public String getAddProjectDialogTitleTextWindow() {
        return ProjectsListPage.checkDialogWindowOpen();
    }

    public String getAddProjectDialogPopUpText() {
        return ProjectsListPage.checkPopUpOpen();
    }

    public void uploadImage(String pathToFile) {
        ProjectsListPage.uploadImage(pathToFile);
    }

    public boolean checkSuccessUpload() {
        return ProjectsListPage.checkSuccessUpload();
    }

    public ProjectDetailsPage createProject(Project mProject) {
        ProjectsListPage.initProjectFields(mProject);
        return ProjectDetailsPage;
    }

    public String createProject(int size) {
        if (size == 0)
            return ProjectsListPage.initProjectNameFieldEmpty();
        else if (size == 751)
            return ProjectsListPage.initProjectNameFieldRangeNegative(size);
        else return ProjectsListPage.initProjectNameFieldPositive(size);
    }
}

