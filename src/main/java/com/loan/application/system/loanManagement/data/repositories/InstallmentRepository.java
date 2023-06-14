package com.loan.application.system.loanManagement.data.repositories;

import com.loan.application.system.loanManagement.data.models.Installment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallmentRepository extends JpaRepository<Installment, Long> {
}
