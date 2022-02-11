package ru.job4j.tdd;

import java.util.Objects;

public class Session3D implements Session {
    private String name;

    public Session3D() {

    }
    public Session3D(String name) {
        this.name = name;
    }

    public String getName() {
       return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Session3D session3D = (Session3D) o;
        return Objects.equals(name, session3D.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
