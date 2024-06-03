package services;

import models.User;

public interface IUserSevices {
    User getUser();

    User getUserByID(int userID);
}
