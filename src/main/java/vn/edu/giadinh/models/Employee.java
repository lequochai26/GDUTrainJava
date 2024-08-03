package vn.edu.giadinh.models;

import java.time.LocalDateTime;

public class Employee extends Person {
    // Inner class:
    public static class Builder extends Person.Builder {
        // Fields:
        private String role;

        // Constructors:
        public Builder() {
        }

        // Methods:
        public Builder role(String role) {
            this.role = role;
            return this;
        }

        @Override
        public Builder name(String name) {
            super.name(name);
            return this;
        }

        @Override
        public Builder address(String address) {
            super.address(address);
            return this;
        }

        @Override
        public Builder birthday(LocalDateTime birthday) {
            super.birthday(birthday);
            return this;
        }

        @Override
        public Person build() {
            return new Employee(name, address, birthday, role);
        }
    }

    // Static fields:
    private static int employeeSize = 0;

    // Static methods:
    public static Builder builder() {
        return new Builder();
    }

    // Fields:
    private int employeeId;
    private String role;

    // Constructors:
    public Employee() {
        employeeSize++;
        employeeId = employeeSize;
    }

    public Employee(String name, String address, LocalDateTime birthday, String role) {
        super(name, address, birthday);
        employeeSize++;
        employeeId = employeeSize;
        this.role = role;
    }

    // Methods:
    @Override
    public void say(String content) {
        System.out.println("Employee " + name + " says: " + content);
    }

    // Getters / setters:
    public static int getEmployeeSize() {
        return employeeSize;
    }

    public static void setEmployeeSize(int employeeSize) {
        Employee.employeeSize = employeeSize;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
