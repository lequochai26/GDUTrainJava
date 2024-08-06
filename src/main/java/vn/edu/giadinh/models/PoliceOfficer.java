package vn.edu.giadinh.models;

public class PoliceOfficer extends AbstractHuman {
    // Fields:
    private String role;

    // Constructors:
    public PoliceOfficer() {
    }

    public PoliceOfficer(String name, String role) {
        super(name);
        this.role = role;
    }

    // Methods:
    @Override
    public void say() {
        System.out.println("Hello, i am officer " + name + ", please let me verify your information!");
    }

    // Getters / setters:
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
