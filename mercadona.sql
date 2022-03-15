-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-03-2022 a las 15:57:06
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mercadona`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `precio` decimal(5,2) NOT NULL,
  `seccion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `precio`, `seccion`) VALUES
(1, 'Leche Desnatada', '1.10', 'Lacteos'),
(2, 'Hummus', '1.15', 'Alimentacion'),
(3, 'Wakame Congelado', '1.65', 'Alimentacion'),
(4, 'Queso Cheddar Curado', '2.70', 'Alimentacion'),
(5, 'Yogur Griego Natural', '2.50', 'Lacteos'),
(6, 'Aguacate', '0.30', 'Frutas y Verduras'),
(7, 'Desodorante Invisible', '1.10', 'Perfumeria y Cosmetica'),
(8, 'Gel Ducha Avena', '1.17', 'Perfumeria y Cosmetica'),
(9, 'Hamburguesa Vacuno', '3.60', 'Carniceria'),
(10, 'Hamburguesa Vacuno', '3.60', 'Carniceria'),
(11, 'Pan de Espelta', '0.90', 'Panaderia'),
(12, 'Pan Aceite de Oliva', '1.10', 'Alimentacion'),
(13, 'Nutella', '2.65', 'Alimentacion');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
