-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2023 a las 08:51:59
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdprueba2`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscartipocambioexistente` (IN `origen` INT, IN `destino` INT)   SELECT * FROM tipocambio as t WHERE t.monedaorigen=origen and t.monedadestino=destino$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listadoGeneral` ()   SELECT t.* , '1111111' origen, m2.nombre destino,us1.nombrecompletos FROM tipocambio t 
inner join moneda m on m.id=t.monedaorigen 
inner join moneda m2 on m2.id=t.monedadestino 
inner join usuario us1 on us1.id=t.idusuario
order by t.fecharegistro asc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `LoginProcedure` (IN `p_username` VARCHAR(50), IN `p_password` VARCHAR(50))   BEGIN
    DECLARE v_count INT;
        DECLARE v_id INT;
    declare rnombreCompletos text;
    -- Verificar si las credenciales son correctas
    SELECT temp.id  INTO v_id
    FROM  usuario as temp
    WHERE temp.nombreusuario= p_username ;
    SELECT temp.nombrecompletos into rnombreCompletos
    FROM  usuario as temp
    WHERE temp.nombreusuario = p_username ; 
    SELECT COUNT(*) INTO v_count
    FROM  usuario as temp
    WHERE temp.nombreusuario= p_username AND (temp.contrasenia ) = SHA1(p_password);
     
    
    -- Devolver el resultado
    IF(v_count > 0) THEN
    
    SELECT v_id id;
    else
    
    SELECT 0 id;
    end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_login` (IN `p_username` VARCHAR(50), IN `p_password` VARCHAR(40), OUT `p_result` BOOLEAN)   BEGIN
  -- Variable para almacenar el resultado del inicio de sesión
  DECLARE v_count INT;

  -- Contar el número de registros coincidentes
  SELECT COUNT(*) INTO v_count
  FROM usuario as temp
  WHERE temp.usuario = p_username AND temp.contrasenia = SHA1(p_password);

  -- Establecer el resultado del inicio de sesión
  IF v_count = 1 THEN
    SET p_result = TRUE;
  ELSE
    SET p_result = FALSE;
  END IF;
END$$

--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `proce_login` (`p_username` VARCHAR(50), `p_password` VARCHAR(40)) RETURNS TINYINT(1)  BEGIN
  DECLARE v_result BOOLEAN;
  
  -- Realiza la lógica de validación de inicio de sesión
  SELECT COUNT(*) INTO v_result
  FROM usuarios
  WHERE usuario = p_username AND contrasenia = SHA1(p_password);
  
  RETURN v_result;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coche`
--

CREATE TABLE `coche` (
  `id` int(11) NOT NULL,
  `anyo` int(11) NOT NULL,
  `km` int(11) NOT NULL,
  `marca` varchar(255) NOT NULL,
  `modelo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moneda`
--

CREATE TABLE `moneda` (
  `nombre` varchar(100) NOT NULL,
  `id` int(11) NOT NULL,
  `simbolo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `moneda`
--

INSERT INTO `moneda` (`nombre`, `id`, `simbolo`) VALUES
('soles', 1, 'S/'),
('Dolar', 2, '$./');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipocambio`
--

CREATE TABLE `tipocambio` (
  `id` int(11) NOT NULL,
  `valor` decimal(11,2) DEFAULT NULL,
  `monedaorigen` int(11) NOT NULL,
  `monedadestino` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `fecharegistro` date NOT NULL DEFAULT current_timestamp(),
  `fechamodificacion` date NOT NULL DEFAULT current_timestamp(),
  `idusuariomodificacion` int(11) DEFAULT NULL,
  `origen` varchar(255) NOT NULL,
  `origen_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipocambio`
--

INSERT INTO `tipocambio` (`id`, `valor`, `monedaorigen`, `monedadestino`, `idusuario`, `fecharegistro`, `fechamodificacion`, `idusuariomodificacion`, `origen`, `origen_id`) VALUES
(31, 2.00, 1, 2, 1, '2023-06-15', '2023-06-16', 1, '', NULL),
(33, 12.00, 2, 2, 1, '2023-06-15', '2023-06-15', 1, '', NULL),
(34, 33.00, 1, 1, 1, '2023-06-15', '2023-06-15', 1, '', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombreusuario` varchar(100) NOT NULL,
  `contrasenia` text NOT NULL,
  `nombrecompletos` varchar(100) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombreusuario`, `contrasenia`, `nombrecompletos`, `id`) VALUES
('admin', 'D033E22AE348AEB5660FC2140AEC35850C4DA997', 'juan ramirez sanchez', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `coche`
--
ALTER TABLE `coche`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `moneda`
--
ALTER TABLE `moneda`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipocambio`
--
ALTER TABLE `tipocambio`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `monedaorigen` (`monedaorigen`,`monedadestino`),
  ADD KEY `FK_tipocambio_monedadestino` (`monedadestino`),
  ADD KEY `FKauncd6803bfgxq5x3gtovio0d` (`origen_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `moneda`
--
ALTER TABLE `moneda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipocambio`
--
ALTER TABLE `tipocambio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tipocambio`
--
ALTER TABLE `tipocambio`
  ADD CONSTRAINT `FK_tipocambio_monedadestino` FOREIGN KEY (`monedadestino`) REFERENCES `moneda` (`id`),
  ADD CONSTRAINT `FK_tipocambio_monedaorigen` FOREIGN KEY (`monedaorigen`) REFERENCES `moneda` (`id`),
  ADD CONSTRAINT `FKauncd6803bfgxq5x3gtovio0d` FOREIGN KEY (`origen_id`) REFERENCES `moneda` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
