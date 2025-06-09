package Service;

import Domain.Student;
import java.util.*;

public class StudentServiceImpl implements StudentService {
    private Map<String, Student> studentMap = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        studentMap.put(student.getStudentId(), student);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentMap.get(studentId);
    }

    @Override
    public boolean updateStudent(String studentId, Student updatedStudent) {
        if (studentMap.containsKey(studentId)) {
            studentMap.put(studentId, updatedStudent);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String studentId) {
        return studentMap.remove(studentId) != null;
    }
}