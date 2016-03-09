CREATE DATABASE  IF NOT EXISTS `doubledate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `doubledate`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: doubledate
-- ------------------------------------------------------
-- Server version	5.6.20-log

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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activity` (
  `activityId` int(11) NOT NULL AUTO_INCREMENT,
  `activityName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`activityId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'reading'),(2,'cooking'),(3,'hiking'),(4,'arts'),(5,'movies'),(6,'fishing'),(7,'gaming'),(8,'dancing');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `couple_info`
--

DROP TABLE IF EXISTS `couple_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `couple_info` (
  `info_Id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) DEFAULT NULL,
  `lookingfor` varchar(255) DEFAULT NULL,
  `musicArtists` varchar(255) DEFAULT NULL,
  `relationshipAge` varchar(255) DEFAULT NULL,
  `restaurants` varchar(255) DEFAULT NULL,
  `story` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`info_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `couple_info`
--

LOCK TABLES `couple_info` WRITE;
/*!40000 ALTER TABLE `couple_info` DISABLE KEYS */;
INSERT INTO `couple_info` VALUES (1,'Boston','To have Fun with other couples','Armin Van Burren',NULL,'Hangout','We Met in London and fell in Love since then......'),(2,'Boston','Someone who enjoys music,,,','A R Rehman',NULL,'ABC','We were best friends and fell in love...'),(3,'Maharashtra, India','Couples who enjoy drinks in the evening..','Maroon 5',NULL,'U burger','We are in on and off relationship..~~'),(4,'Boston','Couples who love to take adventures to next level','Taylor Swift',NULL,'Panda Express','We met in central Park.....'),(5,'Boston','FUNNNNNNNNNNNNNNNNNN....!','kk',NULL,'Shwarma','Love at first sight.....'),(6,'Boston','Outdoor activitiessss....','Owl City',NULL,'Round table Pizzas','No story as such!! :('),(7,'Boston','People who prefer to stay indoors as its too cold outside','Justin Beiber',NULL,'Mc Donalds','Our friends introduced us,.,,'),(8,'Boston','Couples who stay indoors','KK',NULL,'Frankiln','We met and magic happened...');
/*!40000 ALTER TABLE `couple_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `couple_signup`
--

DROP TABLE IF EXISTS `couple_signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `couple_signup` (
  `coupleId` int(11) NOT NULL AUTO_INCREMENT,
  `authenticated` bit(1) DEFAULT NULL,
  `coupleName` varchar(255) DEFAULT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remember` bit(1) DEFAULT NULL,
  `info_Id_FK` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`coupleId`),
  KEY `FK_81wo0flla19fet7dfonof27kr` (`info_Id_FK`),
  KEY `FK_ehwcyk2s53a7pcekjr6pe96df` (`role_id`),
  CONSTRAINT `FK_81wo0flla19fet7dfonof27kr` FOREIGN KEY (`info_Id_FK`) REFERENCES `couple_info` (`info_Id`),
  CONSTRAINT `FK_ehwcyk2s53a7pcekjr6pe96df` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `couple_signup`
--

LOCK TABLES `couple_signup` WRITE;
/*!40000 ALTER TABLE `couple_signup` DISABLE KEYS */;
INSERT INTO `couple_signup` VALUES (1,NULL,'Bings','abc@example.com','password',NULL,1,2),(2,NULL,'Nobels','ggg@gg.com','password',NULL,2,2),(3,NULL,'Gellers','aaa@gmm.com','password',NULL,3,2),(4,NULL,'Mosbeys','uu@hh.com','password',NULL,4,2),(5,NULL,'Eriskson','erikson@gg.com','password',NULL,5,2),(6,NULL,'shahs','ss@hh.com','password',NULL,6,2),(7,NULL,'Grill','grill@gmail.com','password',NULL,7,2),(8,NULL,'Panchals','ii@jj.com','password',NULL,8,2),(9,NULL,'Haammm','gg@hh.com','password',NULL,NULL,2);
/*!40000 ALTER TABLE `couple_signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupleactivity`
--

DROP TABLE IF EXISTS `coupleactivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupleactivity` (
  `info_id` int(11) NOT NULL,
  `activityId` int(11) NOT NULL,
  KEY `FK_64sjedebv2gweld8n1gysfd9t` (`activityId`),
  KEY `FK_a8okphnxcmw2cslqw4n4i5ffh` (`info_id`),
  CONSTRAINT `FK_64sjedebv2gweld8n1gysfd9t` FOREIGN KEY (`activityId`) REFERENCES `activity` (`activityId`),
  CONSTRAINT `FK_a8okphnxcmw2cslqw4n4i5ffh` FOREIGN KEY (`info_id`) REFERENCES `couple_info` (`info_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupleactivity`
--

LOCK TABLES `coupleactivity` WRITE;
/*!40000 ALTER TABLE `coupleactivity` DISABLE KEYS */;
INSERT INTO `coupleactivity` VALUES (1,1),(1,2),(2,3),(2,4),(2,5),(4,3),(4,5),(4,6),(5,4),(5,7),(6,3),(6,6),(6,7),(7,5),(7,8),(8,1),(8,5),(3,2),(3,8);
/*!40000 ALTER TABLE `coupleactivity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend_zone`
--

DROP TABLE IF EXISTS `friend_zone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend_zone` (
  `relationId` int(11) NOT NULL AUTO_INCREMENT,
  `accepted` bit(1) NOT NULL,
  `fromUser` int(11) NOT NULL,
  `toUser` int(11) NOT NULL,
  `unfriend` bit(1) NOT NULL,
  PRIMARY KEY (`relationId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend_zone`
--

LOCK TABLES `friend_zone` WRITE;
/*!40000 ALTER TABLE `friend_zone` DISABLE KEYS */;
INSERT INTO `friend_zone` VALUES (1,'',7,1,'\0'),(2,'',7,3,'\0'),(3,'\0',3,2,'\0'),(4,'\0',3,5,'\0'),(5,'',3,1,'\0');
/*!40000 ALTER TABLE `friend_zone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inbox`
--

DROP TABLE IF EXISTS `inbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inbox` (
  `InboxId` int(11) NOT NULL AUTO_INCREMENT,
  `DateOfMsg` datetime DEFAULT NULL,
  `Message` varchar(255) DEFAULT NULL,
  `fromUser` int(11) DEFAULT NULL,
  `toUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`InboxId`),
  KEY `FK_dkdi755m60011tl1omlppmr7a` (`fromUser`),
  KEY `FK_78ltpm5ff7aebrer49f57l471` (`toUser`),
  CONSTRAINT `FK_78ltpm5ff7aebrer49f57l471` FOREIGN KEY (`toUser`) REFERENCES `couple_signup` (`coupleId`),
  CONSTRAINT `FK_dkdi755m60011tl1omlppmr7a` FOREIGN KEY (`fromUser`) REFERENCES `couple_signup` (`coupleId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inbox`
--

LOCK TABLES `inbox` WRITE;
/*!40000 ALTER TABLE `inbox` DISABLE KEYS */;
INSERT INTO `inbox` VALUES (1,'2015-04-24 05:41:11','Hello Grills!!',3,7),(2,'2015-04-24 05:42:13','hi how are you?',7,3),(3,'2015-04-24 05:43:19','Yeah! sure. How about this friday??',3,7),(4,'2015-04-24 05:44:58','Hi! Please accept my friend request?',3,2),(5,'2015-04-24 11:31:21','Hello Nobels!! Can I add you as a friend??',1,2),(6,'2015-04-24 11:31:42','Are you there?',1,2),(7,'2015-04-24 11:42:45','Plz reply!',1,2),(8,'2015-04-24 12:02:03','Did you receive my message?',3,7),(9,'2015-04-24 12:34:53','Hello Bings!!',3,1),(10,'2015-04-24 12:36:56','Are You there???',3,1);
/*!40000 ALTER TABLE `inbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `personId` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `emailId` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `hometown` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `coupleinfo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`personId`),
  KEY `FK_lt8926kjlvohw28os3o46c3n9` (`coupleinfo_id`),
  CONSTRAINT `FK_lt8926kjlvohw28os3o46c3n9` FOREIGN KEY (`coupleinfo_id`) REFERENCES `couple_info` (`info_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,55,'abc@example.com','Chandler','New York','Bing','Accountant','4546545656','male',1),(2,30,'chef@eh.com','Monica','New York','Mistry','Chef','2324352357','female',1),(3,24,'yyy@hh.com','Alfred','New Jersey','Nobel','Teacher','6665557774','male',2),(4,22,'acac@gmaikc.xxx','Sheily','New York','Gomes','Software Engg','7788224455','female',2),(5,34,'email@hh.com','Ross','Boston','Geller','Palentologist','2299443366','female',3),(6,30,'ff@gg.com','Rachel','New York','Green','Stylist','0099224488','female',3),(7,40,'ted@gmail.com','Ted','San Fransisco','Mosbey','Architect','9988664422','male',4),(8,34,'id@gg.com','Rose','Hamilton','Mosbey','sales','8800991100','female',4),(9,18,'jj@kk.com','Marshall','Colorado','Erikson','Lawyer','8855440099','male',5),(10,22,'uu@jj.com','Lilly','Mumbai','Erikson','Accountant','7744661166','female',5),(11,45,'uu@hh.com','Jinal','Mumbai','Shah','Housewife','8833881177','female',6),(12,55,'kk@hh.com','Mani','Pune','Shah','Tester','7700771177','female',6),(13,31,'kk@jj.com','Joey','cambridge','Grill','Developer','9988116677','male',7),(14,29,'mm@hh.com','Kathy','Peterborough','Grill','Construction','8822001188','female',7),(15,22,'hh@jj.com','james','Pune','Panchal','Carpenter','5588771133','male',8),(16,24,'kk@hh.com','Pinky','Vapi','Panchal','Self employed','4488991144','female',8);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token_check`
--

DROP TABLE IF EXISTS `token_check`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token_check` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `token_No` varchar(255) DEFAULT NULL,
  `coupleId_Fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_qigomayhaiilu22o9vfi08j75` (`coupleId_Fk`),
  CONSTRAINT `FK_qigomayhaiilu22o9vfi08j75` FOREIGN KEY (`coupleId_Fk`) REFERENCES `couple_signup` (`coupleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token_check`
--

LOCK TABLES `token_check` WRITE;
/*!40000 ALTER TABLE `token_check` DISABLE KEYS */;
/*!40000 ALTER TABLE `token_check` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'doubledate'
--

--
-- Dumping routines for database 'doubledate'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-24 17:00:01
