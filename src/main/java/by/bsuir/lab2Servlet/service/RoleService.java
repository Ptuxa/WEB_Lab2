package by.bsuir.lab2Servlet.service;

import by.bsuir.lab2Servlet.bean.Role;
import by.bsuir.lab2Servlet.service.exception.ServiceException;

public interface RoleService {
    Role getRole(int id) throws ServiceException;

    Role getRole(String name) throws ServiceException;
}