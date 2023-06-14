package com.loan.application.system.loanManagement.data.repositories;

import com.loan.application.system.loanManagement.data.models.RepaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepaymentScheduleRepository extends JpaRepository<RepaymentSchedule, Long> {
}
