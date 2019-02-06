-- MySQL dump 10.13  Distrib 5.5.0-m2, for Win64 (unknown)
--
-- Host: localhost    Database: newreport
-- ------------------------------------------------------
-- Server version	5.5.0-m2-community

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
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `class` int(11) DEFAULT NULL,
  `section` char(1) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,1,'A'),(2,1,'B'),(3,1,'C'),(4,2,'A'),(5,2,'B'),(6,2,'C'),(7,3,'A'),(8,3,'B'),(9,3,'C');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_subject_map`
--

DROP TABLE IF EXISTS `class_subject_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_subject_map` (
  `csub_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL,
  `sub_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`csub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_subject_map`
--

LOCK TABLES `class_subject_map` WRITE;
/*!40000 ALTER TABLE `class_subject_map` DISABLE KEYS */;
INSERT INTO `class_subject_map` VALUES (1,1,1),(2,2,1),(3,3,1),(4,1,4),(5,2,4),(6,3,4),(7,1,5),(8,2,5),(9,3,5),(10,4,1),(11,5,1),(12,6,1),(13,4,2),(14,5,2),(15,6,2),(16,4,5),(17,5,5),(18,6,5),(19,4,3),(20,5,3),(21,6,3),(22,7,1),(23,8,1),(24,9,1),(25,7,2),(26,8,2),(27,9,2),(28,7,3),(29,8,3),(30,9,3),(31,7,4),(32,8,4),(33,9,4),(34,7,5),(35,8,5),(36,9,5);
/*!40000 ALTER TABLE `class_subject_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `stud_id` int(11) NOT NULL AUTO_INCREMENT,
  `rollno` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`stud_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (3,1,1),(4,2,1),(5,3,1),(6,1,2),(7,2,2),(8,3,2),(9,1,3),(10,2,3),(11,3,3),(12,1,4),(13,2,4),(14,3,4),(15,1,5),(16,2,5),(17,3,5),(18,1,6),(19,2,6),(20,3,6),(21,1,7),(22,2,7),(23,3,7),(24,1,8),(25,2,8),(26,3,8),(27,1,9),(28,2,9),(29,3,9);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_details`
--

DROP TABLE IF EXISTS `students_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students_details` (
  `stud_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `fathers_name` varchar(20) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `blood_group` varchar(3) DEFAULT NULL,
  `disability` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`stud_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_details`
--

LOCK TABLES `students_details` WRITE;
/*!40000 ALTER TABLE `students_details` DISABLE KEYS */;
INSERT INTO `students_details` VALUES (1,'Timothy','Patrick','+91456864457','Wavre venelle du bois de villers','A+','no'),(2,'Alex','Jean','+91956896457','Ottignies rue du villqge','B+','no'),(3,'Tom','Pierre','+91475855534','151 abc','B+','no'),(4,'Lavisha','Harish','+919678697868','123 xyz','AB+','no'),(5,'Sanyam','Raghav','+919898767654','181 AR','O+','no'),(6,'Harshil','Aarav','+919123456786','hailee street 101','O-','no'),(7,'Deepak','Abhinav arora','+919876543210','181 FHG','O-','yes'),(8,'Matthas','Andrew','+919125556786','145 nmb','A+','yes'),(9,'Surbhi','Bhavya arora','+919876533310','222 FHG','O+','no'),(10,'Mathew','Eric','+919111556786','145 brb','B+','no'),(11,'Ravinder','Rajendra arora','+919876533111','222 abc nagar','B+','no'),(12,'Akanksha','Aayush','+919111666786','145 br','O-','no'),(13,'Ravi','Raj arora','+919876533123','1112 abc nagar','O+','no'),(14,'Abhi','Rupinder','+919111688586','abcdefgh','B+','no'),(15,'Bhavya','Hanish','+919876533008','11 xyz nagar','B+','no'),(16,'Harman','Dapinder','+919123488586','Vikas Nagar','AB+','no'),(17,'Harsh','Harman','+919873456008','11 dev nagar','B+','no'),(18,'Paul','Ives','+919123968586','1300 wavre','A+','no'),(19,'Nadia','Bernard','+916533456008','ottignies louvqim la neuve','B-','no'),(20,'David','Charles','+919123999586','1301 Limal','A+','no'),(21,'Charline','Benoit','+9165339456008','Leuven','AB','no'),(22,'Ugo','Olivier','+919167899586','1302 Bierge','A-','no'),(23,'Seb','Nathan','+9165330056008','Bruxelles','B+','no'),(24,'Alisa','Rohan','+919127834586','1390 Belgium','AB-','yes'),(25,'Michael','John','+916533034555','Los Angeles street No. 10','O','yes'),(26,'William','Albert','+919126894586','1390 Durga nagar','B+','no'),(27,'Mike','Alex','+916533345555','France street No. 12','O+','no');
/*!40000 ALTER TABLE `students_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `sub_id` int(11) NOT NULL AUTO_INCREMENT,
  `subname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Literature'),(2,'Science'),(3,'Social Studies'),(4,'General Knowledge'),(5,'Mathematics');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'one'),(2,'two'),(3,'three'),(4,'four'),(5,'five');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-05 14:15:09
