package student_grade_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import student_grade_management.dto.teacher.TeacherRequest;
import student_grade_management.entity.Teacher;
import student_grade_management.response.ApiResponse;
import student_grade_management.service.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<ApiResponse<Teacher>> addTeacher(
            @Valid @RequestBody TeacherRequest request) {

        Teacher teacher = teacherService.addTeacher(request);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Teacher Added Successfully", teacher));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Teacher>>> getAllTeachers() {

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Teachers Retrieved Successfully",
                        teacherService.getAllTeachers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Teacher>> getTeacher(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Teacher Retrieved Successfully",
                        teacherService.getTeacherById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Teacher>> updateTeacher(
            @PathVariable Long id,
            @Valid @RequestBody TeacherRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Teacher Updated Successfully",
                        teacherService.updateTeacher(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteTeacher(
            @PathVariable Long id) {

        teacherService.deleteTeacher(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Teacher Deleted Successfully",
                        "Success"));
    }
}