package student_grade_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import student_grade_management.dto.marks.MarksRequest;
import student_grade_management.entity.Marks;
import student_grade_management.response.ApiResponse;
import student_grade_management.service.MarksService;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @PostMapping
    public ResponseEntity<ApiResponse<Marks>> addMarks(
            @Valid @RequestBody MarksRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Marks Added Successfully",
                        marksService.addMarks(request)
                )
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Marks>>> getAllMarks() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Marks Retrieved Successfully",
                        marksService.getAllMarks()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Marks>> getMarks(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Marks Retrieved Successfully",
                        marksService.getMarksById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Marks>> updateMarks(
            @PathVariable Long id,
            @Valid @RequestBody MarksRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Marks Updated Successfully",
                        marksService.updateMarks(id, request)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteMarks(
            @PathVariable Long id) {

        marksService.deleteMarks(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Marks Deleted Successfully",
                        "Success"
                )
        );
    }
}