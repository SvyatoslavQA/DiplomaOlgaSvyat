package helper;

import configuration.ReadProperties;
import models.UserForUITest;
import models.create_project.Project;
import models.create_project.Role;
import tests.gui.positive.UploadFileTest;

public class DataHelper {
    private static String initFilePath(String mFileName) {
        String pathToFile = UploadFileTest.class.getClassLoader().getResource(mFileName).getPath();
        return pathToFile.substring(1, pathToFile.length());
    }


    public static UserForUITest getFirsCorrectUser() {
        UserForUITest mUser = new UserForUITest.Builder()
                .withTestmoAccount(ReadProperties.getAccount())
                .withLogin(ReadProperties.getLogin())
                .withPassword(ReadProperties.getPassword())
                .build();
        return mUser;
    }

    public static Project getProject() {
        Project mProject = new Project.Builder()
                .withName("AQA_Test_Project")
                .withSummary("Summary Of AQA_Test_Project")
                .withRole(Role.GLOBAL)
                .withImagePath(initFilePath("bug.jpeg"))
                .build();
        return mProject;
    }
}