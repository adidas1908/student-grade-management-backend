package student_grade_management.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import student_grade_management.entity.Role;
import student_grade_management.entity.User;
import student_grade_management.repository.UserRepository;

@Configuration
public class DemoUserConfig {

    @Bean
    CommandLineRunner createDemoUser(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.findByEmail("demo@gmail.com").isEmpty()) {

                User demo = new User();

                demo.setFullName("Demo User");
                demo.setEmail("demo@gmail.com");
                demo.setPassword(passwordEncoder.encode("Demo@123"));
                demo.setRole(Role.ADMIN);

                userRepository.save(demo);

                System.out.println("======================================");
                System.out.println("Demo User Created Successfully");
                System.out.println("Email : demo@gmail.com");
                System.out.println("Password : Demo@123");
                System.out.println("======================================");

            }

        };

    }

}