package com.java.LoanManagementSystem.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarLoan extends Loan {
    private String carModel;
    private int carValue;

    // Custom constructor to include superclass (Loan) fields + CarLoan fields
    public CarLoan(int loanId, Customer customer, double principalAmount, double interestRate,
                   int loanTerm, loanType loanType, loanStatus loanStatus,
                   String carModel, int carValue) {
        super(loanId, customer, principalAmount, interestRate, loanTerm, loanType, loanStatus);
        this.carModel = carModel;
        this.carValue = carValue;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", carModel=" + carModel +
               ", carValue=" + carValue + ")";
    }
}

