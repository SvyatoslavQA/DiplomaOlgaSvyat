package models;

import java.util.Objects;

public class UserForUITest {

    private String testmoAccount;
    private String mLogin;
    private String mPassword;

    public UserForUITest() {
    }

    public String getTestmoAccount() {
        return testmoAccount;
    }

    public void setTestmoAccount(String testmoAccount) {
        this.testmoAccount = testmoAccount;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String mLogin) {
        this.mLogin = mLogin;
    }

    public String getPassword() {
        return mPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserForUITest)) return false;
        UserForUITest user = (UserForUITest) o;
        return Objects.equals(getTestmoAccount(), user.getTestmoAccount()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestmoAccount(), getLogin(), getPassword());
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public static class Builder {
        private UserForUITest mUser;

        public Builder() {
            this.mUser = new UserForUITest();
        }

        public Builder withTestmoAccount(String testmoAccount) {
            mUser.testmoAccount = testmoAccount;
            return this;
        }

        public Builder withLogin(String login) {
            mUser.mLogin = login;
            return this;
        }

        public Builder withPassword(String password) {
            mUser.mPassword = password;
            return this;
        }

        public UserForUITest build() {
            return mUser;
        }
    }
}