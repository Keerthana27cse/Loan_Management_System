package com.java.LoanManagementSystem.Dao;

import java.sql.SQLException;
import java.util.List;

import com.java.LoanManagementSystem.Exception.InvalidLoanException;
import com.java.LoanManagementSystem.Model.Loan;

public interface ILoanRepository
{
	void applyLoan(Loan loan) throws ClassNotFoundException, SQLException;

    double calculateInterest(int loanId) throws InvalidLoanException, ClassNotFoundException, SQLException;

    double calculateInterest(double principal, double rate, int tenureMonths);

    String loanStatus(int loanId) throws  InvalidLoanException, ClassNotFoundException, SQLException;

    double calculateEMI(int loanId) throws InvalidLoanException, SQLException, ClassNotFoundException;

    double calculateEMI(double principal, double rate, int tenureMonths);

    void loanRepayment(int loanId, double amount) throws InvalidLoanException, ClassNotFoundException, Exception;

    List<Loan> getAllLoan() throws SQLException, ClassNotFoundException;

    Loan getLoanById(int loanId) throws InvalidLoanException, SQLException, ClassNotFoundException;
}
	 
