package by.bsuir.lab2Servlet.service.impl;

import by.bsuir.lab2Servlet.bean.Role;
import by.bsuir.lab2Servlet.dao.exception.DAOException;
import by.bsuir.lab2Servlet.dao.mysql.DAOFactory;
import by.bsuir.lab2Servlet.dao.mysql.DAOManager;
import by.bsuir.lab2Servlet.dao.mysql.RoleDAO;
import by.bsuir.lab2Servlet.dao.mysql.StorageType;
import by.bsuir.lab2Servlet.service.RoleService;
import by.bsuir.lab2Servlet.service.exception.ServiceException;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private static final DAOManager daoManager = DAOFactory.getDAOManager(StorageType.MY_SQL);

    private static final RoleDAO roleDAO = daoManager.getRoleDAO();
    @Override
    public Role getRole(int id) throws ServiceException {
        Role role = null;
        try {
            role = roleDAO.getRole(id);
        } catch (DAOException e) {
            throw new ServiceException("Exception during getting role by ID", e);
        }
        return role;
    }

    @Override
    public Role getRole(String name) throws ServiceException {
        Role role = null;
        try {
            role = roleDAO.getRole(name);
        } catch (DAOException e) {
            throw new ServiceException("Exception during getting role by name", e);
        }
        return role;
    }

//    @Override
//    public RolesTO getRoles() throws ServiceException {
//        RolesTO rolesTO = null;
//        try {
//            List<Role> roles = roleDAO.getRoles();
//            rolesTO = new RolesTO();
//            rolesTO.setRoles(roles);
//        } catch (DAOException e) {
//            throw new ServiceException("Exception during getting all roles", e);
//        }
//        return rolesTO;
//    }
}
