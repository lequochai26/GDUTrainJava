package vn.edu.giadinh.models;

import vn.edu.giadinh.interfaces.Human;

public abstract class AbstractHuman implements Human {
    // Fields:
    protected String name;

    // Constructors:
    public AbstractHuman() {
    }

    public AbstractHuman(String name) {
        this.name = name;
    }

    // Methods:
    @Override
    public void eat() {
        System.out.println(name + " is eating.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }

    @Override
    public void move() {
        System.out.println(name + " is moving.");
    }

    // Getters and Setters:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
