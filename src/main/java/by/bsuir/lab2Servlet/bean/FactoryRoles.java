package by.bsuir.lab2Servlet.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FactoryRoles {
    private static final FactoryRoles instance = new FactoryRoles();
    private static final Map<Role, Integer> roles = new TreeMap<>();

    private FactoryRoles() {
        roles.put(Role.CLIENT, 0);
        roles.put(Role.ADMIN, 1);
    }

    public static FactoryRoles getInstance() {
        return instance;
    }

    public int getRoleID(Role role) {
        return roles.get(role);
    }

    public List<Role> getRoles() {
        return new ArrayList<>(roles.keySet());
    }
}
