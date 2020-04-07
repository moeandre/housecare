-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: housecare
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `housecare`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `housecare` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `housecare`;

--
-- Table structure for table `anotacao`
--

DROP TABLE IF EXISTS `anotacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anotacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_empresa` int NOT NULL,
  `id_usuario` int NOT NULL,
  `texto` text NOT NULL,
  `criacao` datetime NOT NULL,
  `alteracao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`id_cliente`,`id_empresa`,`id_usuario`),
  KEY `fk_anotacao_cliente1_idx` (`id_cliente`,`id_empresa`),
  KEY `fk_anotacao_usuario1_idx` (`id_usuario`),
  FULLTEXT KEY `FT_ANOTACAO_TEXTO` (`texto`),
  CONSTRAINT `fk_anotacao_cliente1` FOREIGN KEY (`id_cliente`, `id_empresa`) REFERENCES `cliente` (`id`, `id_empresa`),
  CONSTRAINT `fk_anotacao_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anotacao`
--

LOCK TABLES `anotacao` WRITE;
/*!40000 ALTER TABLE `anotacao` DISABLE KEYS */;
INSERT INTO `anotacao` VALUES (1,1,1,1,'teste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\nteste 1\n','2020-03-31 00:00:00','2020-04-03 13:56:21'),(2,1,1,1,'teste 314','1970-01-19 05:27:57','1970-01-19 05:27:57'),(3,1,1,1,'teste','2020-04-03 12:35:24',NULL),(4,1,1,1,'teste teste teste teste','2020-04-03 12:35:39','2020-04-03 12:43:36'),(5,2,1,1,'teste','2020-04-04 18:50:47','2020-04-04 18:50:38'),(6,1,1,1,'','1970-01-19 05:37:47','1970-01-19 05:37:47'),(7,1,1,1,'','1970-01-19 05:37:47','1970-01-19 05:37:47');
/*!40000 ALTER TABLE `anotacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atributo_papel`
--

DROP TABLE IF EXISTS `atributo_papel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atributo_papel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_papel` int NOT NULL,
  `nome` varchar(60) NOT NULL,
  `mascara` varchar(45) DEFAULT NULL,
  `validacao` varchar(45) DEFAULT NULL,
  `criacao` datetime NOT NULL,
  PRIMARY KEY (`id`,`id_papel`),
  KEY `fk_atributos_papel_papel1_idx` (`id_papel`),
  CONSTRAINT `fk_atributos_papel_papel1` FOREIGN KEY (`id_papel`) REFERENCES `papel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributo_papel`
--

LOCK TABLES `atributo_papel` WRITE;
/*!40000 ALTER TABLE `atributo_papel` DISABLE KEYS */;
/*!40000 ALTER TABLE `atributo_papel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atributo_usuario`
--

DROP TABLE IF EXISTS `atributo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atributo_usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_papel` int NOT NULL,
  `id_empresa` int NOT NULL,
  `id_usuario` int NOT NULL,
  `nome` varchar(60) NOT NULL,
  `valor` varchar(100) NOT NULL,
  `criacao` datetime NOT NULL,
  `alteracao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`id_papel`,`id_empresa`,`id_usuario`),
  KEY `fk_atributo_usuario_papel_empresa_usuario1_idx` (`id_papel`,`id_empresa`,`id_usuario`),
  CONSTRAINT `fk_atributo_usuario_papel_empresa_usuario1` FOREIGN KEY (`id_papel`, `id_empresa`, `id_usuario`) REFERENCES `papel_empresa_usuario` (`id_papel`, `id_empresa`, `id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributo_usuario`
--

LOCK TABLES `atributo_usuario` WRITE;
/*!40000 ALTER TABLE `atributo_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `atributo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoria`
--

DROP TABLE IF EXISTS `auditoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoria` (
  `id` int NOT NULL,
  `tabela` varchar(100) NOT NULL,
  `classe` varchar(100) NOT NULL,
  `valor` text NOT NULL,
  `data` datetime NOT NULL,
  `usuario` text NOT NULL,
  PRIMARY KEY (`id`),
  FULLTEXT KEY `FT_AUDITORIA_VALOR` (`valor`),
  FULLTEXT KEY `FT_AUDITORIA_USUARIO` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria`
--

LOCK TABLES `auditoria` WRITE;
/*!40000 ALTER TABLE `auditoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `auditoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caixa`
--

DROP TABLE IF EXISTS `caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caixa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_empresa` int NOT NULL,
  `valor` decimal(10,2) NOT NULL DEFAULT '0.00',
  `criacao` datetime DEFAULT NULL,
  `alteracao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`id_cliente`,`id_empresa`),
  KEY `fk_caixa_cliente1_idx` (`id_cliente`,`id_empresa`),
  CONSTRAINT `fk_caixa_cliente1` FOREIGN KEY (`id_cliente`, `id_empresa`) REFERENCES `cliente` (`id`, `id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caixa`
--

LOCK TABLES `caixa` WRITE;
/*!40000 ALTER TABLE `caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_empresa` int NOT NULL,
  `nome` varchar(75) NOT NULL,
  `sobrenome` varchar(75) NOT NULL,
  `apelido` varchar(75) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `nascimento` datetime NOT NULL,
  `nacionalidade` varchar(75) NOT NULL,
  `naturalidade` varchar(75) DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  `alteracao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`id_empresa`),
  UNIQUE KEY `UK_CLINTE_CPF` (`cpf`),
  KEY `fk_cliente_empresa1_idx` (`id_empresa`),
  CONSTRAINT `fk_cliente_empresa1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,1,'Cliente 1','Sobrenome Cliente 1','Cliente 1','1','2020-03-26 00:00:00','Brasileiro',NULL,NULL,'2020-04-04 18:44:50'),(2,1,'Cliente 2','Sobrenome Cliente 2','Cliente 2','2','2020-03-26 00:00:00','Brasileiro',NULL,'2020-03-26 00:00:00','2020-04-02 11:15:49'),(3,1,'Cliente 3','Sobrenome Cliente 3','Cliente 3','3','2020-03-26 00:00:00','Brasileiro',NULL,'2020-03-26 00:00:00','2020-04-02 11:16:26'),(4,1,'Cliente 4','Sobrenome Cliente 4','Cliente 4','4','2020-03-26 00:00:00','Brasileiro',NULL,'2020-03-26 00:00:00','2020-04-02 11:16:48'),(5,1,'Cliente 5','Sobrenome Cliente 5','Cliente 5','5','2020-03-26 00:00:00','Brasileiro',NULL,'2020-03-26 00:00:00','2020-04-02 11:17:31'),(7,1,'Cliente 7','Sobrenome Cliente 7','Cliente 7','7','2020-03-26 00:00:00','Brasileiro',NULL,'1970-01-19 05:26:42','2020-04-02 11:18:06'),(8,1,'Cliente 136','Sobrenome','Cliente 119','492','2020-03-26 00:00:00','Brasileiro',NULL,'1970-01-19 05:26:42','1970-01-19 05:26:42'),(9,1,'Cliente Novo','Supernovo','SuperCliente','9','2020-04-02 21:17:00','Brasileiro','São Paulo','2020-04-01 21:17:30','2020-04-02 11:15:33'),(10,1,'Cliente 513','Sobrenome','Cliente 273','300','2020-03-26 00:00:00','Brasileiro',NULL,'1970-01-19 05:36:36','1970-01-19 05:36:36'),(11,1,'Cliente 930','','Cliente 518','744','2020-03-26 00:00:00','Brasileiro',NULL,'1970-01-19 05:36:36','1970-01-19 05:36:36');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cobranca`
--

DROP TABLE IF EXISTS `cobranca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cobranca` (
  `id` int NOT NULL AUTO_INCREMENT,
  `valor` decimal(15,2) NOT NULL,
  `data` datetime NOT NULL,
  `vencimento` datetime NOT NULL,
  `pagamento` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cobranca`
--

LOCK TABLES `cobranca` WRITE;
/*!40000 ALTER TABLE `cobranca` DISABLE KEYS */;
INSERT INTO `cobranca` VALUES (1,1.00,'2020-04-01 00:00:00','2020-04-15 00:00:00',NULL);
/*!40000 ALTER TABLE `cobranca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuracao`
--

DROP TABLE IF EXISTS `configuracao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `configuracao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_empresa` int NOT NULL,
  `quartos` int DEFAULT NULL,
  PRIMARY KEY (`id`,`id_empresa`),
  KEY `fk_configuracao_empresa1_idx` (`id_empresa`),
  CONSTRAINT `fk_configuracao_empresa1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuracao`
--

LOCK TABLES `configuracao` WRITE;
/*!40000 ALTER TABLE `configuracao` DISABLE KEYS */;
/*!40000 ALTER TABLE `configuracao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `razao_social` varchar(100) NOT NULL,
  `nome_fantasia` varchar(100) DEFAULT NULL,
  `cnpj` varchar(18) NOT NULL,
  `dominio` varchar(100) DEFAULT NULL,
  `telefone` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `situacao` varchar(2) NOT NULL DEFAULT 'A',
  `criacao` datetime DEFAULT NULL,
  `atualizacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_CNPJ_EMPRESA` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'Casa Vita','Casa Vita','123','casavita.com.br','1','a@a.com','A','2020-03-27 00:00:00','2020-03-27 00:00:00');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familiar`
--

DROP TABLE IF EXISTS `familiar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `familiar` (
  `id_familiar` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_empresa` int NOT NULL,
  `nome` varchar(100) NOT NULL,
  `parentesco` varchar(100) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `email` varchar(75) DEFAULT NULL,
  `ultimo_contato` datetime DEFAULT NULL,
  `responsavel` tinyint(1) DEFAULT NULL,
  `criacao` datetime NOT NULL,
  `alteracao` datetime DEFAULT NULL,
  PRIMARY KEY (`id_familiar`,`id_cliente`,`id_empresa`),
  KEY `fk_familiar_cliente1_idx` (`id_cliente`,`id_empresa`),
  CONSTRAINT `fk_familiar_cliente1` FOREIGN KEY (`id_cliente`, `id_empresa`) REFERENCES `cliente` (`id`, `id_empresa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familiar`
--

LOCK TABLES `familiar` WRITE;
/*!40000 ALTER TABLE `familiar` DISABLE KEYS */;
INSERT INTO `familiar` VALUES (1,1,1,'Aline Dias','filhos','11111111111','','1970-01-19 05:28:23',0,'2020-03-31 00:00:00','2020-04-07 15:58:39'),(2,1,1,'Familiar 518','filhos','766','a@a.com','1970-01-19 05:28:23',0,'1970-01-19 05:28:23','2020-04-07 13:37:16'),(3,2,1,'André Mauricio Garcia','filhos','11981262993','andre.moe@gmail.com',NULL,1,'2020-04-04 18:15:40','2020-04-07 14:50:56'),(5,1,1,'Familiar 922','filhos','401','a@a.com','1970-01-19 05:37:49',0,'1970-01-19 05:37:49','2020-04-07 13:37:24');
/*!40000 ALTER TABLE `familiar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fatura`
--

DROP TABLE IF EXISTS `fatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fatura` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cobranca` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cobranca_has_lancamento_cobranca1_idx` (`id_cobranca`),
  CONSTRAINT `fk_cobranca_has_lancamento_cobranca1` FOREIGN KEY (`id_cobranca`) REFERENCES `cobranca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fatura`
--

LOCK TABLES `fatura` WRITE;
/*!40000 ALTER TABLE `fatura` DISABLE KEYS */;
INSERT INTO `fatura` VALUES (1,1);
/*!40000 ALTER TABLE `fatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_empresa` int NOT NULL,
  `id_usuario` int NOT NULL,
  `responsavel` tinyint(1) NOT NULL,
  `situacao` varchar(1) NOT NULL,
  PRIMARY KEY (`id_empresa`,`id_usuario`),
  KEY `fk_empresa_has_usuario_usuario1_idx` (`id_usuario`),
  KEY `fk_empresa_has_usuario_empresa1_idx` (`id_empresa`),
  CONSTRAINT `fk_empresa_has_usuario_empresa1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`),
  CONSTRAINT `fk_empresa_has_usuario_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,1,1,'A'),(1,5,1,'I'),(1,6,1,'A');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_empresa` int NOT NULL,
  `id_medicamento` int DEFAULT NULL,
  `nome` varchar(75) NOT NULL,
  `descricao` text,
  `quantidade` int NOT NULL DEFAULT '1',
  `valor` decimal(10,2) NOT NULL DEFAULT '0.00',
  `medicamento` tinyint(1) NOT NULL COMMENT 'Indicador de medicamento',
  `cobranca` tinyint(1) NOT NULL COMMENT 'Indicador de cobrança\nT = Gera ''lancamento''',
  `criacao` datetime NOT NULL,
  `alteracao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`id_cliente`,`id_empresa`),
  KEY `fk_inventario_cliente1_idx` (`id_cliente`,`id_empresa`),
  CONSTRAINT `fk_inventario_cliente1` FOREIGN KEY (`id_cliente`, `id_empresa`) REFERENCES `cliente` (`id`, `id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lancamento`
--

DROP TABLE IF EXISTS `lancamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lancamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_empresa` int NOT NULL,
  `id_fatura` int DEFAULT NULL,
  `nome` varchar(75) NOT NULL,
  `valor` decimal(10,2) NOT NULL DEFAULT '0.00',
  `criacao` datetime NOT NULL,
  PRIMARY KEY (`id`,`id_cliente`,`id_empresa`),
  KEY `fk_lancamento_cliente1_idx` (`id_cliente`,`id_empresa`),
  KEY `fk_lancamento_fatura1_idx` (`id_fatura`),
  CONSTRAINT `fk_lancamento_cliente1` FOREIGN KEY (`id_cliente`, `id_empresa`) REFERENCES `cliente` (`id`, `id_empresa`),
  CONSTRAINT `fk_lancamento_fatura1` FOREIGN KEY (`id_fatura`) REFERENCES `fatura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lancamento`
--

LOCK TABLES `lancamento` WRITE;
/*!40000 ALTER TABLE `lancamento` DISABLE KEYS */;
INSERT INTO `lancamento` VALUES (1,1,1,1,'Lançamento 1',550.00,'1970-01-19 05:28:24'),(2,1,1,NULL,'Lancamento 2',450.00,'1970-01-19 05:28:24'),(4,3,1,NULL,'Lançamento 1',500.00,'2020-04-02 19:49:16');
/*!40000 ALTER TABLE `lancamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leito`
--

DROP TABLE IF EXISTS `leito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leito` (
  `id` int NOT NULL,
  `id_quarto` int NOT NULL,
  `numero` varchar(45) NOT NULL,
  `situacao` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id`,`id_quarto`),
  KEY `fk_leito_quarto1_idx` (`id_quarto`),
  CONSTRAINT `fk_leito_quarto1` FOREIGN KEY (`id_quarto`) REFERENCES `quarto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leito`
--

LOCK TABLES `leito` WRITE;
/*!40000 ALTER TABLE `leito` DISABLE KEYS */;
/*!40000 ALTER TABLE `leito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lotacao`
--

DROP TABLE IF EXISTS `lotacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lotacao` (
  `id_leito` int NOT NULL AUTO_INCREMENT,
  `id_quarto` int NOT NULL,
  `id_cliente` int NOT NULL,
  `id_empresa` int NOT NULL,
  `entrada` datetime NOT NULL,
  `saida` datetime DEFAULT NULL,
  PRIMARY KEY (`id_leito`,`id_quarto`,`id_cliente`,`id_empresa`),
  KEY `fk_leito_has_cliente_cliente1_idx` (`id_cliente`,`id_empresa`),
  KEY `fk_leito_has_cliente_leito1_idx` (`id_leito`,`id_quarto`),
  CONSTRAINT `fk_leito_has_cliente_cliente1` FOREIGN KEY (`id_cliente`, `id_empresa`) REFERENCES `cliente` (`id`, `id_empresa`),
  CONSTRAINT `fk_leito_has_cliente_leito1` FOREIGN KEY (`id_leito`, `id_quarto`) REFERENCES `leito` (`id`, `id_quarto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lotacao`
--

LOCK TABLES `lotacao` WRITE;
/*!40000 ALTER TABLE `lotacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `lotacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papel`
--

DROP TABLE IF EXISTS `papel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `papel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(70) DEFAULT NULL,
  `unico` tinyint(1) DEFAULT NULL,
  `criacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papel`
--

LOCK TABLES `papel` WRITE;
/*!40000 ALTER TABLE `papel` DISABLE KEYS */;
/*!40000 ALTER TABLE `papel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papel_empresa`
--

DROP TABLE IF EXISTS `papel_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `papel_empresa` (
  `id_papel` int NOT NULL,
  `id_empresa` int NOT NULL,
  `situacao` varchar(1) NOT NULL DEFAULT 'A',
  `data` datetime NOT NULL,
  PRIMARY KEY (`id_papel`,`id_empresa`),
  KEY `fk_papel_has_empresa_empresa1_idx` (`id_empresa`),
  KEY `fk_papel_has_empresa_papel1_idx` (`id_papel`),
  CONSTRAINT `fk_papel_has_empresa_empresa1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`),
  CONSTRAINT `fk_papel_has_empresa_papel1` FOREIGN KEY (`id_papel`) REFERENCES `papel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papel_empresa`
--

LOCK TABLES `papel_empresa` WRITE;
/*!40000 ALTER TABLE `papel_empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `papel_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papel_empresa_usuario`
--

DROP TABLE IF EXISTS `papel_empresa_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `papel_empresa_usuario` (
  `id_papel` int NOT NULL,
  `id_empresa` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_papel`,`id_empresa`,`id_usuario`),
  KEY `fk_papel_empresa_has_usuario_usuario1_idx` (`id_usuario`),
  KEY `fk_papel_empresa_has_usuario_papel_empresa1_idx` (`id_papel`,`id_empresa`),
  CONSTRAINT `fk_papel_empresa_has_usuario_papel_empresa1` FOREIGN KEY (`id_papel`, `id_empresa`) REFERENCES `papel_empresa` (`id_papel`, `id_empresa`),
  CONSTRAINT `fk_papel_empresa_has_usuario_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papel_empresa_usuario`
--

LOCK TABLES `papel_empresa_usuario` WRITE;
/*!40000 ALTER TABLE `papel_empresa_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `papel_empresa_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parametro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `valor` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quarto`
--

DROP TABLE IF EXISTS `quarto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quarto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_empresa` int NOT NULL,
  `numero` varchar(3) NOT NULL,
  `lotacao` int NOT NULL DEFAULT '1',
  `situacao` varchar(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id`,`id_empresa`),
  KEY `fk_quarto_empresa1_idx` (`id_empresa`),
  CONSTRAINT `fk_quarto_empresa1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quarto`
--

LOCK TABLES `quarto` WRITE;
/*!40000 ALTER TABLE `quarto` DISABLE KEYS */;
/*!40000 ALTER TABLE `quarto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_empresa` int NOT NULL,
  `nome` varchar(75) NOT NULL,
  `descricao` text NOT NULL,
  `valor` decimal(10,2) NOT NULL DEFAULT '0.00',
  `criacao` datetime NOT NULL,
  `alteracao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`id_cliente`,`id_empresa`),
  KEY `fk_servico_cliente1_idx` (`id_cliente`,`id_empresa`),
  CONSTRAINT `fk_servico_cliente1` FOREIGN KEY (`id_cliente`, `id_empresa`) REFERENCES `cliente` (`id`, `id_empresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessao`
--

DROP TABLE IF EXISTS `sessao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sessao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `uuid` varchar(45) NOT NULL,
  `expiracao` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sessao_usuario1_idx` (`id_usuario`),
  CONSTRAINT `fk_sessao_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessao`
--

LOCK TABLES `sessao` WRITE;
/*!40000 ALTER TABLE `sessao` DISABLE KEYS */;
INSERT INTO `sessao` VALUES (30,1,'df96a1cf-3a9f-4daf-8b16-09cdfddd3aae','2020-04-13 13:32:17');
/*!40000 ALTER TABLE `sessao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `login` varchar(14) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `criacao` datetime NOT NULL,
  `alteracao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Andre','andre.moe','698dc19d489c4e4db73e28a713eab07b','andre.moe@gmail.com','1','2020-03-27 00:00:00','2020-03-27 00:00:00'),(5,'Aline Dias','smileckp','698dc19d489c4e4db73e28a713eab07b','smileckp@gmail.com','11985078009','2020-04-05 15:17:00','2020-04-06 00:14:21'),(6,'Luis','luis@luis.com','698dc19d489c4e4db73e28a713eab07b','luis@luis.com','1','2020-04-06 00:19:53','2020-04-06 00:19:55');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-07 17:35:54
