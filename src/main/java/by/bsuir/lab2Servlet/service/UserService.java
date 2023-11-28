package by.bsuir.lab2Servlet.service;

import by.bsuir.lab2Servlet.bean.User;
import by.bsuir.lab2Servlet.service.exception.ServiceException;
import by.bsuir.lab2Servlet.service.exception.ValidationException;

public interface UserService {
    int register(User user) throws ServiceException, ValidationException;

    User login(String usernameOrEmail, String password) throws ServiceException, ValidationException;

//    UsersTO getUsersForView() throws ServiceException;

    User getUser(int userID) throws ServiceException;

    void updateUser(User user) throws ServiceException;
}
