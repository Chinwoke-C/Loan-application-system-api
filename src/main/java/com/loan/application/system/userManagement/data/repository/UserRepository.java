package com.loan.application.system.userManagement.data.repository;

import com.loan.application.system.userManagement.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long > {
    Optional<User> findByEmail(String email);
}
