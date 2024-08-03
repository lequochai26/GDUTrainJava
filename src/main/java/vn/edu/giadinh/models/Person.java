package vn.edu.giadinh.models;

import java.time.LocalDateTime;

public abstract class Person {
    // Inner class:
    public static abstract class Builder {
        protected String name;
        protected String address;
        protected LocalDateTime birthday;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder birthday(LocalDateTime birthday) {
            this.birthday = birthday;
            return this;
        }

        public abstract Person build();
    }

    // Static fields
    static int citizenSize = 0;

    // Fields
    protected String name;
    protected String address;
    protected LocalDateTime birthday;

    // Constructors
    public Person() {
        citizenSize++;
    }

    public Person(String name, String address, LocalDateTime birthday) {
        this();
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }

    // Methods
    public void printName() {
        System.out.println("This person's name: " + name);
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Birthday: " + birthday);
    }

    public abstract void say(String content);

    // Getters / setters
    public String getName() {
        if (name == null) {
            name = "Unknown";
        }

        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
}
