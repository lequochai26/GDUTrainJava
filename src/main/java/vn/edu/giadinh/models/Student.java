package vn.edu.giadinh.models;

public class Student extends AbstractHuman {
    // Fields:
    private String studentId;

    // Constructors:
    public Student() {
    }

    public Student(String name, String studentId) {
        super(name);
        this.studentId = studentId;
    }

    // Methods:
    @Override
    public void say() {
        System.out.println("Hello, my name is " + name + " and my student ID is " + studentId + ". Nice to meet you!");
    }

    // Getters / setters:
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
