package ru.job4j.gc;

public class User {
    private long id;

    private String name;



    public User(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public User() {

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", id, name);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
