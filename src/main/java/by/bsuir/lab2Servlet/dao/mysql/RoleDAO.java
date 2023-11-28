package by.bsuir.lab2Servlet.dao.mysql;

import by.bsuir.lab2Servlet.bean.Role;
import by.bsuir.lab2Servlet.dao.exception.DAOException;

import java.util.List;

public interface RoleDAO {
    Role getRole(int id) throws DAOException;

    Role getRole(String name) throws DAOException;

    List<Role> getRoles() throws DAOException;
}
