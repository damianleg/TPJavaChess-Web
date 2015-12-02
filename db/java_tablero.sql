CREATE DATABASE  IF NOT EXISTS `java` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `java`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: java
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `tablero`
--

DROP TABLE IF EXISTS `tablero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tablero` (
  `nrojuego` int(11) NOT NULL,
  `nropieza` int(11) NOT NULL,
  `color` int(11) NOT NULL,
  `columna` int(11) NOT NULL,
  `fila` int(11) NOT NULL,
  KEY `nrojuego_idx` (`nrojuego`),
  CONSTRAINT `nrojuego` FOREIGN KEY (`nrojuego`) REFERENCES `juego` (`nrojuego`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablero`
--

LOCK TABLES `tablero` WRITE;
/*!40000 ALTER TABLE `tablero` DISABLE KEYS */;
INSERT INTO `tablero` VALUES (2,1,0,5,1),(2,2,0,4,1),(2,3,0,1,8),(2,3,0,8,1),(2,4,0,3,1),(2,4,0,6,1),(2,5,0,2,1),(2,5,0,7,1),(2,6,0,1,2),(2,6,0,2,2),(2,6,0,3,2),(2,6,0,4,2),(2,6,0,5,2),(2,6,0,6,2),(2,6,0,7,2),(2,6,0,8,2),(2,1,1,4,8),(2,2,1,5,8),(2,3,1,8,8),(2,4,1,3,8),(2,4,1,6,8),(2,5,1,2,8),(2,5,1,7,8),(2,6,1,1,7),(2,6,1,2,7),(2,6,1,3,7),(2,6,1,4,7),(2,6,1,5,7),(2,6,1,6,7),(2,6,1,7,7),(2,6,1,8,7),(3,1,0,5,1),(3,2,0,4,1),(3,3,0,1,8),(3,3,0,8,1),(3,4,0,3,1),(3,4,0,6,1),(3,5,0,2,1),(3,5,0,7,1),(3,6,0,1,2),(3,6,0,2,2),(3,6,0,3,2),(3,6,0,4,2),(3,6,0,5,2),(3,6,0,6,2),(3,6,0,7,2),(3,6,0,8,2),(3,1,1,4,8),(3,2,1,5,8),(3,3,1,8,8),(3,4,1,3,8),(3,4,1,6,8),(3,5,1,2,8),(3,5,1,7,8),(3,6,1,1,7),(3,6,1,2,7),(3,6,1,3,7),(3,6,1,4,7),(3,6,1,5,7),(3,6,1,6,7),(3,6,1,7,7),(3,6,1,8,7),(4,1,0,5,1),(4,2,0,4,1),(4,3,0,1,1),(4,3,0,8,1),(4,4,0,3,1),(4,4,0,6,1),(4,5,0,2,1),(4,5,0,7,1),(4,6,0,1,2),(4,6,0,2,2),(4,6,0,3,2),(4,6,0,4,2),(4,6,0,5,2),(4,6,0,6,2),(4,6,0,7,2),(4,6,0,8,2),(4,1,1,4,8),(4,2,1,5,8),(4,3,1,1,8),(4,3,1,8,8),(4,4,1,3,8),(4,4,1,6,8),(4,5,1,2,8),(4,5,1,7,8),(4,6,1,1,7),(4,6,1,2,7),(4,6,1,3,7),(4,6,1,4,7),(4,6,1,5,7),(4,6,1,6,7),(4,6,1,7,7),(4,6,1,8,7);
/*!40000 ALTER TABLE `tablero` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-15 18:46:27
