-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: inmocorp
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
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `acceso` (
  `idacceso` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  PRIMARY KEY (`idacceso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
INSERT INTO `acceso` VALUES (1,'alanglez','contraseña0'),(2,'kevinJH','contraseña1'),(3,'victornino','contraseña2'),(4,'miguelQu','contraseña3');
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cita` (
  `idcita` int(11) NOT NULL,
  `hora` varchar(5) DEFAULT NULL,
  `fecha` date NOT NULL,
  `cliente_pot` varchar(45) NOT NULL,
  `idempleado` int(11) NOT NULL,
  `idinmueble` int(11) NOT NULL,
  PRIMARY KEY (`idcita`),
  KEY `fk_cita_empleado` (`idempleado`),
  KEY `fk_cita_inmueble1` (`idinmueble`),
  CONSTRAINT `fk_cita_empleado` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`),
  CONSTRAINT `fk_cita_inmueble1` FOREIGN KEY (`idinmueble`) REFERENCES `inmueble` (`idinmueble`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ciudad` (
  `idciudad` int(11) NOT NULL,
  `ciudad` varchar(40) NOT NULL,
  PRIMARY KEY (`idciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Xalapa Enríquez'),(2,'Boca del Río'),(3,'Orizaba'),(4,'Perote'),(5,'Córdoba'),(6,'Coatzacoalcos'),(7,'Agua Dulce');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `paterno` varchar(20) NOT NULL,
  `materno` varchar(20) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `calle` varchar(100) DEFAULT NULL,
  `colonia` varchar(25) DEFAULT NULL,
  `codigo_postal` varchar(5) DEFAULT NULL,
  `rfc` varchar(15) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `idacceso` int(11) NOT NULL,
  `correo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `fk_cliente_acceso1` (`idacceso`),
  CONSTRAINT `fk_cliente_acceso1` FOREIGN KEY (`idacceso`) REFERENCES `acceso` (`idacceso`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Alan','Gonzalez','Heredia','2282265548','Del museo','Centro','91010','CUPU800825569','Vendedor',1,'alanglez@gmail.com'),(2,'Kevin Misael','Juarez','Hernandez','2283789456',NULL,NULL,NULL,'MIJH900523378','Comprador',2,'kevinmis@hotmail.com'),(3,'Jose Miguel','Quiroz','Herrera','2284647894','Lazaro Cárdenas, Perote, Ver., México','Revolucion','90502','JMJH800623428','Vendedor',4,'quiroz@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descripcion`
--

DROP TABLE IF EXISTS `descripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `descripcion` (
  `antiguedad` varchar(20) DEFAULT NULL,
  `banios` int(11) DEFAULT NULL,
  `recamaras` int(11) DEFAULT NULL,
  `area_terreno` varchar(20) DEFAULT NULL,
  `area_construccion` varchar(20) DEFAULT NULL,
  `idinmueble` int(11) NOT NULL,
  KEY `fk_descripcion_inmueble1` (`idinmueble`),
  CONSTRAINT `fk_descripcion_inmueble1` FOREIGN KEY (`idinmueble`) REFERENCES `inmueble` (`idinmueble`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descripcion`
--

LOCK TABLES `descripcion` WRITE;
/*!40000 ALTER TABLE `descripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `descripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `paterno` varchar(20) NOT NULL,
  `marterno` varchar(20) DEFAULT NULL,
  `puesto` varchar(20) DEFAULT NULL,
  `salario` float DEFAULT NULL,
  `idacceso` int(11) NOT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `fk_empleado_acceso1` (`idacceso`),
  CONSTRAINT `fk_empleado_acceso1` FOREIGN KEY (`idacceso`) REFERENCES `acceso` (`idacceso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotos`
--

DROP TABLE IF EXISTS `fotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fotos` (
  `idfoto` int(11) NOT NULL AUTO_INCREMENT,
  `ruta` varchar(100) DEFAULT NULL,
  `idinmueble` int(11) NOT NULL,
  PRIMARY KEY (`idfoto`),
  KEY `fk_fotos_inmueble1` (`idinmueble`),
  CONSTRAINT `fk_fotos_inmueble1` FOREIGN KEY (`idinmueble`) REFERENCES `inmueble` (`idinmueble`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotos`
--

LOCK TABLES `fotos` WRITE;
/*!40000 ALTER TABLE `fotos` DISABLE KEYS */;
INSERT INTO `fotos` VALUES (1,'departamentoIM001.jpg',2),(2,'departamentoIM001 (2).jpg',2),(3,'IM002casa_alberca.jpg',3),(4,'IM002Casilla.jpg',3),(5,'que-es-bien-inmueble.jpg',4),(6,'IM003(2).jpg',4);
/*!40000 ALTER TABLE `fotos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inmueble` (
  `idinmueble` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(5) DEFAULT NULL,
  `direccion` varchar(200) NOT NULL,
  `disponible` tinyint(4) DEFAULT NULL,
  `notas` varchar(500) DEFAULT NULL,
  `colonia` varchar(20) NOT NULL,
  `tipo_operacion` varchar(11) DEFAULT NULL,
  `precio_venta` float DEFAULT NULL,
  `precio_renta` float DEFAULT NULL,
  `idtipo_inmueble` int(11) NOT NULL,
  `idciudad` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  PRIMARY KEY (`idinmueble`),
  KEY `fk_inmueble_tipo_inmueble1` (`idtipo_inmueble`),
  KEY `fk_inmueble_ciudad1` (`idciudad`),
  KEY `fk_inmueble_cliente1` (`idcliente`),
  CONSTRAINT `fk_inmueble_ciudad1` FOREIGN KEY (`idciudad`) REFERENCES `ciudad` (`idciudad`),
  CONSTRAINT `fk_inmueble_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `fk_inmueble_tipo_inmueble1` FOREIGN KEY (`idtipo_inmueble`) REFERENCES `tipo_inmueble` (`idtipo_inmueble`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmueble`
--

LOCK TABLES `inmueble` WRITE;
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
INSERT INTO `inmueble` VALUES (2,'IM001','El Olmo, Xalapa Enríquez, Ver., México',1,'Departamento en renta en la Col. El Olmo, a un paso de Plaza Américas','El Olmo','Renta',0,5150,1,1,1),(3,'IM002','Monte Magno, Residencial Monte Magno, Zona Ánimas',1,'3 recámaras en segunda planta. Recámara principal con baño completo, clóset y balcón','Ánimas','Venta',2000000,0,2,1,1),(4,'IM003','Briones, La Pitaya, Coatepec, Ver., México',1,'Agradable departamento amueblado ubicado en Briones, carretera \nantigua Xalapa-Coatepec, muy cerca del colegio las Hayas, lugar ideal \npera descansar y disfrutar del bosque, el departamento cuenta con: Estacionamiento, \nuna habitación, baño completo, área de cocina con estufa, refrigerador, horno de microondas, \nincluye utensilios de cocina como sartenes, platos, vasos etc. Incluye ademas los servicios de luz, agua, gas e internet.','La Pitaya','Renta',0,3200,1,4,3);
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `inmueble_detalles`
--

DROP TABLE IF EXISTS `inmueble_detalles`;
/*!50001 DROP VIEW IF EXISTS `inmueble_detalles`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `inmueble_detalles` AS SELECT 
 1 AS `idinmueble`,
 1 AS `idcliente`,
 1 AS `idtipo_inmueble`,
 1 AS `idciudad`,
 1 AS `codigo_inmueble`,
 1 AS `direccion_inmueble`,
 1 AS `disponible`,
 1 AS `notas`,
 1 AS `colonia_inmueble`,
 1 AS `tipo_operacion`,
 1 AS `precio_venta`,
 1 AS `precio_renta`,
 1 AS `ciudad_inmueble`,
 1 AS `tipo_inmueble`,
 1 AS `nombre_cliente`,
 1 AS `paterno_cliente`,
 1 AS `materno_cliente`,
 1 AS `telefono_cliente`,
 1 AS `calle_cliente`,
 1 AS `colonia_cliente`,
 1 AS `codigo_postal_cliente`,
 1 AS `rfc_cliente`,
 1 AS `tipo_cliente`,
 1 AS `idacceso_cliente`,
 1 AS `correo_cliente`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `renta`
--

DROP TABLE IF EXISTS `renta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `renta` (
  `idrenta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` varchar(10) NOT NULL,
  `fecha_fin` varchar(10) NOT NULL,
  `deposito` double DEFAULT NULL,
  `monto` double NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idinmueble` int(11) NOT NULL,
  PRIMARY KEY (`idrenta`),
  UNIQUE KEY `idinmueble_UNIQUE` (`idinmueble`),
  UNIQUE KEY `idrenta_UNIQUE` (`idrenta`),
  KEY `fk_renta_cliente1` (`idcliente`),
  CONSTRAINT `fk_renta_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `fk_renta_inmueble1` FOREIGN KEY (`idinmueble`) REFERENCES `inmueble` (`idinmueble`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renta`
--

LOCK TABLES `renta` WRITE;
/*!40000 ALTER TABLE `renta` DISABLE KEYS */;
/*!40000 ALTER TABLE `renta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_inmueble`
--

DROP TABLE IF EXISTS `tipo_inmueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_inmueble` (
  `idtipo_inmueble` int(11) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  PRIMARY KEY (`idtipo_inmueble`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_inmueble`
--

LOCK TABLES `tipo_inmueble` WRITE;
/*!40000 ALTER TABLE `tipo_inmueble` DISABLE KEYS */;
INSERT INTO `tipo_inmueble` VALUES (1,'Departamento'),(2,'Casa'),(3,'Terreno'),(4,'Edificio'),(5,'Local Comercial'),(6,'Oficina'),(7,'Todos');
/*!40000 ALTER TABLE `tipo_inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `venta` (
  `idventa` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_venta` varchar(11) NOT NULL,
  `monto` double NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idinmueble` int(11) NOT NULL,
  PRIMARY KEY (`idventa`),
  UNIQUE KEY `idventa_UNIQUE` (`idventa`),
  UNIQUE KEY `idinmueble_UNIQUE` (`idinmueble`),
  KEY `fk_venta_cliente1` (`idcliente`),
  CONSTRAINT `fk_venta_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `fk_venta_inmueble1` FOREIGN KEY (`idinmueble`) REFERENCES `inmueble` (`idinmueble`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `inmueble_detalles`
--

/*!50001 DROP VIEW IF EXISTS `inmueble_detalles`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `inmueble_detalles` AS select `i`.`idinmueble` AS `idinmueble`,`i`.`idcliente` AS `idcliente`,`i`.`idtipo_inmueble` AS `idtipo_inmueble`,`i`.`idciudad` AS `idciudad`,`i`.`codigo` AS `codigo_inmueble`,`i`.`direccion` AS `direccion_inmueble`,`i`.`disponible` AS `disponible`,`i`.`notas` AS `notas`,`i`.`colonia` AS `colonia_inmueble`,`i`.`tipo_operacion` AS `tipo_operacion`,`i`.`precio_venta` AS `precio_venta`,`i`.`precio_renta` AS `precio_renta`,`c`.`ciudad` AS `ciudad_inmueble`,`t`.`tipo` AS `tipo_inmueble`,`p`.`nombre` AS `nombre_cliente`,`p`.`paterno` AS `paterno_cliente`,`p`.`materno` AS `materno_cliente`,`p`.`telefono` AS `telefono_cliente`,`p`.`calle` AS `calle_cliente`,`p`.`colonia` AS `colonia_cliente`,`p`.`codigo_postal` AS `codigo_postal_cliente`,`p`.`rfc` AS `rfc_cliente`,`p`.`tipo` AS `tipo_cliente`,`p`.`idacceso` AS `idacceso_cliente`,`p`.`correo` AS `correo_cliente` from (((`inmueble` `i` join `ciudad` `c` on((`i`.`idciudad` = `c`.`idciudad`))) join `tipo_inmueble` `t` on((`i`.`idtipo_inmueble` = `t`.`idtipo_inmueble`))) join `cliente` `p` on((`i`.`idcliente` = `p`.`idcliente`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-07  8:17:44
