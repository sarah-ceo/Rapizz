CREATE DATABASE  IF NOT EXISTS `rapizz` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rapizz`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: rapizz
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `administrateurs`
--

DROP TABLE IF EXISTS `administrateurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `administrateurs` (
  `idAdministrateur` int(11) NOT NULL AUTO_INCREMENT,
  `nomAdministrateur` varchar(45) NOT NULL,
  `prenomAdministrateur` varchar(45) NOT NULL,
  `loginAdministrateur` varchar(45) NOT NULL,
  `passwordAdministrateur` varchar(45) NOT NULL,
  PRIMARY KEY (`idAdministrateur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrateurs`
--

LOCK TABLES `administrateurs` WRITE;
/*!40000 ALTER TABLE `administrateurs` DISABLE KEYS */;
INSERT INTO `administrateurs` VALUES (1,'Martin','Benoît','admin','admin');
/*!40000 ALTER TABLE `administrateurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clients` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nomClient` varchar(45) NOT NULL,
  `prenomClient` varchar(45) NOT NULL,
  `adresseClient` varchar(200) NOT NULL,
  `soldeClient` float NOT NULL DEFAULT '0',
  `loginClient` varchar(45) NOT NULL,
  `passwordClient` varchar(45) NOT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Bernard','Jeanne','12 rue Andrieux 75000 Paris',4.66667,'jeanne.bernard@gmail.com','test'),(2,'Thomas','Catherine','23 rue Bayard 75000 Paris',2,'catherine.thomas@gmail.com','test'),(3,'Petit','Philippe','30 rue des Joncs',15,'philippe.petit@gmail.com','test'),(4,'Robert','Louis','3 avenue Gabriel 75000 Paris',5,'louis.robert@gmail.com','test'),(5,'Richard','Jacques','1 impasse Dany 75000 Paris',1,'jacques.richard@gmail.com','test'),(6,'Durand','Daniel','54 rue de Naples 75000 Paris',12,'daniel.durand@gmail.com','test'),(7,'Dubois','Paul','6 allée Marcel-Proust 75000 Paris',4,'paul.dubois@gmail.com','test'),(8,'Laurent','Hélène','29 rue Vernet 75000 Paris',21.3334,'helene.laurent@gmail.com','test'),(9,'Simon','Nicolas','8 rue Saint-Honoré 75000 Paris',5.33333,'nicolas.simon@gmail.com','test'),(10,'Michel','Julien','14 rue de Moscou 75000 Paris',20,'julien.michel@gmail.com','test'),(11,'Fregier','Benjamin','5 allée du Mail 75000 Paris',8.6667,'benjamin.fregier@gmail.com','test'),(12,'Moulin','Jean','3 rue des poiriers 75000 Paris',2.5,'jean.moulin@gmail.com','test'),(13,'Jonathan','Prada','7 rue des Lilas 75000 Paris',0,'jonathan.prada@gmail.com','test'),(14,'Bruno','Rouget','4 rue des Lilas 75000 Paris',5,'bruno.rouget@gmail.com','test');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commandes`
--

DROP TABLE IF EXISTS `commandes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `commandes` (
  `idCommande` int(11) NOT NULL AUTO_INCREMENT,
  `idClient` int(11) NOT NULL,
  `idLivreur` int(11) NOT NULL,
  `idVehicule` int(11) NOT NULL,
  `dateCommande` datetime NOT NULL,
  `tempsLivraison` int(11) NOT NULL DEFAULT '0',
  `bonification` enum('Retard','Fidélité') DEFAULT NULL,
  `montantCommande` float NOT NULL DEFAULT '0',
  `statutCommande` enum('En cours','Terminée') NOT NULL,
  PRIMARY KEY (`idCommande`),
  KEY `idx_commande_client` (`idClient`) /*!80000 INVISIBLE */,
  KEY `idx_commande_livreur` (`idLivreur`) /*!80000 INVISIBLE */,
  KEY `idx_commande_vehicule` (`idVehicule`),
  CONSTRAINT `fk_commande_client` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`),
  CONSTRAINT `fk_commande_livreur` FOREIGN KEY (`idLivreur`) REFERENCES `livreurs` (`idLivreur`),
  CONSTRAINT `fk_commande_vehicule` FOREIGN KEY (`idVehicule`) REFERENCES `vehicules` (`idVehicule`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commandes`
--

LOCK TABLES `commandes` WRITE;
/*!40000 ALTER TABLE `commandes` DISABLE KEYS */;
INSERT INTO `commandes` VALUES (1,1,1,1,'2019-06-16 04:45:19',49,'Retard',0,'Terminée'),(2,3,3,1,'2019-06-16 04:53:45',45,'Retard',0,'Terminée'),(3,7,5,5,'2019-06-16 05:14:03',27,NULL,16,'Terminée'),(4,6,1,5,'2019-06-16 05:19:02',19,NULL,5.66667,'Terminée'),(5,8,3,3,'2019-06-16 05:23:47',16,NULL,8.5,'Terminée'),(6,10,4,5,'2019-06-16 05:28:04',12,NULL,10,'Terminée'),(7,1,3,4,'2019-06-16 06:18:48',36,'Retard',0,'Terminée'),(8,8,3,1,'2019-06-17 20:00:57',34,'Retard',0,'Terminée'),(9,8,4,3,'2019-06-17 20:01:18',33,'Retard',0,'Terminée'),(10,8,1,5,'2019-06-17 20:01:30',34,'Retard',0,'Terminée'),(11,8,1,4,'2019-06-17 20:02:12',33,'Retard',0,'Terminée'),(12,8,5,3,'2019-06-17 20:02:20',18,NULL,11,'Terminée'),(13,8,3,4,'2019-06-17 20:02:29',32,'Retard',0,'Terminée'),(14,8,4,5,'2019-06-17 20:02:38',31,'Retard',0,'Terminée'),(15,8,5,5,'2019-06-17 20:02:50',18,NULL,11.3333,'Terminée'),(16,11,1,3,'2019-06-17 20:09:10',26,NULL,21.3333,'Terminée'),(17,6,4,4,'2019-06-17 20:14:45',19,NULL,5.33333,'Terminée'),(18,2,1,4,'2019-06-17 20:16:29',19,NULL,8,'Terminée'),(19,4,1,3,'2019-06-17 20:17:17',18,NULL,10,'Terminée'),(20,5,1,1,'2019-06-17 20:17:44',18,NULL,9,'Terminée'),(21,9,4,1,'2019-06-17 20:18:21',16,NULL,5.66667,'Terminée'),(22,1,4,1,'2019-06-17 20:18:49',15,NULL,5.33333,'Terminée'),(23,6,1,4,'2019-06-17 20:19:21',16,NULL,5,'Terminée'),(24,12,3,4,'2019-06-17 20:43:16',10,NULL,7.5,'Terminée'),(28,14,1,5,'2019-06-18 03:53:16',5,NULL,10,'Terminée'),(29,3,5,5,'2019-06-18 03:54:40',31,'Retard',0,'Terminée'),(30,8,1,3,'2019-06-18 03:55:35',3,'Fidélité',0,'Terminée');
/*!40000 ALTER TABLE `commandes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commandes_pizzas`
--

DROP TABLE IF EXISTS `commandes_pizzas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `commandes_pizzas` (
  `idCommande` int(11) NOT NULL,
  `idPizza` int(11) NOT NULL,
  `taillePizza` enum('Naine','Humaine','Ogresse') NOT NULL,
  PRIMARY KEY (`idCommande`,`idPizza`),
  KEY `idx_commande_pizza` (`idCommande`),
  KEY `idx_pizza_commande` (`idPizza`),
  CONSTRAINT `fk_commande_pizza` FOREIGN KEY (`idCommande`) REFERENCES `commandes` (`idCommande`),
  CONSTRAINT `fk_pizza_commande` FOREIGN KEY (`idPizza`) REFERENCES `pizzas` (`idPizza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commandes_pizzas`
--

LOCK TABLES `commandes_pizzas` WRITE;
/*!40000 ALTER TABLE `commandes_pizzas` DISABLE KEYS */;
INSERT INTO `commandes_pizzas` VALUES (1,3,'Naine'),(2,4,'Ogresse'),(3,1,'Humaine'),(3,6,'Humaine'),(4,3,'Naine'),(5,3,'Humaine'),(6,1,'Ogresse'),(7,8,'Humaine'),(8,3,'Humaine'),(9,3,'Ogresse'),(9,8,'Naine'),(10,8,'Ogresse'),(11,8,'Naine'),(12,3,'Naine'),(12,4,'Naine'),(13,8,'Naine'),(14,4,'Humaine'),(15,3,'Ogresse'),(16,6,'Ogresse'),(16,14,'Ogresse'),(17,5,'Naine'),(18,5,'Humaine'),(19,2,'Ogresse'),(20,7,'Humaine'),(21,6,'Naine'),(22,4,'Naine'),(23,1,'Naine'),(24,2,'Humaine'),(28,2,'Ogresse'),(29,6,'Naine'),(29,7,'Naine'),(30,1,'Naine');
/*!40000 ALTER TABLE `commandes_pizzas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ingredients` (
  `idIngredient` int(11) NOT NULL AUTO_INCREMENT,
  `nomIngredient` varchar(45) NOT NULL,
  PRIMARY KEY (`idIngredient`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (1,'Tomates'),(2,'Mozzarella'),(3,'Olives'),(4,'Jambon'),(5,'Champignons'),(6,'Crème'),(7,'Lardons'),(8,'Oignons'),(9,'Anchois'),(10,'Roquefort'),(11,'Emmental'),(12,'Chèvre'),(13,'Pommes de terre'),(14,'Reblochon'),(15,'Origan'),(16,'Chorizo'),(17,'Saumon');
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livreurs`
--

DROP TABLE IF EXISTS `livreurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `livreurs` (
  `idLivreur` int(11) NOT NULL AUTO_INCREMENT,
  `nomLivreur` varchar(45) NOT NULL,
  `prenomLivreur` varchar(45) NOT NULL,
  `loginLivreur` varchar(45) NOT NULL,
  `passwordLivreur` varchar(45) NOT NULL,
  PRIMARY KEY (`idLivreur`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livreurs`
--

LOCK TABLES `livreurs` WRITE;
/*!40000 ALTER TABLE `livreurs` DISABLE KEYS */;
INSERT INTO `livreurs` VALUES (1,'Leroy','Eric','eric.leroy@gmail.com','test'),(2,'Roux','Olivier','olivier.roux@gmail.com','test'),(3,'Bonnet','Thomas','thomas.bonnet@gmail.com','test'),(4,'Fournier','Julie','julie.fournier@gmail.com','test'),(5,'Girard','Marc','marc.girard@gmail.com','test');
/*!40000 ALTER TABLE `livreurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizzas`
--

DROP TABLE IF EXISTS `pizzas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pizzas` (
  `idPizza` int(11) NOT NULL AUTO_INCREMENT,
  `nomPizza` varchar(45) NOT NULL,
  `prixBase` float NOT NULL,
  PRIMARY KEY (`idPizza`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzas`
--

LOCK TABLES `pizzas` WRITE;
/*!40000 ALTER TABLE `pizzas` DISABLE KEYS */;
INSERT INTO `pizzas` VALUES (1,'Margarita',7.5),(2,'Reine',7.5),(3,'Carbonara',8.5),(4,'Napolitaine',8),(5,'Végétarienne',8),(6,'4 fromages',8.5),(7,'Calzone',9),(8,'Savoyarde',9),(14,'Chorizo',7.5),(15,'Saumon',8);
/*!40000 ALTER TABLE `pizzas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizzas_ingredients`
--

DROP TABLE IF EXISTS `pizzas_ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pizzas_ingredients` (
  `idPizza` int(11) NOT NULL,
  `idIngredient` int(11) NOT NULL,
  PRIMARY KEY (`idPizza`,`idIngredient`),
  KEY `idx_pizza_ingredient` (`idPizza`),
  KEY `idx_ingredient_pizza` (`idIngredient`),
  CONSTRAINT `fk_ingredient_pizza` FOREIGN KEY (`idIngredient`) REFERENCES `ingredients` (`idIngredient`),
  CONSTRAINT `fk_pizza_ingredient` FOREIGN KEY (`idPizza`) REFERENCES `pizzas` (`idPizza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzas_ingredients`
--

LOCK TABLES `pizzas_ingredients` WRITE;
/*!40000 ALTER TABLE `pizzas_ingredients` DISABLE KEYS */;
INSERT INTO `pizzas_ingredients` VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(2,3),(2,4),(2,5),(3,2),(3,3),(3,6),(3,7),(3,8),(4,1),(4,2),(4,3),(4,9),(4,15),(5,1),(5,2),(5,3),(5,5),(5,8),(5,11),(6,1),(6,2),(6,3),(6,10),(6,11),(6,12),(7,1),(7,2),(7,4),(7,5),(7,11),(8,2),(8,3),(8,6),(8,7),(8,8),(8,13),(8,14),(8,15),(14,1),(14,2),(14,3),(14,8),(14,16),(15,6),(15,8),(15,15),(15,17);
/*!40000 ALTER TABLE `pizzas_ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicules`
--

DROP TABLE IF EXISTS `vehicules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehicules` (
  `idVehicule` int(11) NOT NULL AUTO_INCREMENT,
  `typeVehicule` enum('Voiture','Moto') NOT NULL,
  `immatriculationVehicule` varchar(10) NOT NULL,
  PRIMARY KEY (`idVehicule`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicules`
--

LOCK TABLES `vehicules` WRITE;
/*!40000 ALTER TABLE `vehicules` DISABLE KEYS */;
INSERT INTO `vehicules` VALUES (1,'Voiture','RT-327-HJ'),(2,'Voiture','VF-853-MY'),(3,'Moto','NH-372-SD'),(4,'Moto','JZ-582-KJ'),(5,'Moto','YJ-245-QZ');
/*!40000 ALTER TABLE `vehicules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-18  7:34:45
