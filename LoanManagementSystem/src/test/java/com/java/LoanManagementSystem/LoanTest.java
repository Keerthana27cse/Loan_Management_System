package com.java.LoanManagementSystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.LoanManagementSystem.Model.Customer;
import com.java.LoanManagementSystem.Model.Loan;
import com.java.LoanManagementSystem.Model.loanStatus;
import com.java.LoanManagementSystem.Model.loanType;

public class LoanTest {

	@Test
    public void testGettersAndSetters() {
        Loan loan = new Loan();
        Customer customer = new Customer(1, "John Doe", "john@example.com", "9876543210", "Chennai", 720);

        loan.setLoanId(101);
        loan.setCustomer(customer);
        loan.setPrincipalAmount(500000);
        loan.setInterestRate(7.5);
        loan.setLoanTerm(36);
        loan.setLoanType(loanType.HOMELOAN);
        loan.setLoanStatus(loanStatus.PENDING);

        assertEquals(101, loan.getLoanId());
        assertEquals(customer, loan.getCustomer());
        assertEquals(500000, loan.getPrincipalAmount(), 0.01);
        assertEquals(7.5, loan.getInterestRate(), 0.01);
        assertEquals(36, loan.getLoanTerm());
        assertEquals(loanType.HOMELOAN, loan.getLoanType());
        assertEquals(loanStatus.PENDING, loan.getLoanStatus());
    }

    @Test
    public void testConstructor() {
        Customer customer = new Customer(2, "Jane Smith", "jane@example.com", "9876543200", "Hyderabad", 780);
        Loan loan = new Loan(102, customer, 750000, 8.0, 48, loanType.CARLOAN, loanStatus.APPROVED);

        assertEquals(102, loan.getLoanId());
        assertEquals(customer, loan.getCustomer());
        assertEquals(750000, loan.getPrincipalAmount(), 0.01);
        assertEquals(8.0, loan.getInterestRate(), 0.01);
        assertEquals(48, loan.getLoanTerm());
        assertEquals(loanType.CARLOAN, loan.getLoanType());
        assertEquals(loanStatus.APPROVED, loan.getLoanStatus());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer(3, "Robert Stark", "robert@example.com", "1234567890", "Winterfell", 800);
        Loan loan = new Loan(103, customer, 600000, 6.9, 36, loanType.HOMELOAN, loanStatus.PENDING);

        String expected = "Loan(loanId=103, customer=Customer(customerId=3), " +
                          "principalAmount=600000.0, interestRate=6.9, loanTerm=36, " +
                          "loanType=HOMELOAN, loanStatus=PENDING)";

        assertEquals(expected, loan.toString());
    }
}