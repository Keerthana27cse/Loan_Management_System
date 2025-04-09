package com.java.LoanManagementSystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.LoanManagementSystem.Model.Customer;

public class CustomerTest {

    @Test
    public void testNoArgsConstructorAndSetters() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setName("Keerthana");
        customer.setEmailAddress("keerthana@example.com");
        customer.setPhoneNumber("9876543210");
        customer.setAddress("Chennai");
        customer.setCreditScore(750);

        assertEquals(1, customer.getCustomerId());
        assertEquals("Keerthana", customer.getName());
        assertEquals("keerthana@example.com", customer.getEmailAddress());
        assertEquals("9876543210", customer.getPhoneNumber());
        assertEquals("Chennai", customer.getAddress());
        assertEquals(750, customer.getCreditScore());
    }

    @Test
    public void testAllArgsConstructor() {
        Customer customer = new Customer(
            2, "Ankitha", "ankitha@example.com", "9123456789", "Bangalore", 800
        );

        assertEquals(2, customer.getCustomerId());
        assertEquals("Ankitha", customer.getName());
        assertEquals("ankitha@example.com", customer.getEmailAddress());
        assertEquals("9123456789", customer.getPhoneNumber());
        assertEquals("Bangalore", customer.getAddress());
        assertEquals(800, customer.getCreditScore());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer();
        customer.setCustomerId(3);
        String expected = "Customer(customerId=3)";
        assertEquals(expected, customer.toString());
    }
}
