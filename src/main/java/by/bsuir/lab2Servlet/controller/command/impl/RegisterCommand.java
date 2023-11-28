package by.bsuir.lab2Servlet.controller.command.impl;

import by.bsuir.lab2Servlet.bean.User;
import by.bsuir.lab2Servlet.controller.command.Command;
import by.bsuir.lab2Servlet.controller.constant.CommandName;
import by.bsuir.lab2Servlet.controller.constant.SessionAttribute;
import by.bsuir.lab2Servlet.controller.util.UrlUtil;
import by.bsuir.lab2Servlet.service.ServiceFactory;
import by.bsuir.lab2Servlet.service.UserService;
import by.bsuir.lab2Servlet.service.exception.ServiceException;
import by.bsuir.lab2Servlet.service.exception.ValidationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class RegisterCommand implements Command {
    public static final Logger LOGGER = LogManager.getLogger(RegisterCommand.class);
    private static final String EMAIL_PARAM = "email";
    private static final String LOGIN_PARAM = "username";
    private static final String PASSWORD_PARAM = "password";

    private static final int SUCCESSFUL_REGISTRATION = 1;
    private static final int FAILED_REGISTRATION = 2;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = createUser(request);
        HttpSession session = request.getSession();
        String viewPath = "";
        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            int userID = userService.register(user);

            //Create code for migrating basket

            session.setAttribute(SessionAttribute.REGISTRATION_MESSAGE, SUCCESSFUL_REGISTRATION);
            response.sendRedirect(UrlUtil.getRefererPage(request));
        } catch (ValidationException e) {
            LOGGER.warn("Invalid user data for registration, validation failed!", e);
            session.setAttribute(SessionAttribute.REGISTRATION_MESSAGE, FAILED_REGISTRATION);
            response.sendRedirect(UrlUtil.getRefererPage(request));
        } catch (ServiceException e) {
            LOGGER.error("Unexpected error happened during registration. Registration is cancelled!", e);
            viewPath += request.getContextPath() + CommandName.GO_TO_ERROR_503_COMMAND;
            response.sendRedirect(viewPath);
        }
    }

    private User createUser(HttpServletRequest request) {
        User user = new User();
        user.setLogin(request.getParameter(LOGIN_PARAM));
        user.setPassword(request.getParameter(PASSWORD_PARAM));
        return user;
    }
}
