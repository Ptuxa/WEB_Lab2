package by.bsuir.lab2Servlet.dao.mysql;

import by.bsuir.lab2Servlet.bean.User;
import by.bsuir.lab2Servlet.dao.exception.DAOException;

import java.util.List;

public interface UserDAO {
    int addUser(User user) throws DAOException;

    boolean isEmailOrLoginExists(User user) throws DAOException;

    User getUser(String usernameOrEmail, String password) throws DAOException;

    User getUser(int userID) throws DAOException;

    String getUsersName(int usedID) throws DAOException;

    void setUserInfo(User user) throws DAOException;

    List<User> getUsers() throws DAOException;

    void updateUser(User user) throws DAOException;
}