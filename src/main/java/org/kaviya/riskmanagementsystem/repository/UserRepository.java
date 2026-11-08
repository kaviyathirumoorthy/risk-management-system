package org.kaviya.riskmanagementsystem.repository;
import org.kaviya.riskmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByEmployeeId(String employeeId);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}