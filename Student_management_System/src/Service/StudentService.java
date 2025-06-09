package Service;

import Domain.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(String studentId);
    boolean updateStudent(String studentId, Student updatedStudent);
    boolean deleteStudent(String studentId);
}