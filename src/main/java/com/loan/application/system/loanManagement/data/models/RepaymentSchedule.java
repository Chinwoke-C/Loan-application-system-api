package com.loan.application.system.loanManagement.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class RepaymentSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Installment> installments;
    @OneToOne/*(mappedBy = "repaymentSchedule")*/
    private LoanAgreement loanAgreement;
}
