package by.bsuir.lab2Servlet.bean;

import java.util.Objects;

public class Admin extends User{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin objectAdmin = (Admin) o;
        return getId() == objectAdmin.getId() && getLogin().equals(objectAdmin.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword());
    }
}
