package vn.edu.giadinh.models;

import vn.edu.giadinh.interfaces.Animal;

public class Cat implements Animal {
    // Fields:
    private String name;
    private String color;

    // Constructors:
    public Cat() {
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Methods:
    @Override
    public void eat() {
        System.out.println(color + " cat with name " + name + " is eating!");
    }

    @Override
    public void sleep() {
        System.out.println(color + " cat with name " + name + " is sleeping...");
    }

    @Override
    public void move() {
        System.out.println(color + " cat with name " + name + " is moving.");
    }

    // Getters and Setters:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
