package steps;

import baseEntities.BaseStep;

public class AdminProjectStep extends BaseStep {
    public AdminProjectStep() {
        super();
    }

    public void removeLastProjectFromTable() {
        mAdminProjectPage.parseTable();
        mAdminProjectPage.isDialogVisible();
        mAdminProjectPage.removeProject();
    }

    public boolean removeWorkflowFromTable() {
        int startRowSize = mAdminProjectPage.parseTable();
        mAdminProjectPage.isDialogVisible();
        int endRowSize = mAdminProjectPage.removeWorkflow();
        return startRowSize > endRowSize;
    }
}

