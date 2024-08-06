package vn.edu.giadinh.models;

import vn.edu.giadinh.interfaces.Animal;

public class Dog implements Animal {
    private String name;

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }

    @Override
    public void move() {
        System.out.println("Dog is moving");
    }
}
