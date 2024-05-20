package steps;

import baseEntities.BaseStep;

public class AdminProjectStep extends BaseStep {
    public AdminProjectStep() {
        super();
    }

    public void removeLastProjectFromTable() {
        AdminProjectPage.parseTable();
        AdminProjectPage.isDialogVisible();
        AdminProjectPage.removeProject();
    }

    public boolean removeWorkflowFromTable() {
        int startRowSize = AdminProjectPage.parseTable();
        AdminProjectPage.isDialogVisible();
        int endRowSize = AdminProjectPage.removeWorkflow();
        return startRowSize > endRowSize;
    }
}

