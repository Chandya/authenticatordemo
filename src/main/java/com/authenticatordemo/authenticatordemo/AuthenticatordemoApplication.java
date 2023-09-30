package com.authenticatordemo.authenticatordemo;

import com.authenticatordemo.authenticatordemo.models.Role;
import com.authenticatordemo.authenticatordemo.models.User;
import com.authenticatordemo.authenticatordemo.repository.RoleRepository;
import com.authenticatordemo.authenticatordemo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthenticatordemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticatordemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            // Populate the database with a manager and a user
            if (roleRepository.findByAuthority("MANAGER").isPresent()) return;
                Role adminRole = roleRepository.save(new Role("MANAGER"));
                roleRepository.save(adminRole);

                User manager = new User("Mr. Manager", "manager", encoder.encode("password123"), adminRole);
                userRepository.save(manager);

                Role userRole = roleRepository.save(new Role("USER"));
                roleRepository.save(userRole);

                User rory = new User("Adam Smith", "adam", encoder.encode("password123"), userRole);
                userRepository.save(rory);
        };
    }
}
