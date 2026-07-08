package student_grade_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import student_grade_management.dto.attendance.AttendanceRequest;
import student_grade_management.entity.Attendance;
import student_grade_management.response.ApiResponse;
import student_grade_management.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<ApiResponse<Attendance>> addAttendance(
            @Valid @RequestBody AttendanceRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Attendance Added Successfully",
                        attendanceService.addAttendance(request)
                )
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendance>>> getAllAttendance() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Attendance Retrieved Successfully",
                        attendanceService.getAllAttendance()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendance>> getAttendance(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Attendance Retrieved Successfully",
                        attendanceService.getAttendanceById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Attendance>> updateAttendance(
            @PathVariable Long id,
            @Valid @RequestBody AttendanceRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Attendance Updated Successfully",
                        attendanceService.updateAttendance(id, request)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteAttendance(
            @PathVariable Long id) {

        attendanceService.deleteAttendance(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Attendance Deleted Successfully",
                        "Success"
                )
        );
    }
}