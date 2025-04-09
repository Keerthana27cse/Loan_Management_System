package com.java.LoanManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Loan 
{
    private int loanId;
    private Customer customer;
    private double principalAmount;
    private double interestRate;
    private int loanTerm;
    private loanType loanType;
    private loanStatus LoanStatus;
    @Override
    public String toString() {
        return "Loan(loanId=" + loanId + ", customer=" + customer +
               ", principalAmount=" + principalAmount +
               ", interestRate=" + interestRate +
               ", loanTerm=" + loanTerm +
               ", loanType=" + loanType +
               ", loanStatus=" + LoanStatus + ")";
    }


}
