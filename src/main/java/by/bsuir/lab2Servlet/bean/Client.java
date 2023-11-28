package by.bsuir.lab2Servlet.bean;

import java.util.Objects;

public class Client extends User
{
    private int bonusPercent;

    public int getBonusPercent() {
        return bonusPercent;
    }

    public void setBonusPercent(int bonusPercent) {
        this.bonusPercent = bonusPercent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client objectClient = (Client) o;
        return getId() == objectClient.getId() && bonusPercent == objectClient.bonusPercent && getLogin().equals(objectClient.getLogin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword());
    }
}
