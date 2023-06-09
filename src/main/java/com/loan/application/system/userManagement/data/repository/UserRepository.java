package com.loan.application.system.userManagement.data.repository;

import com.loan.application.system.userManagement.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {
}
