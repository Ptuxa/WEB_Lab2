package by.bsuir.lab2Servlet.service.validation;

import by.bsuir.lab2Servlet.bean.User;
import org.apache.commons.validator.GenericValidator;
public class Validator {
    public static boolean isRegistrationDataValid(User user) {
        String login = user.getLogin();
        String password = user.getPassword();

        if (!GenericValidator.isEmail(login)) {
            return false;
        }
        if (GenericValidator.isBlankOrNull(password) || !GenericValidator.minLength(password, 4)) {
            return false;
        }

        return true;
    }

    public static boolean isLoginDataValid(String usernameOrEmail, String password) {
        if (GenericValidator.isBlankOrNull(usernameOrEmail)) {
            return false;
        }
        if (GenericValidator.isBlankOrNull(password)) {
            return false;
        }
        return true;
    }
}
