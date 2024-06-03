package Services;

import models.Run;

public interface IRunsServices {
    Run completeRunUsingFile(int runID);

    Run getAllProjectRuns(int projectID);
    Run createRunUsingFile(int projectID);
    Run createRunUsingFileNeg(int projectID);
}
