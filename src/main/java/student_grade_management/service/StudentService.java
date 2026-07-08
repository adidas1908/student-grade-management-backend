package student_grade_management.service;

import java.util.List;

import student_grade_management.dto.student.StudentRequest;
import student_grade_management.entity.Student;

public interface StudentService {

    Student addStudent(StudentRequest request);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, StudentRequest request);

    void deleteStudent(Long id);
}