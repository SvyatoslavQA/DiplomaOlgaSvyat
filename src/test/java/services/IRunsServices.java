package services;

import io.restassured.response.ValidatableResponse;
import models.Run;

public interface IRunsServices {
    ValidatableResponse completeRunUsingFile(int runID);
    Run completeRunUsingFileNeg(int runID);

    Run getAllProjectRuns(int projectID);
    Run createRunUsingFile(int projectID);
    Run createRunUsingFileNeg(int projectID);
}
