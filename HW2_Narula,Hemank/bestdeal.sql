-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bestdeal
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customerorders`
--

DROP TABLE IF EXISTS `customerorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerorders` (
  `orderid` int(11) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  `ordername` varchar(50) DEFAULT NULL,
  `orderprice` double DEFAULT NULL,
  `useraddress` varchar(100) DEFAULT NULL,
  `creditcardnum` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerorders`
--

LOCK TABLES `customerorders` WRITE;
/*!40000 ALTER TABLE `customerorders` DISABLE KEYS */;
INSERT INTO `customerorders` VALUES (3,'test3','iPhone 7',699.99,'sdfasfdv','1213241345'),(4,'test4','Droid Turbo 2',549.99,'abc 23','210213642813467'),(4,'test4','Dell XPS',850.99,'abc 23','210213642813467'),(5,'test10','iPhone 7',699.99,'Chicago 60613','1234567890'),(5,'test10','Samsung Tab 2',150.99,'Chicago 60613','1234567890'),(6,'test200','Dell XPS',850.99,'Chicago 60606','2139521387435345'),(6,'test200','Samsung Tab 2',150.99,'Chicago 60606','2139521387435345'),(7,'test300','Droid Turbo 2',549.99,'Chicago 60604','293532786453254'),(7,'test300','Macbook Pro',1399.99,'Chicago 60604','293532786453254');
/*!40000 ALTER TABLE `customerorders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration` (
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `usertype` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES ('test123','test123','customer'),('test123','test123','customer'),('test123','test123','customer'),('test1','test1','customer'),('test2','test2','customer'),('test3','test3','customer'),('test4','test4','customer'),('test10','test10','customer'),('test101','test101','retailer'),('test102','test102','salesman'),('test200','test200','customer'),('test201','test201','retailer'),('test202','test202','salesman'),('test300','test300','customer'),('test301','test301','retailer'),('test302','test302','salesman');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-15  1:03:26
