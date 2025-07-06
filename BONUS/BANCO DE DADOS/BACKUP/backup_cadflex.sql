-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cadflex
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `observacao` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (2,'Curso de Java',199.90,'digital','Educação','Curso completo com certificado'),(4,'Template HTML Responsivo',39.90,'Digital','Web','HTML/CSS/JS prontos para uso'),(7,'Madeira',10.99,'Físico','',''),(9,'Boi',123.00,'Físico','',''),(10,'God of War - PS4',90.00,'Digital','',''),(11,'Mesa',13.99,'Físico','',''),(12,'Cadeira',60.00,'Físico','',''),(13,'Taju',12.90,'Físico','',''),(14,'Xbox Gamercart',394.00,'Digital','',''),(17,'Tomate',23.50,'Físico','',''),(18,'GTA',90.00,'Digital','',''),(21,'Curso em Video',100.00,'Digital','',''),(24,'Toalha',150.00,'Físico','',''),(25,'Metal',12.00,'Físico','',''),(27,'Resident Evil 6',12.00,'Digital','',''),(28,'Mamita',12.00,'Físico','',''),(29,'The Last Of Us',109.00,'Digital','',''),(31,'Windows 10 Pro',2.00,'Digital','',''),(32,'Queijo',12.00,'Físico','',''),(33,'Vingadores Ultimato',98.00,'Digital','',''),(34,'The Last Of Us',30.00,'Digital','',''),(35,'Empada',12.00,'Físico','',''),(36,'Ta Chovendo Queijo',22.00,'Digital','','');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_digital`
--

DROP TABLE IF EXISTS `produto_digital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto_digital` (
  `id` int NOT NULL,
  `tamanho_arquivo_mb` decimal(10,2) NOT NULL,
  `formato` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `produto_digital_ibfk_1` FOREIGN KEY (`id`) REFERENCES `produto` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_digital`
--

LOCK TABLES `produto_digital` WRITE;
/*!40000 ALTER TABLE `produto_digital` DISABLE KEYS */;
INSERT INTO `produto_digital` VALUES (2,1200.00,'MP4'),(4,15.20,'Emo'),(10,0.00,'Chave Nuvem'),(14,0.00,'Digital'),(18,0.00,'Jogo Digital'),(21,0.00,'Tudo teorioco'),(27,0.00,'Midia Digital contem Bonus'),(29,0.00,'Chave Digital Virtude'),(31,0.00,'Chave OEM'),(33,0.00,'Filme Digital'),(34,0.00,'psn delux'),(36,0.00,'Filme em Formato Digital');
/*!40000 ALTER TABLE `produto_digital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_fisico`
--

DROP TABLE IF EXISTS `produto_fisico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto_fisico` (
  `id` int NOT NULL,
  `peso` decimal(10,2) NOT NULL,
  `dimensoes` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `produto_fisico_ibfk_1` FOREIGN KEY (`id`) REFERENCES `produto` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_fisico`
--

LOCK TABLES `produto_fisico` WRITE;
/*!40000 ALTER TABLE `produto_fisico` DISABLE KEYS */;
INSERT INTO `produto_fisico` VALUES (7,23.41,''),(9,444.00,''),(11,4.50,''),(12,2.60,''),(13,1.20,''),(17,1.20,''),(24,9.00,''),(25,2.50,''),(28,2.30,''),(32,4.00,''),(35,4.00,'');
/*!40000 ALTER TABLE `produto_fisico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `genero` enum('Masculino','Feminino') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Vitor','vmbraz1234@gmail.com','Vitor1234','Masculino'),(2,'Lucia','lucia@gmail.com','Lucia1234','Feminino'),(3,'Scoob','scoob@hotmail.com','Scoob123','Masculino'),(4,'Fabio','fabin@gmail.com','Matias1234','Masculino'),(5,'Vitor Silva Ribeiro','vitorsilvaribeiro@gmail.com','VitorR1234','Masculino'),(6,'Marcone','marcone@gmail.com','Marcone1234','Masculino'),(7,'Julia','julia@gmail.com','Julia1234','Feminino'),(8,'Lupid','lupid@gmail.com','Lupid1234','Feminino'),(9,'Julio','julio@gmail.com','Julio1234','Masculino'),(10,'roberta','roberta@gmail.com','Roberta1234','Feminino'),(11,'Fabrin','fabin1234@gmail.com','Fabin1234','Masculino'),(12,'Rossana Ribeiro Morais','rossana@gmail.com','Rossana1234','Feminino'),(13,'Maria','maria1234@gmail.com','Maria1234','Feminino'),(14,'felipe','felipejuliano@gmail.com','Filipe1234','Masculino'),(15,'Palmito','palmito1234@gmail.com','Palmito1234','Masculino');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-28 22:19:50
