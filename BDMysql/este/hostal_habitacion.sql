-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hostal
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitacion` (
  `codHabitacion` int NOT NULL,
  `valor` int NOT NULL,
  `estado` varchar(45) NOT NULL,
  `chek_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `tipoAlojamiento` varchar(45) NOT NULL,
  `rutPas` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`codHabitacion`),
  KEY `fk_PASAJERO_idx` (`rutPas`),
  CONSTRAINT `fk_PASAJERO` FOREIGN KEY (`rutPas`) REFERENCES `pasajero` (`rutPas`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
INSERT INTO `habitacion` VALUES (1,8000,'Ocupada','2021-02-01','2021-03-01','Habitacion simple','200822110'),(4,12333,'Disponible','1970-01-01','1970-01-01','Habitacion Doble',NULL),(5,16000,'Disponible','1970-01-01','1970-01-01','Habitacion doble',NULL),(6,12000,'Disponible','1970-01-01','1970-01-01','Habitacion doble',NULL),(7,12333,'Disponible','1970-01-01','1970-01-01','Habitacion Doble',NULL),(8,20000,'Disponible','1970-01-01','1970-01-01','Habitacion Doble',NULL);
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-30 23:07:31
