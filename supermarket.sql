-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.33 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.2.0.6576
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for bdd_supermarket
CREATE DATABASE IF NOT EXISTS `bdd_supermarket` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdd_supermarket`;

-- Dumping structure for table bdd_supermarket.tbl_clientes
CREATE TABLE IF NOT EXISTS `tbl_clientes` (
  `cli_id` int NOT NULL AUTO_INCREMENT,
  `cli_nombre` varchar(255) DEFAULT NULL,
  `cli_apellido` varchar(255) DEFAULT NULL,
  `cli_cedula` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `cedula` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cli_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bdd_supermarket.tbl_clientes: ~3 rows (approximately)
INSERT INTO `tbl_clientes` (`cli_id`, `cli_nombre`, `cli_apellido`, `cli_cedula`, `apellido`, `cedula`, `nombre`) VALUES
	(1, 'Joel', 'Sanchez', '1004098511', NULL, NULL, NULL),
	(2, 'Marco', 'Villarreal', '23547', NULL, NULL, NULL),
	(3, 'Juan', 'Pérez', '1234567890', NULL, NULL, NULL),
	(5, 'Santiago', 'Perez', '1234567890', NULL, NULL, NULL);

-- Dumping structure for table bdd_supermarket.tbl_productos
CREATE TABLE IF NOT EXISTS `tbl_productos` (
  `prod_id` bigint NOT NULL AUTO_INCREMENT,
  `prod_nombre` varchar(255) NOT NULL,
  `prod_descripcion` varchar(255) DEFAULT NULL,
  `prod_precio` double NOT NULL,
  `prod_stock` int DEFAULT '0',
  `cli_id` int DEFAULT NULL,
  PRIMARY KEY (`prod_id`),
  KEY `cli_id` (`cli_id`),
  CONSTRAINT `FK_tbl_productos_tbl_clientes` FOREIGN KEY (`cli_id`) REFERENCES `tbl_clientes` (`cli_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table bdd_supermarket.tbl_productos: ~5 rows (approximately)
INSERT INTO `tbl_productos` (`prod_id`, `prod_nombre`, `prod_descripcion`, `prod_precio`, `prod_stock`, `cli_id`) VALUES
	(1, 'Papas', 'Papa Chola', 2, 20, 1),
	(2, 'Chocolate', 'Chocolate Jett', 1, 50, 2),
	(3, 'Agua', 'Agua Tesalia', 0.5, 10, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
