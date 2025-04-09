package com.java.LoanManagementSystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.LoanManagementSystem.Model.*;

public class CarLoanTest {

    @Test
    public void testGettersAndSetters() {
        CarLoan loan = new CarLoan();
        loan.setCarModel("Hyundai Creta");
        loan.setCarValue(950000);
        
        assertEquals("Hyundai Creta", loan.getCarModel());
        assertEquals(950000, loan.getCarValue());
    }

    @Test
    public void testConstructorWithAllFields() {
        Customer customer = new Customer(1, "Keerthana", "keerthi@gmail.com", "9876543210", "Chennai", 750);
        CarLoan loan = new CarLoan(
            101,
            customer,
            500000.0,
            7.5,
            36,
            loanType.CARLOAN,
            loanStatus.APPROVED,
            "Hyundai Creta",
            950000
        );

        assertEquals(101, loan.getLoanId());
        assertEquals(customer, loan.getCustomer());
        assertEquals(500000.0, loan.getPrincipalAmount(), 0.001);
        assertEquals(7.5, loan.getInterestRate(), 0.001);
        assertEquals(36, loan.getLoanTerm());
        assertEquals(loanType.CARLOAN, loan.getLoanType());
        assertEquals(loanStatus.APPROVED, loan.getLoanStatus());
        assertEquals("Hyundai Creta", loan.getCarModel());
        assertEquals(950000, loan.getCarValue());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer(1, "Keerthana", "keerthi@gmail.com", "9876543210", "Chennai", 750);
        CarLoan loan = new CarLoan(
            101,
            customer,
            500000.0,
            7.5,
            36,
            loanType.CARLOAN,
            loanStatus.PENDING,
            "Maruti Swift",
            800000
        );

        String expected = "Loan(loanId=101, customer=Customer(customerId=1), principalAmount=500000.0, interestRate=7.5, loanTerm=36, loanType=CARLOAN, loanStatus=PENDING), carModel=Maruti Swift, carValue=800000)";
        assertEquals(expected, loan.toString());
    }
}
