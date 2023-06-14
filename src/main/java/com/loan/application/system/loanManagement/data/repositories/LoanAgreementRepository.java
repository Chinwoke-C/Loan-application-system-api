package com.loan.application.system.loanManagement.data.repositories;

import com.loan.application.system.loanManagement.data.models.LoanAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanAgreementRepository extends JpaRepository<LoanAgreement, Long> {
}
