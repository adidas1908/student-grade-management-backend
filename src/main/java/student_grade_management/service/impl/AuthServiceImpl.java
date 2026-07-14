package student_grade_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import student_grade_management.dto.auth.LoginRequest;
import student_grade_management.dto.auth.LoginResponse;
import student_grade_management.entity.User;
import student_grade_management.repository.UserRepository;
import student_grade_management.security.JwtService;
import student_grade_management.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token);
    }

  @Override
public LoginResponse demoLogin() {

    try {

        System.out.println("Demo Login Started");

        User demoUser = userRepository.findByEmail("demo@gmail.com")
                .orElseThrow(() -> new RuntimeException("Demo User Not Found"));

        System.out.println("User Found : " + demoUser.getEmail());

        String token = jwtService.generateToken(demoUser.getEmail());

        System.out.println("Token Generated Successfully");

        return new LoginResponse(token);

    } catch (Exception e) {

        e.printStackTrace();

        throw e;
    }
}

}
