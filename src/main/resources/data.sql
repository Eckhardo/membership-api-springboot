-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: membership
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `admissionDate` date DEFAULT NULL,
  `admissionYear` int(11) NOT NULL,
  `city` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(30) NOT NULL,
  `isActive` bit(1) DEFAULT NULL,
  `isAdmin` bit(1) DEFAULT NULL,
  `lastName` varchar(50) NOT NULL,
  `mobil` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  `zip` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10000,'Lutterothstrasse 89',NULL,2007,'Hamburg','taerna@gmx.de','Eckhard',1,0,'Kirschning','','0160 97023201','Eckhardo',20255);
INSERT INTO `user` VALUES (10001,'Luruper Weg 4',NULL,2007,'Hamburg','maikeli.de','Maike',1,0,'Littkemann','','0160 97023201','Maikeli',20257);
INSERT INTO `user` VALUES (10002,'Marktstrasse 10',NULL,1980,'Quickborn','hauser@freenet.de','Guenther',1,0,'Hauser','','0160 11223344','Guenther',25451);
INSERT INTO `user` VALUES (10003,'Glashütter Strasse  4',NULL,2000,'Norderstedt','cp.david@gmx.de','Claus',1,0,'David','','0160 9333331','Claus',25451);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `event` (
  `id` bigint(20) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `eventName` varchar(255) NOT NULL,
  `eventShort` varchar(3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_event_short` (`eventShort`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (20000,'Forellen','Anangeln','ANA');
INSERT INTO `event` VALUES (20001,'Saiblinge','Abangeln','ABA');
INSERT INTO `event` VALUES (20002,'Arbeiten','Arbeitsdienst-1','AD1');
INSERT INTO `event` VALUES (20003,'Malochen','Arbeitsdienst-2','AD2');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `season`
--

DROP TABLE IF EXISTS `season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `season` (
  `id` bigint(20) NOT NULL,
  `isActive` bit(1) DEFAULT NULL,
  `seasonDate` date DEFAULT NULL,
  `seasonName` varchar(255) NOT NULL,
  `seasonYear` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season`
--

LOCK TABLES `season` WRITE;
/*!40000 ALTER TABLE `season` DISABLE KEYS */;
INSERT INTO `membership`.`season` (`id`, `isActive`, `seasonName`, `seasonYear`, `seasonDate` ) VALUES ('50001', 1, 'Saison 2021', 2021,null);
INSERT INTO `membership`.`season` (`id`, `isActive`, `seasonName`, `seasonYear`, `seasonDate` ) VALUES ('50002', 0, 'Saison 2022', 2022,null);

/*!40000 ALTER TABLE `season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `season_user`
--

DROP TABLE IF EXISTS `season_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `season_user` (
  `id` bigint(20) NOT NULL,
  `feesPaid` bit(1) DEFAULT NULL,
  `isActive` bit(1) DEFAULT NULL,
  `positionRole` varchar(255) DEFAULT NULL,
  `season_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_seasonuser_season` (`season_id`),
  KEY `FK_seasonuser_user` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season_user`
--

LOCK TABLES `season_user` WRITE;
/*!40000 ALTER TABLE `season_user` DISABLE KEYS */;
INSERT INTO `season_user` VALUES (8000, 1, 0,'Schriftführer',50001,10000);
INSERT INTO `season_user` VALUES (8001, 1, 0,'Kassenwart',50001,10001);
INSERT INTO `season_user` VALUES (8002, 1, 0,'1. Vorsitzender',50001,10002);
INSERT INTO `season_user` VALUES (8003, 1, 0,null ,50001,10003);
/*!40000 ALTER TABLE `season_user` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `season_event`
--

DROP TABLE IF EXISTS `season_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `season_event` (
  `id` bigint(20) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `endingDate` date DEFAULT NULL,
  `endingTime` time DEFAULT NULL,
  `finished` bit(1) DEFAULT NULL,
  `meetingPoint` varchar(255) DEFAULT NULL,
  `startingDate` date DEFAULT NULL,
  `startingTime` time DEFAULT NULL,
  `event_id` bigint(20) NOT NULL,
  `season_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKopkex7dv6veocsaty63mngv4c` (`event_id`),
  KEY `FK1noji8frqemtsavxlpppsar65` (`season_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `season_event`
--

LOCK TABLES `season_event` WRITE;
/*!40000 ALTER TABLE `season_event` DISABLE KEYS */;
INSERT INTO `season_event` VALUES (3000,'No comment','2021-06-14','12:00:00',_binary '\0',NULL,'2021-06-14','08:00:00',20000,50001);
INSERT INTO `season_event` VALUES (3001,'No comment2','2021-06-20','15:00:00',_binary '\0',NULL,'2021-06-20','08:00:00',20000,50001);
INSERT INTO `season_event` VALUES (3002,'No comment3','2021-06-27','12:00:00',_binary '\0',NULL,'2021-06-27','08:00:00',20000,50001);
INSERT INTO `season_event` VALUES (3003,'No comment4','2021-07-17','15:00:00',_binary '\0',NULL,'2021-07-17','08:00:00',20000,50001);
/*!40000 ALTER TABLE `season_event` ENABLE KEYS */;
UNLOCK TABLES;