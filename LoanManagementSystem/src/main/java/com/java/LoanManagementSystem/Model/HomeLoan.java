package com.java.LoanManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class HomeLoan extends Loan {
    private String propertyAddress;
    private int propertyValue;
    public HomeLoan(int loanId, Customer customer, int principalAmount, double interestRate,
            int loanTerm, loanType loanType, loanStatus loanStatus,
            String propertyAddress, int propertyValue) {
super(loanId, customer, principalAmount, interestRate, loanTerm, loanType, loanStatus);
this.propertyAddress = propertyAddress;
this.propertyValue = propertyValue;
}

@Override
public String toString() {
return super.toString() +
       ", propertyAddress=" + propertyAddress +
       ", propertyValue=" + propertyValue + ")";
}
}