package com.java.LoanManagementSystem.Main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.LoanManagementSystem.Dao.ILoanRepository;
import com.java.LoanManagementSystem.Dao.ILoanRepositoryImpl;
import com.java.LoanManagementSystem.Exception.InvalidLoanException;
import com.java.LoanManagementSystem.Model.CarLoan;
import com.java.LoanManagementSystem.Model.Customer;
import com.java.LoanManagementSystem.Model.HomeLoan;
import com.java.LoanManagementSystem.Model.Loan;
import com.java.LoanManagementSystem.Model.loanStatus;
import com.java.LoanManagementSystem.Model.loanType;

public class LoanManagement {
	static Scanner sc;
    static ILoanRepository iloan;
    static {
        sc = new Scanner(System.in);
        iloan = new ILoanRepositoryImpl();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int choice;

        do {
            System.out.println("\n--------------------------------------");
            System.out.println("         LOAN MANAGEMENT SYSTEM       ");
            System.out.println("--------------------------------------");
            System.out.println("1. Apply Loan");
            System.out.println("2. Get All Loans");
            System.out.println("3. Get Loan by ID");
            System.out.println("4. Loan Repayment");
            System.out.println("5. Check Loan Status");
            System.out.println("6. Check EMI");
            System.out.println("7. Check Interest");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                applyLoanMain();
                break;
            case 2:
                getAllLoanMain();
                break;
            case 3:
                getLoanMain();
                break;
            case 4:
                loanRepaymentMain();
                break;
            case 5:
                loanStatusMain();
                break;
            case 6:
                checkEMIMain();
                break;
            case 7:
                checkInterestMain();
                break;
            case 8:
                System.out.println("Exiting system...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }

    } while (choice != 8);
}
    public static void applyLoanMain() {
        try {
            System.out.print("Enter Customer ID: ");
            int custId = sc.nextInt();

            System.out.print("Enter Principal Amount: ");
            double principal = sc.nextDouble();

            System.out.print("Enter Interest Rate: ");
            double interest = sc.nextDouble();

            System.out.print("Enter Loan Term (months): ");
            int term = sc.nextInt();
            sc.nextLine();
            

            System.out.print("Enter Loan Type (CARLOAN / HOMELOAN): ");
            String typeStr = sc.nextLine().toUpperCase();

            Loan loan;
            Customer customer = new Customer();
            customer.setCustomerId(custId);

            if (typeStr.equals("HOMELOAN")) {
                HomeLoan hl = new HomeLoan();
                hl.setCustomer(customer);
                hl.setPrincipalAmount(principal);
                hl.setInterestRate(interest);
                hl.setLoanTerm(term);
                hl.setLoanType(loanType.HOMELOAN);
                hl.setLoanStatus(loanStatus.PENDING);

                System.out.print("Enter Property Address: ");
                hl.setPropertyAddress(sc.nextLine());

                System.out.print("Enter Property Value: ");
                hl.setPropertyValue(sc.nextInt());
                loan = hl;
            } else if (typeStr.equals("CARLOAN")) {
                CarLoan cl = new CarLoan();
                cl.setCustomer(customer);
                cl.setPrincipalAmount(principal);
                cl.setInterestRate(interest);
                cl.setLoanTerm(term);
                cl.setLoanType(loanType.CARLOAN);
                cl.setLoanStatus(loanStatus.PENDING);

                System.out.print("Enter Car Model: ");
                cl.setCarModel(sc.nextLine());

                System.out.print("Enter Car Value: ");
                cl.setCarValue(sc.nextInt());
                loan = cl;
            } else {
                System.out.println("Invalid loan type entered.");
                return;
            }
            iloan.applyLoan(loan);
        } catch (Exception e) {
            System.out.println("Error applying loan: " + e.getMessage());
        }
    }

    public static void getAllLoanMain() {
        try {
            List<Loan> loans = iloan.getAllLoan();
            for (Loan loan : loans) { 
                System.out.println(loan);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error retrieving loans: " + e.getMessage());
        }
    }


    public static void getLoanMain() {
        System.out.print("Enter Loan ID: ");
        int loanId = sc.nextInt();
        try {
            Loan loan = iloan.getLoanById(loanId);
            System.out.println(loan);
        } catch (InvalidLoanException e) {
            System.out.println("Loan not found: " + e.getMessage());
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    public static void loanRepaymentMain() {
        System.out.print("Enter Loan ID: ");
        int loanId = sc.nextInt();
        System.out.print("Enter Repayment Amount: ");
        double amount = sc.nextDouble();

        try {
            iloan.loanRepayment(loanId, amount);
        } catch (InvalidLoanException e) {
            System.out.println("Invalid Loan: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    public static void loanStatusMain() {
        System.out.print("Enter Loan ID: ");
        int loanId = sc.nextInt();
        try {
            String status = iloan.loanStatus(loanId);
            System.out.println("Loan Status: " + status);
        } catch (InvalidLoanException e) {
            System.out.println("Invalid Loan: " + e.getMessage());
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    public static void checkEMIMain() {
        System.out.print("Enter Loan ID: ");
        int loanId = sc.nextInt();
        try {
            double emi = iloan.calculateEMI(loanId);
            System.out.println("Monthly EMI: ₹" + emi);
        } catch (InvalidLoanException e) {
            System.out.println("Invalid Loan: " + e.getMessage());
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    public static void checkInterestMain() {
        System.out.print("Enter Loan ID: ");
        int loanId = sc.nextInt();
        try {
            double interest = iloan.calculateInterest(loanId);
            System.out.println("Total Interest: ₹" + interest);
        } catch (InvalidLoanException e) {
            System.out.println("Invalid Loan: " + e.getMessage());
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}