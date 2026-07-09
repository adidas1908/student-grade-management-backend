package student_grade_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import student_grade_management.dto.dashboard.DashboardResponse;
import student_grade_management.response.ApiResponse;
import student_grade_management.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<ApiResponse<DashboardResponse>> getDashboard() {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Dashboard Loaded Successfully",
                        dashboardService.getDashboard()
                )
        );
    }
}