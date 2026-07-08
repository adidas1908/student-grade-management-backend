package student_grade_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import student_grade_management.dto.subject.SubjectRequest;
import student_grade_management.entity.Subject;
import student_grade_management.response.ApiResponse;
import student_grade_management.service.SubjectService;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<ApiResponse<Subject>> addSubject(
            @Valid @RequestBody SubjectRequest request) {

        Subject subject = subjectService.addSubject(request);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Subject Added Successfully", subject));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Subject>>> getAllSubjects() {

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Subjects Retrieved Successfully",
                        subjectService.getAllSubjects()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Subject>> getSubjectById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Subject Retrieved Successfully",
                        subjectService.getSubjectById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Subject>> updateSubject(
            @PathVariable Long id,
            @Valid @RequestBody SubjectRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Subject Updated Successfully",
                        subjectService.updateSubject(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteSubject(
            @PathVariable Long id) {

        subjectService.deleteSubject(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true,
                        "Subject Deleted Successfully",
                        "Success"));
    }
}