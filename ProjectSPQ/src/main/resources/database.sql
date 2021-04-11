-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-04-2021 a las 00:32:45
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `database`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(15) NOT NULL,
  `username` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `contrasenya` varchar(32) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellido` varchar(32) NOT NULL,
  `telefono` int(9) DEFAULT NULL,
  `direccion` varchar(32) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `foto` varchar(250) DEFAULT NULL,
  `palabraRecuperacion` varchar(32) DEFAULT NULL,
  `preguntaRecuperacion` varchar(32) DEFAULT NULL,
  `id_anuncio` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `email`, `contrasenya`, `nombre`, `apellido`, `telefono`, `direccion`, `descripcion`, `foto`, `palabraRecuperacion`, `preguntaRecuperacion`, `id_anuncio`) VALUES
(1, 'Mrfahrenheit10', 'aitor.fournier@opendeusto.es', 'animotio', 'Aitor', 'Fournier', 696254476, 'calaikans', NULL, NULL, NULL, NULL, NULL),
(3, 'aa', 'aa@gmail.com', 'aa', 'aa', 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'aaa', 'aa@.', '123', 'aa', 'aa', NULL, NULL, NULL, NULL, 'aa', '¿Nombre de tu madre?', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
