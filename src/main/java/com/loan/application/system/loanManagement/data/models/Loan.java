package com.loan.application.system.loanManagement.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String loanName;
    private BigDecimal amount;
    private String purpose;
    private LoanStatus status;
    private LocalDate loanDate;
    private int interest;
}
