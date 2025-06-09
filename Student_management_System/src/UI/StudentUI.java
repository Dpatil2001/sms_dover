package UI;

import Domain.Student;
import Service.*;

import java.util.List;
import java.util.Scanner;

public class StudentUI {
    private static StudentService studentService = new StudentServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> searchStudentById();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Student student = new Student(id, name, age, grade, email);
        studentService.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static void searchStudentById() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        Student student = studentService.getStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        Student existing = studentService.getStudentById(id);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Student updated = new Student(id, name, age, grade, email);
        boolean success = studentService.updateStudent(id, updated);
        System.out.println(success ? "Student updated." : "Update failed.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        boolean deleted = studentService.deleteStudent(id);
        System.out.println(deleted ? "Student deleted." : "Student not found.");
    }
}