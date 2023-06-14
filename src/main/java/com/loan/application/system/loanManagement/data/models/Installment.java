package com.loan.application.system.loanManagement.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Installment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private LocalDate dueDate;
    private BigDecimal amount;
}
