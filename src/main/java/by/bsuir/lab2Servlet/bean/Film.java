package by.bsuir.lab2Servlet.bean;

import java.util.Objects;

public class Film {
    private int id;
    private String name;
    private String duration;
    private String ticketCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(String ticketCost) {
        this.ticketCost = ticketCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film objectFilm = (Film) o;
        return id == objectFilm.id && name.equals(objectFilm.name) && duration.equals(objectFilm.duration) && ticketCost.equals(objectFilm.ticketCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, ticketCost);
    }
}
