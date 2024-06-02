package models.create_project;

import java.util.Objects;

public class Project {

    private String mName;
    private String mSummary;
    private Role mRole;

    private String mImagePath;

    public Project() {
    }


    public String getmName() {
        return mName;
    }

    public String getmSummary() {
        return mSummary;
    }

    public String getmImagePath() {
        return mImagePath;
    }

    public void setmImagePath(String mImagePath) {
        this.mImagePath = mImagePath;
    }

    public Role getmRole() {
        return mRole;
    }

    public static class Builder {
        private Project mProject;

        public Builder() {
            this.mProject = new Project();
        }

        public Builder withName(String mName) {
            mProject.mName = mName;
            return this;
        }

        public Builder withSummary(String mSummary) {
            mProject.mSummary = mSummary;
            return this;
        }

        public Builder withRole(Role mRole) {
            mProject.mRole = mRole;
            return this;
        }

        public Builder withImagePath(String mImagePath) {
            mProject.mImagePath = mImagePath;
            return this;
        }

        public Project build() {
            return mProject;
        }
    }
}