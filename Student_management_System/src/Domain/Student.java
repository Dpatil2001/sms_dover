package Domain;

import java.util.Objects;

public class Student {
    private String studentId;
    private String fullName;
    private int age;
    private String grade;
    private String email;

    public Student(String studentId, String fullName, int age, String grade, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.grade = grade;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId +
                "\nName: " + fullName +
                "\nAge: " + age +
                "\nGrade: " + grade +
                "\nEmail: " + email + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}