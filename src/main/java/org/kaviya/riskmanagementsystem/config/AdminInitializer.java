package org.kaviya.riskmanagementsystem.config;

import org.kaviya.riskmanagementsystem.entity.Role;
import org.kaviya.riskmanagementsystem.entity.User;
import org.kaviya.riskmanagementsystem.repository.RoleRepository;
import org.kaviya.riskmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class AdminInitializer implements ApplicationRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.bootstrap-admin.enabled:false}")
    private boolean enabled;

    @Value("${app.bootstrap-admin.employee-id:}")
    private String employeeId;

    @Value("${app.bootstrap-admin.username:}")
    private String username;

    @Value("${app.bootstrap-admin.email:}")
    private String email;

    @Value("${app.bootstrap-admin.password:}")
    private String password;

    public AdminInitializer(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {

        if (!enabled) {
            return;
        }

        if (employeeId.isBlank() || username.isBlank()
                || email.isBlank() || password.isBlank()) {
            throw new IllegalStateException(
                    "Bootstrap ADMIN credentials are not configured");
        }

        if (userRepository.existsByUsername(username)) {
            return;
        }

        if (userRepository.existsByEmployeeId(employeeId)
                || userRepository.existsByEmail(email)) {
            throw new IllegalStateException(
                    "Bootstrap ADMIN employee ID or email already exists");
        }

        Role adminRole = roleRepository.findByName("ADMIN")
                .orElseThrow(() ->
                        new IllegalStateException("ADMIN role not found"));

        User admin = new User();
        admin.setEmployeeId(employeeId);
        admin.setUsername(username);
        admin.setEmail(email);
        admin.setPasswordHash(passwordEncoder.encode(password));
        admin.setEnabled(true);
        admin.setRoles(new HashSet<>(Set.of(adminRole)));

        userRepository.save(admin);
    }
}