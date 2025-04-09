package com.java.LoanManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer 
{
	    private int customerId;
	    private String name;
	    private String emailAddress;
	    private String phoneNumber;
	    private String address;
	    private int creditScore;
	    @Override
	    public String toString() {
	        return "Customer(customerId=" + customerId + ")";
	    }
}