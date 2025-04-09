CREATE DATABASE  Loan_Management_System;
USE Loan_Management_System;


CREATE TABLE Customer (
    customerId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    emailAddress VARCHAR(100) UNIQUE NOT NULL,
    phoneNumber VARCHAR(15) NOT NULL,
    address TEXT NOT NULL,
    creditScore INT NOT NULL
);
--------------------------------------------------

CREATE TABLE Loan (
    loanId INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT NOT NULL,
    principalAmount DECIMAL(12, 2) NOT NULL,
    interestRate DECIMAL(5, 2) NOT NULL,
    loanTerm INT NOT NULL,
    loanType ENUM('CARLOAN', 'HOMELOAN') NOT NULL,
    loanStatus ENUM('PENDING', 'APPROVED','REJECTED') NOT NULL,
    propertyAddress TEXT,
    propertyValue INT,
    carModel VARCHAR(100),
    carValue INT,

    FOREIGN KEY (customerId) REFERENCES Customer(customerId)
        ON DELETE CASCADE
);
---------------------------------------

INSERT INTO Customer (name, emailAddress, phoneNumber, address, creditScore)
VALUES 
('Ravi Kumar', 'ravi.kumar@example.com', '9876543210', '123 MG Road, Bangalore', 700),
('Anjali Mehta', 'anjali.mehta@example.com', '9123456789', '45 Park Street, Mumbai', 620);

INSERT INTO Loan (
    customerId, principalAmount, interestRate, loanTerm,
    loanType, loanStatus, propertyAddress, propertyValue) VALUES 
    (1, 5000000.00, 7.5, 240,
    'HomeLoan', 'Pending', 'Whitefield' , 6000000);
    
INSERT INTO Loan (
    customerId, principalAmount, interestRate, loanTerm,
    loanType, loanStatus, carModel, carValue)VALUES 
    (2, 800000.00, 9.0, 60,
    'CarLoan', 'Pending','Hyundai Creta', 950000);

select*from customer;
select*from loan;