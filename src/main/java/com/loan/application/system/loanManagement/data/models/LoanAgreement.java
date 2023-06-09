package com.loan.application.system.loanManagement.data.models;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class LoanAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @JsonUnwrapped
    private Loan loanDetails;
    private String repaymentTerms;
    @OneToOne/*(cascade = )*/
    private RepaymentSchedule repaymentSchedule;
}
