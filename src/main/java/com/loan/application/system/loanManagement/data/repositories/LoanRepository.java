package com.loan.application.system.loanManagement.data.repositories;

import com.loan.application.system.loanManagement.data.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
