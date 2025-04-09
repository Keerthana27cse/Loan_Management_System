package com.java.LoanManagementSystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.LoanManagementSystem.Model.Customer;
import com.java.LoanManagementSystem.Model.HomeLoan;

public class HomeLoanTest {


    @Test
    public void testGettersAndSetters() {
        HomeLoan homeLoan = new HomeLoan();
        homeLoan.setPropertyAddress("12, Lake View Street");
        homeLoan.setPropertyValue(2500000);

        assertEquals("12, Lake View Street", homeLoan.getPropertyAddress());
        assertEquals(2500000, homeLoan.getPropertyValue());
    }

    @Test
    public void testConstructor() {
        Customer customer = new Customer(); // Optional: Set customer details if needed
        HomeLoan loan = new HomeLoan(101, customer, 1500000, 6.5, 60, null, null, "123 MG Road", 4500000);

        assertEquals(101, loan.getLoanId());
        assertEquals(customer, loan.getCustomer());
        assertEquals(1500000, loan.getPrincipalAmount(), 0.01);
        assertEquals(6.5, loan.getInterestRate(), 0.01);
        assertEquals(60, loan.getLoanTerm());
        assertEquals("123 MG Road", loan.getPropertyAddress());
        assertEquals(4500000, loan.getPropertyValue());
    }

    @Test
    public void testToString() {
        HomeLoan loan = new HomeLoan();
        loan.setPropertyAddress("456 Park Lane");
        loan.setPropertyValue(3500000);

        String expected = loan.toString();
        assertTrue(expected.contains("propertyAddress=456 Park Lane"));
        assertTrue(expected.contains("propertyValue=3500000"));
    }
}