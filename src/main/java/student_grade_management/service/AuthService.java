package student_grade_management.service;

import student_grade_management.dto.auth.LoginRequest;
import student_grade_management.dto.auth.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    LoginResponse demoLogin();

}
