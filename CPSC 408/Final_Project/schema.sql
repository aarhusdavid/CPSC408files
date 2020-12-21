DROP TABLE IF EXISTS `Contact`;
DROP TABLE IF EXISTS `HumanResources`;
DROP TABLE IF EXISTS `Background`;
DROP TABLE IF EXISTS `Payment`;
DROP TABLE IF EXISTS `Phonebook`;
DROP TABLE IF EXISTS `Department`;

-- creates Employees table
DROP TABLE IF EXISTS `Employees`;
CREATE TABLE Employees(
    EmployeeID int NOT NULL,
    Address varchar(50) DEFAULT NULL,
    Age int DEFAULT NULL,
    YearsExp int DEFAULT NULL,
    StartingYear int DEFAULT NULL,
    Gender varchar(1) DEFAULT NULL,
    Email varchar(50) DEFAULT NULL,
    birthmonth varchar(8) DEFAULT NULL,
    MaritalStatus varchar(20) DEFAULT NULL,
    Ethnicity varchar(50) DEFAULT NULL,
    PRIMARY KEY (EmployeeID));

-- creates PhoneBook table
CREATE TABLE Phonebook(
    EmployeeIDPB int DEFAULT NULL,
    Phone varchar(45) DEFAULT NULL,
    EmergencyPhone varchar(45) DEFAULT NULL,
    CONSTRAINT EmployeeIDPB FOREIGN KEY (EmployeeIDPB) REFERENCES Employees (EmployeeID));

-- creates Department table
CREATE TABLE Department (
    EmployeeIDDepart int DEFAULT NULL,
    JobTitle varchar(50) DEFAULT NULL,
    Department varchar(50) DEFAULT NULL,
    Income int DEFAULT NULL,
    CONSTRAINT EmployeeIDDepart FOREIGN KEY (EmployeeIDDepart) REFERENCES Employees (EmployeeID));

-- creates Contact table
CREATE TABLE Contact (
    EmployeeIDContact int DEFAULT NULL,
    FirstName varchar(45) DEFAULT NULL,
    LastName varchar(45) DEFAULT NULL,
    EmergencyContact varchar(45) DEFAULT NULL,
    EmergencyRelation varchar(45) DEFAULT NULL,
    CONSTRAINT EmployeeIDContact FOREIGN KEY (EmployeeIDContact) REFERENCES Employees (EmployeeID));

-- creates HumanResources table
CREATE TABLE HumanResources (
    EmployeeIDHR int DEFAULT NULL,
    Complaint varchar(1000) DEFAULT NULL,
    ComplaintDate varchar(45) DEFAULT NULL,
    ComplaintTime varchar(45) DEFAULT NULL,
    CONSTRAINT EmployeeIDHR FOREIGN KEY (EmployeeIDHR) REFERENCES Employees (EmployeeID));

-- creates Background table
CREATE TABLE Background (
    EmployeeIDBG int DEFAULT NULL,
    Hometown varchar(50) DEFAULT NULL,
    Homestate varchar(2) DEFAULT NULL,
    School varchar(50) DEFAULT NULL,
    Education varchar(50) DEFAULT NULL,
    CONSTRAINT EmployeeIDBG FOREIGN KEY (EmployeeIDBG) REFERENCES Employees (EmployeeID));

-- creates Payment table
CREATE TABLE Payment (
    EmployeeIDPay int DEFAULT NULL,
    PayRate varchar(45) DEFAULT NULL,
    PayType varchar(45) DEFAULT NULL,
    Absences int DEFAULT NULL,
    OvertimeHours int DEFAULT NULL,
    CONSTRAINT EmployeeIDPay FOREIGN KEY (EmployeeIDPay) REFERENCES Employees (EmployeeID));

-- creates Background trigger

-- CREATE TRIGGER Background_BEFORE_INSERT BEFORE INSERT ON Background
--     FOR EACH ROW
--     BEGIN
--         IF NEW.School = 'High School' THEN
--             SET NEW.Education = 'hs diploma';
--         END IF;
--     END;

-- NEED trigger for HumanResources
-- NEED trigger for DepartmentTable
