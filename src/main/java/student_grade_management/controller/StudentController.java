package student_grade_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import student_grade_management.dto.student.StudentRequest;
import student_grade_management.entity.Student;
import student_grade_management.response.ApiResponse;
import student_grade_management.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@Valid @RequestBody StudentRequest request) {

        Student student = studentService.addStudent(request);

        ApiResponse<Student> response =
                new ApiResponse<>(true, "Student Added Successfully", student);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {

        List<Student> students = studentService.getAllStudents();

        ApiResponse<List<Student>> response =
                new ApiResponse<>(true, "Students Fetched Successfully", students);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable Long id) {

        Student student = studentService.getStudentById(id);

        ApiResponse<Student> response =
                new ApiResponse<>(true, "Student Found", student);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequest request) {

        Student student = studentService.updateStudent(id, request);

        ApiResponse<Student> response =
                new ApiResponse<>(true, "Student Updated Successfully", student);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        ApiResponse<String> response =
                new ApiResponse<>(true, "Student Deleted Successfully", null);

        return ResponseEntity.ok(response);
    }
}