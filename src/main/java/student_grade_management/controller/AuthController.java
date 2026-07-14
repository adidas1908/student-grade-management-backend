package student_grade_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import student_grade_management.dto.auth.LoginRequest;
import student_grade_management.dto.auth.LoginResponse;
import student_grade_management.dto.auth.RegisterRequest;
import student_grade_management.entity.User;
import student_grade_management.response.ApiResponse;
import student_grade_management.service.AuthService;
import student_grade_management.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @Valid @RequestBody RegisterRequest request) {

        User user = userService.registerUser(request);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequest request) {

        LoginResponse response = authService.login(request);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Login Successful",
                        response
                )
        );
    }

    @PostMapping("/demo-login")
public ResponseEntity<?> demoLogin() {

    try {

        LoginResponse response = authService.demoLogin();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Demo Login Successful",
                        response
                )
        );

    } catch (Exception e) {

        e.printStackTrace();

        return ResponseEntity.internalServerError().body(e.getMessage());

    }

}
}
