package vn.edu.giadinh.models;

import java.time.LocalDateTime;

public class User extends Person {
    // Inner class:
    public static class Builder extends Person.Builder {
        private String username;
        private String password;

        public Builder() {
        }

        public Builder name(String name) {
            super.name(name);
            return this;
        }

        public Builder address(String address) {
            super.address(address);
            return this;
        }

        public Builder birthday(LocalDateTime birthday) {
            super.birthday(birthday);
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(name, address, birthday, username, password);
        }
    }

    // Static methods:
    public static Builder builder() {
        return new Builder();
    }

    // Fields:
    private String username;
    private String password;

    // Constructors
    public User() {
        super();
    }

    public User(String name, String address, LocalDateTime birthday, String username, String password) {
        super(name, address, birthday);

        this.username = username;
        this.password = password;
    }

    // Methods:
    @Override
    public void printName() { // Ghi đè hoàn toàn
        System.out.println("This user's name: " + name);
    }

    @Override
    public void printInfo() { // Ghi đè mở rộng
        super.printInfo();
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @Override
    public void say(String content) {
        System.out.println("User " + getName() + " say: " + content);
    }

    // Getters / setters:
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
