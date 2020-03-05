-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: restaurante
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

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
-- Table structure for table `restaurente`
--

DROP TABLE IF EXISTS `restaurente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurente` (
  `cod_res` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `correo` varchar(90) DEFAULT NULL,
  `cp` int(11) NOT NULL,
  `direccion` varchar(2000) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_res`),
  UNIQUE KEY `UK_4ticis2h91lben80q24oab5yf` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurente`
--

LOCK TABLES `restaurente` WRITE;
/*!40000 ALTER TABLE `restaurente` DISABLE KEYS */;
INSERT INTO `restaurente` VALUES (1,'sevilla','aa','mnlmlr18@gmail.com',41006,'sevilla','España');
/*!40000 ALTER TABLE `restaurente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `cod_cat` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(2000) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_cat`),
  UNIQUE KEY `UK_35t4wyxqrevf09uwx9e9p6o75` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Bebidas con alcohol','Bebidas con'),(2,'Bebidas sin alcochol','Bebidas sin'),(3,'Carne','Carne');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `cod_ped` int(11) NOT NULL AUTO_INCREMENT,
  `enviado` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `cod_res` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_ped`),
  KEY `FK4eghr8c9hmpwsxxncyytowsmq` (`cod_res`),
  CONSTRAINT `FK4eghr8c9hmpwsxxncyytowsmq` FOREIGN KEY (`cod_res`) REFERENCES `restaurente` (`cod_res`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (2,0,'3910-11-10',1),(3,0,'3910-11-10',1),(4,0,'2020-03-05',1),(5,0,'2020-03-05',1),(6,0,'2020-03-05',1),(7,0,'2020-03-05',1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `cod_prod` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(90) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `cod_cat_cod_cat` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_prod`),
  KEY `FK6rqng85pq6l4bakvd6w1fw456` (`cod_cat_cod_cat`),
  CONSTRAINT `FK4gjokfm572vflecq5qcodqwwb` FOREIGN KEY (`cod_prod`) REFERENCES `categoria` (`cod_cat`),
  CONSTRAINT `FK6rqng85pq6l4bakvd6w1fw456` FOREIGN KEY (`cod_cat_cod_cat`) REFERENCES `categoria` (`cod_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Vino','Vino Tinto',1,500,1),(2,'Refresco','Refresco',1,100,2),(3,'Pack Cerveza','Cerveza',0.5,50,1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `pedido_producto`
--

DROP TABLE IF EXISTS `pedido_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido_producto` (
  `cod_ped_prod` int(11) NOT NULL AUTO_INCREMENT,
  `unidades` int(11) DEFAULT NULL,
  `cod_ped` int(11) DEFAULT NULL,
  `cod_producto` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_ped_prod`),
  KEY `FK62itaqq37bkvnrnkk9gsl3m7w` (`cod_ped`),
  KEY `FK6nlsa4y41147lqgn33vhtvi17` (`cod_producto`),
  CONSTRAINT `FK62itaqq37bkvnrnkk9gsl3m7w` FOREIGN KEY (`cod_ped`) REFERENCES `pedido` (`cod_ped`),
  CONSTRAINT `FK6nlsa4y41147lqgn33vhtvi17` FOREIGN KEY (`cod_producto`) REFERENCES `producto` (`cod_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_producto`
--

LOCK TABLES `pedido_producto` WRITE;
/*!40000 ALTER TABLE `pedido_producto` DISABLE KEYS */;
INSERT INTO `pedido_producto` VALUES (1,18,2,1),(2,0,NULL,NULL),(3,0,NULL,NULL),(4,0,NULL,NULL),(5,0,NULL,NULL),(6,0,NULL,NULL),(7,3,4,1),(8,5,4,2),(9,3,5,1),(10,3,5,3),(11,3,6,1),(12,3,6,3),(13,4,7,1);
/*!40000 ALTER TABLE `pedido_producto` ENABLE KEYS */;
UNLOCK TABLES;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-05 12:55:41
