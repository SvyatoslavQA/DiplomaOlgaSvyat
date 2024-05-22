package utils;

public class Endpoints {

    public static final String GET_ALL_USERS = "/api/v1/users";
    public static final String GET_ALL_RUNS = "/api/v1/projects/{projectID}/automation/runs";
    public static final String COMPLETE_ACTIVE_RUN = "/api/v1/automation/runs/{runID}/complete";
    public static final String CREATE_NEW_RUN = "/api/v1/projects/{projectID}/automation/runs";
}