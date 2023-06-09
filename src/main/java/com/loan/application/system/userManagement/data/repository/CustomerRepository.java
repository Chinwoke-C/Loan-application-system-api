package com.loan.application.system.userManagement.data.repository;

import com.loan.application.system.userManagement.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
