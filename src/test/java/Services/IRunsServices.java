package Services;

import models.Run;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IRunsServices {
    Run completeRunUsingFile(int runID);

    Run getAllProjectRuns(int projectID);
    Run createRunUsingFile(int projectID);
    Run createRunUsingFileNeg(int projectID);
}
