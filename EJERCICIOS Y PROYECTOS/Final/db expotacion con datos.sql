-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.32-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando datos para la tabla patulibro.autor: ~7 rows (aproximadamente)
INSERT INTO `autor` (`id_autor`, `nombre`, `apellido`, `pais`) VALUES
	(1, 'Gabriel', 'talde', 'Colombia'),
	(2, 'Mario', 'Vargas Llosa', 'Perú'),
	(3, 'Isabel', 'Allende', 'Chile'),
	(4, 'Jorge Luis', 'Borges', 'Argentina'),
	(5, 'Julio', 'Cortázar', 'Argentina'),
	(6, 'Pablo', 'Neruda', 'Chile'),
	(7, 'Octavio', 'Paz', 'México');

-- Volcando datos para la tabla patulibro.editorial: ~4 rows (aproximadamente)
INSERT INTO `editorial` (`id_editorial`, `nombre`, `email`, `telefono`) VALUES
	('10', 'Editorial ABC', 'contacto@editorialabc.com', '1234567890'),
	('20', 'Libros del Sur', 'info@librosdelsur.com', '987654321'),
	('30', 'Ediciones del Norte', 'contacto@edicionesnorte.com', '456123789');

-- Volcando datos para la tabla patulibro.libro: ~3 rows (aproximadamente)
INSERT INTO `libro` (`id_libro`, `titulo`, `isbn`, `precio`, `id_autor`, `id_editorial`) VALUES
	(1, 'Libro Ejemplo', '1234567890123', 20.99, 1, '20'),
	(2, 'jñflakjdfa', 'asdfjalkdf', 45.26, 6, '30'),
	(3, 'vida', '123123', 30.00, 1, '20'),
	(4, 'prueba nueva', '1234', 55.00, 7, '20');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
