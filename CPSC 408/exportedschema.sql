CREATE DATABASE  IF NOT EXISTS `cpsc408` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cpsc408`;
-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: cpsc408
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Background`
--

DROP TABLE IF EXISTS `Background`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Background` (
  `EmployeeIDBG` int DEFAULT NULL,
  `Hometown` varchar(50) DEFAULT NULL,
  `Homestate` varchar(2) DEFAULT NULL,
  `School` varchar(50) DEFAULT NULL,
  `Education` varchar(50) DEFAULT NULL,
  KEY `EmployeeIDBG` (`EmployeeIDBG`),
  CONSTRAINT `EmployeeIDBG` FOREIGN KEY (`EmployeeIDBG`) REFERENCES `Employees` (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Contact`
--

DROP TABLE IF EXISTS `Contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Contact` (
  `EmployeeIDContact` int DEFAULT NULL,
  `EmergencyPhone` varchar(50) DEFAULT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `EmergencyContact` varchar(45) DEFAULT NULL,
  `EmergencyRelation` varchar(45) DEFAULT NULL,
  KEY `EmployeeIDContact` (`EmployeeIDContact`),
  CONSTRAINT `EmployeeIDContact` FOREIGN KEY (`EmployeeIDContact`) REFERENCES `Employees` (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Department`
--

DROP TABLE IF EXISTS `Department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Department` (
  `EmployeeIDDepart` int DEFAULT NULL,
  `JobTitle` varchar(50) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  `Income` int DEFAULT '0',
  KEY `EmployeeIDDepart` (`EmployeeIDDepart`),
  CONSTRAINT `EmployeeIDDepart` FOREIGN KEY (`EmployeeIDDepart`) REFERENCES `Employees` (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Employees`
--

DROP TABLE IF EXISTS `Employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employees` (
  `EmployeeID` int NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `YearsExp` int DEFAULT NULL,
  `StartingYear` int DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `DOB` varchar(8) DEFAULT NULL,
  `MaritalStatus` varchar(20) DEFAULT NULL,
  `Ethnicity` varchar(50) DEFAULT NULL,
  `Overtime` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `HumanResources`
--

DROP TABLE IF EXISTS `HumanResources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HumanResources` (
  `EmployeeIDHR` int DEFAULT NULL,
  `Complaint` varchar(1000) DEFAULT NULL,
  `ComplaintDate` varchar(45) DEFAULT NULL,
  `ComplaintTime` varchar(45) DEFAULT NULL,
  KEY `EmployeeIDHR` (`EmployeeIDHR`),
  CONSTRAINT `EmployeeIDHR` FOREIGN KEY (`EmployeeIDHR`) REFERENCES `Employees` (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Payment`
--

DROP TABLE IF EXISTS `Payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Payment` (
  `EmployeeIDPay` int DEFAULT NULL,
  `PayRate` varchar(45) DEFAULT NULL,
  `PayType` varchar(45) DEFAULT NULL,
  `Absences` int DEFAULT '0',
  `OvertimeHours` int DEFAULT '0',
  KEY `EmployeeIDPay` (`EmployeeIDPay`),
  CONSTRAINT `EmployeeIDPay` FOREIGN KEY (`EmployeeIDPay`) REFERENCES `Employees` (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Phonebook`
--

DROP TABLE IF EXISTS `Phonebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Phonebook` (
  `EmployeeIDPB` int DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `EmergencyPhone` varchar(45) DEFAULT NULL,
  KEY `EmployeeIDPB` (`EmployeeIDPB`),
  CONSTRAINT `EmployeeIDPB` FOREIGN KEY (`EmployeeIDPB`) REFERENCES `Employees` (`EmployeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-07 15:18:32
