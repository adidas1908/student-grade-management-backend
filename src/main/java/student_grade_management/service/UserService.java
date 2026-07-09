package student_grade_management.service;

import student_grade_management.dto.auth.RegisterRequest;
import student_grade_management.entity.User;

public interface UserService {

    User registerUser(RegisterRequest request);

}