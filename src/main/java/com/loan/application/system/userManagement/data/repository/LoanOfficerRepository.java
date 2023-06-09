package com.loan.application.system.userManagement.data.repository;

import com.loan.application.system.userManagement.data.model.LoanOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanOfficerRepository extends JpaRepository<LoanOfficer, Long> {
}
