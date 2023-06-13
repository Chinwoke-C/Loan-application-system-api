package com.loan.application.system.userManagement.data.repository;

import com.loan.application.system.userManagement.data.model.LoanOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanOfficerRepository extends JpaRepository<LoanOfficer, Long> {
    Optional<LoanOfficer> findByEmployeeId(String employeeId);

}
