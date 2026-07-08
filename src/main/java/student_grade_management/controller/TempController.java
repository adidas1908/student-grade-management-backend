package student_grade_management.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

    @GetMapping("/hash")
    public String hash() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode("admin123");
    }
}