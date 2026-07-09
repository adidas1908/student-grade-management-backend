package student_grade_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_grade_management.dto.auth.RegisterRequest;
import student_grade_management.entity.User;
import student_grade_management.repository.UserRepository;
import student_grade_management.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(RegisterRequest request) {

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        return userRepository.save(user);
    }
}