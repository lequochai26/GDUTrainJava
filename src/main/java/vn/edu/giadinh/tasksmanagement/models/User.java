package vn.edu.giadinh.tasksmanagement.models;

import vn.edu.giadinh.tasksmanagement.enums.UserRole;

public class User {
    // Inner classes:
    public static class Builder {
        private String username;
        private String password;
        private String fullName;
        private UserRole role;

        public Builder() {
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder role(UserRole role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(username, password, fullName, role);
        }
    }

    // Static methods:
    public static Builder builder() {
        return new Builder();
    }

    // Fields:
    private String username;
    private String password;
    private String fullName;
    private UserRole role;

    // Constructors:
    public User() {
    }

    public User(String username, String password, String fullName, UserRole role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    // Getters / setters:
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
