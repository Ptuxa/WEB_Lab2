package by.bsuir.lab2Servlet.controller.command;

import by.bsuir.lab2Servlet.controller.constant.CommandName;
import by.bsuir.lab2Servlet.controller.constant.ViewPath;
import by.bsuir.lab2Servlet.controller.command.impl.GoToCommand;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class FactoryCommands {
    private static final FactoryCommands instance = new FactoryCommands();
    private static final Map<String, Command> commands = new HashMap<>();

    private FactoryCommands() {
        commands.put(CommandName.GO_TO_LOGIN_PAGE_COMMAND, new GoToCommand(ViewPath.REDIRECT_LOGIN_FORM));
        commands.put(CommandName.GO_TO_REGISTRATION_PAGE_COMMAND, new GoToCommand(ViewPath.REDIRECT_REGISTRATION_FORM));
        commands.put(CommandName.DEFAULT_COMMAND, new GoToCommand(ViewPath.REDIRECT_HOME));
        commands.put(CommandName.GO_TO_HOME_COMMAND, new GoToCommand(ViewPath.REDIRECT_HOME));
        commands.put(CommandName.GO_TO_ERROR_503_COMMAND, new GoToCommand(ViewPath.REDIRECT_503));
        commands.put(CommandName.GO_TO_ERROR_404_COMMAND, new GoToCommand(ViewPath.REDIRECT_404));
//        commands.put(CommandName.CHANGE_LOCALE_COMMAND, new ChangeLocaleCommand());
//        commands.put(CommandName.REGISTER_COMMAND, new RegisterCommand());
//        commands.put(CommandName.LOGIN_COMMAND, new LoginCommand());
//        commands.put(CommandName.LOGOUT_COMMAND, new LogoutCommand());
//        commands.put(GO_TO_DRUGS_EDITOR_COMMAND, new GoToCommand(REDIRECT_DRUGS_EDITOR));
//        commands.put(GO_TO_USERS_EDITOR_COMMAND, new ShowUsersCommand());
//        commands.put(SHOW_USER_COMMAND, new ShowUserCommand());
    }

    public static FactoryCommands getInstance() {
        return instance;
    }

    public Command getCommand(HttpServletRequest request) {
        String commandName = request.getServletPath();
        Command command = commands.get(commandName);
        if (null == command) {
            return commands.get(CommandName.GO_TO_ERROR_404_COMMAND);
        }
        return command;
    }
}
