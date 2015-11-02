/*
Navicat MySQL Data Transfer

Source Server         : localhsot
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : 0007_emagricola

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2015-10-29 02:51:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `anuncios`
-- ----------------------------
DROP TABLE IF EXISTS `anuncios`;
CREATE TABLE `anuncios` (
  `id_anuncio` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  `titulo` varchar(225) DEFAULT NULL,
  `descripcion` text,
  `precio` decimal(10,3) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `cp` varchar(5) DEFAULT NULL,
  `localidad` varchar(100) DEFAULT NULL,
  `provincia_id` int(11) NOT NULL,
  `vendedor_tipo_id` int(11) DEFAULT NULL,
  `horario_llamada_id` int(11) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `modelo` varchar(100) DEFAULT NULL,
  `num_vistos` int(11) NOT NULL DEFAULT '0',
  `num_envios_emal` int(11) NOT NULL DEFAULT '0',
  `fecha_publicacion` datetime DEFAULT NULL,
  `fecha_caducidad` datetime DEFAULT NULL,
  `anuncio_estado_id` int(11) NOT NULL DEFAULT '1',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `empresa_nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_anuncio`),
  KEY `fk_anuncios_provincias1_idx` (`provincia_id`) USING BTREE,
  KEY `fk_anuncios_horarios_llamadas1_idx` (`horario_llamada_id`) USING BTREE,
  KEY `fk_anuncios_vendedores_tipos1_idx` (`vendedor_tipo_id`) USING BTREE,
  KEY `fk_anuncios_categorias1_idx` (`categoria_id`) USING BTREE,
  KEY `fk_anuncios_usuarios1_idx` (`usuario_id`) USING BTREE,
  KEY `fk_anuncios_anuncios_estados1_idx` (`anuncio_estado_id`) USING BTREE,
  CONSTRAINT `anuncios_ibfk_1` FOREIGN KEY (`anuncio_estado_id`) REFERENCES `anuncios_estados` (`id_anuncio_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `anuncios_ibfk_2` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `anuncios_ibfk_3` FOREIGN KEY (`horario_llamada_id`) REFERENCES `horarios_llamadas` (`id_horario_llamada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `anuncios_ibfk_4` FOREIGN KEY (`provincia_id`) REFERENCES `provincias` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `anuncios_ibfk_5` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `anuncios_ibfk_6` FOREIGN KEY (`vendedor_tipo_id`) REFERENCES `vendedores_tipos` (`id_vendedor_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anuncios
-- ----------------------------
INSERT INTO `anuncios` VALUES ('2', '2', '20', 'Vendo NEW HOLLAND - TL 90 A', 'Vendo tractor de 90 cv, doble tracción, cabina original, inversor mecánico, freno de remolque, 40 km/h. TDF hidráulica, de 540, 750, 1000 rpm y proporcional al avance. ITV al dia, precio IVA incluido y transferido.', '20000.000', 'juan@aaa.es', null, '45860', 'Villacañas', '45', '1', '1', 'NEW HOLLAND', 'TL 90 A', '100', '6', '2015-04-14 14:12:41', '2015-12-31 14:05:50', '1', '2015-03-31 14:12:45', null, null);
INSERT INTO `anuncios` VALUES ('3', '3', '31', 'Vendo maquina de vendimiar.', 'Mape maquinaria sl. . (empresa registrada)vende maquinas de vendimiar de las marcas gregoire, alma, pellenc, domine, new holland etc, arrastradas y autopropulsadas, precio desde 8000 hasta 70000 mil euros negociables, disponemos de mas de 20 maquinas en nuestro propio taller, damos garantia, asistencia y las matriculamos, tambien tenemos rulos, tractores, atomizadores, prepodadoras, azufradoras etc. mas info. por telefono', '20566.000', 'pedro@aaaa.es', '65555555', '44585', 'Socuellamos', '44', '1', '4', 'GREGOIRE', 'TlA 255', '450', '4', '2015-03-31 14:18:11', '2015-12-31 14:05:50', '1', '2015-03-31 14:18:15', null, null);
INSERT INTO `anuncios` VALUES ('4', '4', '40', 'Vendo sembradora', 'Se vende sembradora sola de cereal i hierba y etc tiene 280 de trabajo con rastra trasera se entrega revisada y con garantia alguna duda llamar enganche rápido y solfatadora de 800 litros negociable', '450.000', 'pablo@aa.es', '915555555', '28665', 'Madrid', '28', '2', '2', 'SOLA', '280', '251', '7', '2015-03-31 14:22:22', '2015-07-31 14:05:50', '1', '2015-03-31 14:22:26', null, null);
INSERT INTO `anuncios` VALUES ('5', '2', '20', 'Vendo tractor seminuevo', 'Por cese actividad vendo lote: deutz 135 cv con 4150 horas+pala león 2 cazos+puas, arado cohecho 10cuerpos ballesta, culti-chisel 17brazos+rastra y rodillo, sembradora+presiembra horizonte 3, 5 mts ancho-cajon 750kg simiente, 3cubas para cereal/olivar suspendida 600lit, arrastre de 500 y 1000lit.', '53000.000', 'juan@aaa.es', '6565665', '45860', 'Villacañas', '45', '1', '2', 'DEUTZ', 'AGROTRON 135', '25895', '9', '2015-03-31 14:26:54', '2015-08-31 14:05:50', '1', '2015-03-31 14:27:04', null, null);
INSERT INTO `anuncios` VALUES ('9', '6', '20', 'Landini Frutero REX. Buen estado.', 'Tractor frutero de 90 CV con cabina original con AIRE ACONDICIONADO, tracción con tecla, ruedas seminuevas, muy cuidado, 6. 500 horas, muy suave de dirección, frenos, vehículo muy completo, 40 km hora, documentación e ITV hasta 2016.\n\non la serie 200 Vario VFP, Fendt pretende trasladar la tecnología, asumida en los tractores grandes a los tractores especialistas. Estos tractores combinan la máxima comodidad de la marca con una eficacia óptima. La serie de fruteros y viñedos de Fendt representa el primer tractor especialista con transmisión continua. Esta transmisión fue diseñada específicamente para este tipo de tractores eliminando por completo el molesto tunel de transmisión, dejando un gran espacio para el movimiento de las piernas. Una transmisión Vario que consigue la maxima eficacia de trabajo con un consumo optimo. Hasta un 10% mas de rendimiento por superficie gracias a una adaptación Óptima de la velocidad de trabajo.\nCon sus poderosos motores Agco Sisu Power de inyección por common rail garantizan la máxima rentabilidad y el má¡ximo ahorro de combustible, y ello en tractores desde 70 hasta 110 CV.\n\n', '16900.000', 'carlos@gmail.com', '91 5585 855', '50070', 'Zaragoza', '50', '1', '1', 'LANDINI', 'FRUTERO REX 90 D. T.', '0', '0', '2015-04-28 01:17:33', '2015-07-28 00:00:00', '1', '2015-04-28 01:17:33', null, null);
INSERT INTO `anuncios` VALUES ('11', '6', '61', 'TOPOS O SUBSOLADOR - 3 BRAZOS Y 5 BRAZOS', 'Se fabrican subsoladores de 3 y 5 puas para todo tipo tractores con regulacion de altura con rulo o sin rulo los brazos se fabrican con chapa oxicortada apartir de 30 mm o4omm se le pueden poner puas de acero o fundas de diente desde 120 de ancho a 280 tambien tractors pequeños o articulados disponemos de nuevos ocasion segunda mano y alquiler.', '3500.000', 'carlos@gmail.com', '687 69 69 98', '28004', 'Albacete', '2', '1', '4', 'Artesanal', null, '0', '0', '2015-04-28 01:54:52', '2015-07-28 00:00:00', '1', '2015-04-28 01:54:52', null, null);
INSERT INTO `anuncios` VALUES ('12', '5', '41', 'Vendeo sembradora Jolpa', 'Se vende sembradora de cereal marca jolpa de 3 metros de 19 botas con rastra de puas nuevas y enganche rapido en buen estado.\r\n\r\nEsta en perfecto estado.', '350.000', 'vugarrio@gmail.com', '658 58 69 69', '45870', 'Lillo', '45', '1', '1', 'Jolpa', null, '0', '0', '2015-04-28 02:16:43', '2015-07-28 00:00:00', '1', '2015-04-28 02:16:43', null, null);
INSERT INTO `anuncios` VALUES ('13', '7', '50', 'Vendo remolque en perfecto estado', 'Dispone de ruedas jockey  que facilita el transporte del remolque, tanto con carga como sin ella. Estabiliza y soporta el peso de la carga y del remolque, así puedes arrastrar el remolque tú mismo sin grandes esfuerzos.\n\nGana más altura (hasta 45 cm) en el remolque con una tapa de poliester. Gracias a sus cerraduras, harán de la caja del remolque un compartimiento cerrado.\n\nLleva a tus mascotas comodamente gracias a una altura mayor de caja.', '5500.000', 'nieves@gmail.com', '687 58 58 96', '45860', 'Villacañas', '45', '1', '3', 'Urbeni', null, '0', '0', '2015-04-28 10:35:06', '2015-07-28 00:00:00', '1', '2015-04-28 10:35:06', null, null);
INSERT INTO `anuncios` VALUES ('14', '9', '20', '6320 DE 110 CV, buen estado.', 'Recien llegado, perfecto estado de 4 cilindros y 110 cv de potencia, completamente revisado, con 5000 horas reales a toda prueba.\r\n\r\nEsta en perfecto estado.', '25000.000', 'fran@gmail.com', '698 56 89 65', '16640', 'Belmonte', '16', '1', '1', 'JOHN DEERE', '6320 DE 110 CV', '0', '0', '2015-04-28 12:52:04', '2015-07-28 00:00:00', '1', '2015-04-28 12:52:04', null, null);

-- ----------------------------
-- Table structure for `anuncios_estados`
-- ----------------------------
DROP TABLE IF EXISTS `anuncios_estados`;
CREATE TABLE `anuncios_estados` (
  `id_anuncio_estado` int(11) NOT NULL,
  `nombre_anuncio_estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_anuncio_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anuncios_estados
-- ----------------------------
INSERT INTO `anuncios_estados` VALUES ('0', 'Pendiente de validación');
INSERT INTO `anuncios_estados` VALUES ('1', 'Activo');
INSERT INTO `anuncios_estados` VALUES ('2', 'Caducado');
INSERT INTO `anuncios_estados` VALUES ('3', 'Baja');

-- ----------------------------
-- Table structure for `anuncios_imagenes`
-- ----------------------------
DROP TABLE IF EXISTS `anuncios_imagenes`;
CREATE TABLE `anuncios_imagenes` (
  `id_anuncio_imagen` int(11) NOT NULL AUTO_INCREMENT,
  `anuncio_id` int(11) NOT NULL,
  `url_fichero` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `es_activo` tinyint(1) NOT NULL DEFAULT '1',
  `orden` int(11) NOT NULL DEFAULT '100',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id_anuncio_imagen`),
  KEY `fk_ANUNCIOS_IMAGS_ANUNC1` (`anuncio_id`) USING BTREE,
  CONSTRAINT `anuncios_imagenes_ibfk_1` FOREIGN KEY (`anuncio_id`) REFERENCES `anuncios` (`id_anuncio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anuncios_imagenes
-- ----------------------------
INSERT INTO `anuncios_imagenes` VALUES ('1', '9', 'ficheros/anuncios/an9_1_158449107_1.jpg', 'Imagen 1', '1', '10', '2015-04-28 01:17:33', null);
INSERT INTO `anuncios_imagenes` VALUES ('2', '9', 'ficheros/anuncios/an9_2_158449107_2.jpg', 'Imagen 2', '1', '20', '2015-04-28 01:17:33', null);
INSERT INTO `anuncios_imagenes` VALUES ('3', '9', 'ficheros/anuncios/an9_3_158449107_4.jpg', 'Imagen 3', '1', '30', '2015-04-28 01:17:33', null);
INSERT INTO `anuncios_imagenes` VALUES ('4', '9', 'ficheros/anuncios/an9_4_158449107_3.jpg', 'Imagen 4', '1', '40', '2015-04-28 01:17:33', null);
INSERT INTO `anuncios_imagenes` VALUES ('5', '9', 'ficheros/anuncios/an9_5_158449107_6.jpg', 'Imagen 5', '1', '50', '2015-04-28 01:17:33', null);
INSERT INTO `anuncios_imagenes` VALUES ('6', '9', 'ficheros/anuncios/an9_6_158449107_9.jpg', 'Imagen 6', '1', '60', '2015-04-28 01:17:33', null);
INSERT INTO `anuncios_imagenes` VALUES ('7', '11', 'ficheros/anuncios/an11_1_topos.jpg', 'Imagen 1', '1', '10', '2015-04-28 01:54:52', null);
INSERT INTO `anuncios_imagenes` VALUES ('8', '2', 'ficheros/anuncios/38399594_1.jpg', 'Imagen 1', '1', '10', '2015-04-28 01:58:08', null);
INSERT INTO `anuncios_imagenes` VALUES ('9', '5', 'ficheros/anuncios/3076.jpg', 'Imagen 1', '1', '100', '2015-04-28 02:03:34', null);
INSERT INTO `anuncios_imagenes` VALUES ('10', '3', 'ficheros/anuncios/Maquina-de-vendimiar-braud-136247259_4.jpg', 'Imagen 1', '1', '10', '2015-04-28 02:07:00', null);
INSERT INTO `anuncios_imagenes` VALUES ('11', '12', 'ficheros/anuncios/an12_1_sembradora_jpg.jpg', 'Imagen 1', '1', '10', '2015-04-28 02:16:43', null);
INSERT INTO `anuncios_imagenes` VALUES ('12', '13', 'ficheros/anuncios/an13_1_remolque.jpg', 'Imagen 1', '1', '10', '2015-04-28 10:35:06', null);
INSERT INTO `anuncios_imagenes` VALUES ('13', '14', 'ficheros/anuncios/an14_1_John-deere-6320.png', 'Imagen 1', '1', '10', '2015-04-28 12:52:04', null);

-- ----------------------------
-- Table structure for `anuncios_mensajes`
-- ----------------------------
DROP TABLE IF EXISTS `anuncios_mensajes`;
CREATE TABLE `anuncios_mensajes` (
  `id_anuncio_mensaje` int(11) NOT NULL AUTO_INCREMENT,
  `anuncio_id` int(11) NOT NULL,
  `titulo` varchar(150) DEFAULT NULL,
  `mensaje` text,
  `usuario_id_from` int(11) DEFAULT NULL,
  `nombre_from` varchar(100) DEFAULT NULL,
  `email_from` varchar(100) DEFAULT NULL,
  `telefono_from` varchar(20) DEFAULT NULL,
  `es_leido` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_leido` datetime DEFAULT NULL,
  `ip` varchar(45) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id_anuncio_mensaje`),
  KEY `fk_ANUNCIOS_MENS_ANUN_1` (`anuncio_id`) USING BTREE,
  CONSTRAINT `anuncios_mensajes_ibfk_1` FOREIGN KEY (`anuncio_id`) REFERENCES `anuncios` (`id_anuncio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anuncios_mensajes
-- ----------------------------
INSERT INTO `anuncios_mensajes` VALUES ('1', '5', 'Re: Vendo tractor seminuevo', 'fdsffasfdaf\r\ndsasfsdfdasf', null, null, 'afffasf@adfdafasfadsf.es', '4322', '0', null, '0:0:0:0:0:0:0:1', '2015-04-24 12:55:21', null);
INSERT INTO `anuncios_mensajes` VALUES ('2', '5', 'Re: Vendo tractor seminuevo', 'Hola estoy muy interesado.\r\nEspaña, acción, Lhopital', null, null, 'vugarrio@gmail.com', '688888', '0', null, '0:0:0:0:0:0:0:1', '2015-04-24 12:56:34', null);
INSERT INTO `anuncios_mensajes` VALUES ('3', '9', 'Re: Landini Frutero REX. Buen estado.', 'Estoy muy interesado.', null, null, 'vugarrio@gmail.com', null, '0', null, '0:0:0:0:0:0:0:1', '2015-04-28 12:31:27', null);
INSERT INTO `anuncios_mensajes` VALUES ('4', '12', 'Re: Vendeo sembradora Jolpa', '¿De que año es?', null, null, 'pedro@aaa.es', null, '0', null, '0:0:0:0:0:0:0:1', '2015-04-28 13:00:15', null);
INSERT INTO `anuncios_mensajes` VALUES ('5', '9', 'Re: Landini Frutero REX. Buen estado.', 'Estoy interesado', null, null, 'vicente@aaaa.es', null, '0', null, '0:0:0:0:0:0:0:1', '2015-04-29 10:11:51', null);
INSERT INTO `anuncios_mensajes` VALUES ('6', '14', 'Re: 6320 DE 110 CV, buen estado.', 'fsdafsfdf', null, 'adfafd', 'admin@admin.com', '', '0', null, '0:0:0:0:0:0:0:1', '2015-05-05 19:24:00', null);

-- ----------------------------
-- Table structure for `categorias`
-- ----------------------------
DROP TABLE IF EXISTS `categorias`;
CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `id_categoria_padre` int(11) DEFAULT NULL,
  `nombre_categoria` varchar(100) DEFAULT NULL,
  `url_imagen` varchar(255) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `es_activa` tinyint(1) NOT NULL DEFAULT '1',
  `es_ultimo_nivel` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `orden` int(11) NOT NULL DEFAULT '100',
  `nivel` int(11) DEFAULT '1',
  PRIMARY KEY (`id_categoria`),
  KEY `fk_categorias_categorias1_idx` (`id_categoria_padre`) USING BTREE,
  CONSTRAINT `categorias_ibfk_1` FOREIGN KEY (`id_categoria_padre`) REFERENCES `categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorias
-- ----------------------------
INSERT INTO `categorias` VALUES ('1', null, 'Tractores', 'images/categorias/tractor.png', null, '1', '0', '2015-03-31 13:15:51', null, '10', '1');
INSERT INTO `categorias` VALUES ('2', null, 'Cosechadoras', 'images/categorias/cosechadora.png', null, '1', '0', '2015-03-31 13:16:25', null, '20', '1');
INSERT INTO `categorias` VALUES ('3', null, 'Sembradoras', 'images/categorias/sembradora.png', null, '1', '0', '2015-03-31 13:17:27', null, '30', '1');
INSERT INTO `categorias` VALUES ('4', null, 'Remolques', 'images/categorias/remolque.png', null, '1', '0', '2015-03-31 13:18:03', null, '40', '1');
INSERT INTO `categorias` VALUES ('5', null, 'Aperos', 'images/categorias/aperos.png', null, '1', '0', '2015-03-31 13:18:24', null, '50', '1');
INSERT INTO `categorias` VALUES ('6', null, 'Almacenamiento', 'images/categorias/almacenamiento.png', null, '1', '0', '2015-03-31 13:18:38', null, '60', '1');
INSERT INTO `categorias` VALUES ('7', null, 'Empleo', 'images/categorias/trabajo.png', null, '1', '1', '2015-03-31 13:19:29', null, '70', '1');
INSERT INTO `categorias` VALUES ('8', null, 'Herramientas', 'images/categorias/herramientas.png', null, '1', '1', '2015-03-31 13:19:44', null, '80', '1');
INSERT INTO `categorias` VALUES ('20', '1', 'Tractor agricola', null, '1', '1', '1', '2015-03-31 13:20:32', null, '10', '2');
INSERT INTO `categorias` VALUES ('21', '1', 'Mini tractor', null, '1', '1', '1', '2015-03-31 13:21:04', null, '20', '2');
INSERT INTO `categorias` VALUES ('22', '1', 'Otros tractores', null, '1', '1', '1', '2015-03-31 13:21:33', null, '30', '2');
INSERT INTO `categorias` VALUES ('23', '1', 'Recambios y piezas', null, '1', '1', '1', '2015-03-31 13:22:03', null, '40', '2');
INSERT INTO `categorias` VALUES ('30', '2', 'De cereales o grano', null, '2', '1', '1', '2015-03-31 13:24:14', null, '10', '2');
INSERT INTO `categorias` VALUES ('31', '2', 'Vendimiadoras', null, '2', '1', '1', '2015-03-31 13:24:40', null, '20', '2');
INSERT INTO `categorias` VALUES ('32', '2', 'De remolacha', null, '2', '1', '1', '2015-03-31 13:25:05', null, '30', '2');
INSERT INTO `categorias` VALUES ('33', '2', 'De patata', null, '2', '1', '1', '2015-03-31 13:25:56', null, '40', '2');
INSERT INTO `categorias` VALUES ('34', '2', 'Otras cosechadoras', null, '2', '1', '1', '2015-03-31 13:26:23', null, '50', '2');
INSERT INTO `categorias` VALUES ('35', '2', 'Recambios y piezas', null, '2', '1', '1', '2015-03-31 13:26:59', null, '60', '2');
INSERT INTO `categorias` VALUES ('40', '3', 'Siembra en linea', null, '3', '1', '1', '2015-03-31 13:28:04', null, '10', '2');
INSERT INTO `categorias` VALUES ('41', '3', 'Siembra directa', null, '3', '1', '1', '2015-03-31 13:28:28', null, '20', '2');
INSERT INTO `categorias` VALUES ('42', '3', 'Monogramo de precisión', null, '3', '1', '1', '2015-03-31 13:29:11', null, '30', '2');
INSERT INTO `categorias` VALUES ('43', '3', 'Combinado de siembra', null, '3', '1', '1', '2015-03-31 13:29:38', null, '40', '2');
INSERT INTO `categorias` VALUES ('44', '3', 'Otras sembradoras', null, '3', '1', '1', '2015-03-31 13:30:09', null, '50', '2');
INSERT INTO `categorias` VALUES ('45', '3', 'Recambios y piezas', null, '3', '1', '1', '2015-03-31 13:31:04', null, '60', '2');
INSERT INTO `categorias` VALUES ('50', '4', 'Convencional', null, '4', '1', '1', '2015-03-31 13:32:30', null, '10', '2');
INSERT INTO `categorias` VALUES ('51', '4', 'De forraje', null, '4', '1', '1', '2015-03-31 13:33:02', null, '20', '2');
INSERT INTO `categorias` VALUES ('52', '4', 'Porta maquinaria', null, '4', '1', '1', '2015-03-31 13:33:25', null, '30', '2');
INSERT INTO `categorias` VALUES ('53', '4', 'De ganado', null, '4', '1', '1', '2015-03-31 13:34:17', null, '40', '2');
INSERT INTO `categorias` VALUES ('54', '4', 'Auto cagradores', null, '4', '1', '1', '2015-03-31 13:34:36', null, '50', '2');
INSERT INTO `categorias` VALUES ('55', '4', 'Otros remolques', null, '4', '1', '1', '2015-03-31 13:34:53', null, '60', '2');
INSERT INTO `categorias` VALUES ('56', '4', 'Recambios y piezas', null, '4', '1', '1', '2015-03-31 13:35:17', null, '70', '2');
INSERT INTO `categorias` VALUES ('60', '5', 'Gradas', null, '5', '1', '1', '2015-03-31 13:37:24', null, '10', '2');
INSERT INTO `categorias` VALUES ('61', '5', 'Arados', null, '5', '1', '1', '2015-03-31 13:37:39', null, '20', '2');
INSERT INTO `categorias` VALUES ('62', '5', 'Cultivadores', null, '5', '1', '1', '2015-03-31 13:37:52', null, '30', '2');
INSERT INTO `categorias` VALUES ('63', '5', 'Rastras', null, '5', '1', '1', '2015-03-31 13:38:13', null, '40', '2');
INSERT INTO `categorias` VALUES ('64', '5', 'Rulos', null, '5', '1', '1', '2015-03-31 13:38:46', null, '50', '2');
INSERT INTO `categorias` VALUES ('65', '5', 'Binadoras', null, '5', '1', '1', '2015-03-31 13:39:05', null, '60', '2');
INSERT INTO `categorias` VALUES ('66', '5', 'Trituradoras', null, '5', '1', '1', '2015-03-31 13:39:26', null, '70', '2');
INSERT INTO `categorias` VALUES ('67', '5', 'Fresadora / Trovadora', null, '5', '1', '1', '2015-03-31 13:40:00', null, '80', '2');
INSERT INTO `categorias` VALUES ('68', '5', 'Otros aperos', null, '5', '1', '1', '2015-03-31 13:40:19', null, '90', '2');
INSERT INTO `categorias` VALUES ('69', '5', 'Recambios y piezas', null, '5', '1', '1', '2015-03-31 13:40:51', null, '10', '2');
INSERT INTO `categorias` VALUES ('70', '6', 'Tornillos', null, '6', '1', '1', '2015-03-31 13:43:06', null, '20', '2');
INSERT INTO `categorias` VALUES ('71', '6', 'Tolvas', null, '6', '1', '1', '2015-03-31 13:43:27', null, '30', '2');
INSERT INTO `categorias` VALUES ('72', '6', 'Cubas y cisternas', null, '6', '1', '1', '2015-03-31 13:44:35', null, '40', '2');
INSERT INTO `categorias` VALUES ('73', '6', 'Otros almacenamientos', null, '6', '1', '1', '2015-03-31 13:44:55', null, '50', '2');

-- ----------------------------
-- Table structure for `horarios_llamadas`
-- ----------------------------
DROP TABLE IF EXISTS `horarios_llamadas`;
CREATE TABLE `horarios_llamadas` (
  `id_horario_llamada` int(11) NOT NULL,
  `descripcion` text,
  `es_activo` tinyint(1) NOT NULL DEFAULT '1',
  `orden` int(11) NOT NULL DEFAULT '100',
  PRIMARY KEY (`id_horario_llamada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of horarios_llamadas
-- ----------------------------
INSERT INTO `horarios_llamadas` VALUES ('1', 'A cualquier hora', '1', '10');
INSERT INTO `horarios_llamadas` VALUES ('2', 'En horario comercial', '1', '20');
INSERT INTO `horarios_llamadas` VALUES ('3', 'Por las mañanas', '1', '30');
INSERT INTO `horarios_llamadas` VALUES ('4', 'A la hora de comer', '1', '40');
INSERT INTO `horarios_llamadas` VALUES ('5', 'Por la tardes', '1', '50');
INSERT INTO `horarios_llamadas` VALUES ('6', 'Por la noches', '1', '60');
INSERT INTO `horarios_llamadas` VALUES ('7', 'Los fines de semana', '1', '70');

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', '1111', '37.30504402799999');
INSERT INTO `products` VALUES ('2', '22222', '180.307712802');

-- ----------------------------
-- Table structure for `provincias`
-- ----------------------------
DROP TABLE IF EXISTS `provincias`;
CREATE TABLE `provincias` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `cod_provincia` varchar(2) DEFAULT NULL,
  `nombre_provincia` varchar(50) DEFAULT NULL,
  `id_ccaa` int(11) DEFAULT NULL,
  `es_activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of provincias
-- ----------------------------
INSERT INTO `provincias` VALUES ('1', '01', 'Alava', '13', '1');
INSERT INTO `provincias` VALUES ('2', '02', 'Albacete', '8', '1');
INSERT INTO `provincias` VALUES ('3', '03', 'Alicante', '22', '1');
INSERT INTO `provincias` VALUES ('4', '04', 'Almería', '2', '1');
INSERT INTO `provincias` VALUES ('5', '05', 'Avila', '10', '1');
INSERT INTO `provincias` VALUES ('6', '06', 'Badajoz', '14', '1');
INSERT INTO `provincias` VALUES ('7', '07', 'Baleares', '5', '1');
INSERT INTO `provincias` VALUES ('8', '08', 'Barcelona', '11', '1');
INSERT INTO `provincias` VALUES ('9', '09', 'Burgos', '10', '1');
INSERT INTO `provincias` VALUES ('10', '10', 'Cáceres', '14', '1');
INSERT INTO `provincias` VALUES ('11', '11', 'Cádiz', '2', '1');
INSERT INTO `provincias` VALUES ('12', '12', 'Castellón', '22', '1');
INSERT INTO `provincias` VALUES ('13', '13', 'Ciudad Real', '8', '1');
INSERT INTO `provincias` VALUES ('14', '14', 'Córdoba', '2', '1');
INSERT INTO `provincias` VALUES ('15', '15', 'A Coruña', '15', '1');
INSERT INTO `provincias` VALUES ('16', '16', 'Cuenca', '8', '1');
INSERT INTO `provincias` VALUES ('17', '17', 'Gerona', '11', '1');
INSERT INTO `provincias` VALUES ('18', '18', 'Granada', '2', '1');
INSERT INTO `provincias` VALUES ('19', '19', 'Guadalajara', '8', '1');
INSERT INTO `provincias` VALUES ('20', '20', 'Guipuzkoa', '13', '1');
INSERT INTO `provincias` VALUES ('21', '21', 'Huelva', '2', '1');
INSERT INTO `provincias` VALUES ('22', '22', 'Huesca', '3', '1');
INSERT INTO `provincias` VALUES ('23', '23', 'Jaén', '2', '1');
INSERT INTO `provincias` VALUES ('24', '24', 'León', '10', '1');
INSERT INTO `provincias` VALUES ('25', '25', 'Lleida', '11', '1');
INSERT INTO `provincias` VALUES ('26', '26', 'La Rioja', '21', '1');
INSERT INTO `provincias` VALUES ('27', '27', 'Lugo', '15', '1');
INSERT INTO `provincias` VALUES ('28', '28', 'Madrid', '16', '1');
INSERT INTO `provincias` VALUES ('29', '29', 'Málaga', '2', '1');
INSERT INTO `provincias` VALUES ('30', '30', 'Murcia', '19', '1');
INSERT INTO `provincias` VALUES ('31', '31', 'Navarra', '20', '1');
INSERT INTO `provincias` VALUES ('32', '32', 'Ourense', '15', '1');
INSERT INTO `provincias` VALUES ('33', '33', 'Asturias', '4', '1');
INSERT INTO `provincias` VALUES ('34', '34', 'Palencia', '10', '1');
INSERT INTO `provincias` VALUES ('35', '35', 'Las Palmas', '6', '1');
INSERT INTO `provincias` VALUES ('36', '36', 'Pontevedra', '15', '1');
INSERT INTO `provincias` VALUES ('37', '37', 'Salamanca', '10', '1');
INSERT INTO `provincias` VALUES ('38', '38', 'Santa Cruz de Tenerife', '6', '1');
INSERT INTO `provincias` VALUES ('39', '39', 'Cantabria', '7', '1');
INSERT INTO `provincias` VALUES ('40', '40', 'Segovia', '10', '1');
INSERT INTO `provincias` VALUES ('41', '41', 'Sevilla', '2', '1');
INSERT INTO `provincias` VALUES ('42', '42', 'Soria', '10', '1');
INSERT INTO `provincias` VALUES ('43', '43', 'Tarragona', '11', '1');
INSERT INTO `provincias` VALUES ('44', '44', 'Teruel', '3', '1');
INSERT INTO `provincias` VALUES ('45', '45', 'Toledo', '8', '1');
INSERT INTO `provincias` VALUES ('46', '46', 'Valencia', '22', '1');
INSERT INTO `provincias` VALUES ('47', '47', 'Valladolid', '10', '1');
INSERT INTO `provincias` VALUES ('48', '48', 'Vizcaya', '13', '1');
INSERT INTO `provincias` VALUES ('49', '49', 'Zamora', '10', '1');
INSERT INTO `provincias` VALUES ('50', '50', 'Zaragoza', '3', '1');
INSERT INTO `provincias` VALUES ('51', '51', 'Ceuta', '12', '1');
INSERT INTO `provincias` VALUES ('52', '4', '34-TRIAL-Melilla 100', '17', '1');

-- ----------------------------
-- Table structure for `usuarios`
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `usuario_estado_id` int(11) NOT NULL DEFAULT '0',
  `last_ip` varchar(45) DEFAULT NULL,
  `last_logged_in` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `confirmacion_code` varchar(20) DEFAULT NULL,
  `url_foto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuarios_usuarios_estados1_idx` (`usuario_estado_id`) USING BTREE,
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`usuario_estado_id`) REFERENCES `usuarios_estados` (`id_usuario_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES ('1', 'Usambu', 'usambru@gmail.com', '1111', '678787878', '1', null, null, '2015-03-31 13:47:55', null, null, null);
INSERT INTO `usuarios` VALUES ('2', 'Juan', 'juan@aaa.es', '9632', '788999988', '1', null, null, '2015-03-31 13:48:28', null, null, null);
INSERT INTO `usuarios` VALUES ('3', 'Pedro', 'pedro@aaaa.es', '3333', '69999999', '1', null, null, '2015-03-31 13:49:03', null, null, null);
INSERT INTO `usuarios` VALUES ('4', 'Pablo', 'pablo@aaa.es', '4444', '65858585', '1', null, null, '2015-03-31 13:52:21', null, null, null);
INSERT INTO `usuarios` VALUES ('5', 'Vicente', 'vugarrio@gmail.com', 'test', '678 71 67 59', '1', null, null, '2015-04-25 12:46:47', null, null, 'images/usuarios/tente_100.jpg');
INSERT INTO `usuarios` VALUES ('6', 'Carlos', 'carlos@gmail.com', '78963', null, '1', null, null, '2015-04-28 00:24:47', null, null, null);
INSERT INTO `usuarios` VALUES ('7', 'Nieves', 'nieves@gmail.com', 'nieves', null, '1', null, null, '2015-04-28 10:28:44', null, null, null);
INSERT INTO `usuarios` VALUES ('8', 'Juan', 'juan@gmail.com', 'juan', null, '1', null, null, '2015-04-28 11:49:33', null, null, null);
INSERT INTO `usuarios` VALUES ('9', 'Francisco', 'fran@gmail.com', 'fran', null, '1', null, null, '2015-04-28 12:45:17', null, null, null);

-- ----------------------------
-- Table structure for `usuarios_estados`
-- ----------------------------
DROP TABLE IF EXISTS `usuarios_estados`;
CREATE TABLE `usuarios_estados` (
  `id_usuario_estado` int(11) NOT NULL,
  `nombre_usuario_estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_usuario_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usuarios_estados
-- ----------------------------
INSERT INTO `usuarios_estados` VALUES ('0', 'Desactivo');
INSERT INTO `usuarios_estados` VALUES ('1', 'Activo');
INSERT INTO `usuarios_estados` VALUES ('2', 'Pendiente doble opt-in');
INSERT INTO `usuarios_estados` VALUES ('3', 'Baja por el usuario');

-- ----------------------------
-- Table structure for `vendedores_tipos`
-- ----------------------------
DROP TABLE IF EXISTS `vendedores_tipos`;
CREATE TABLE `vendedores_tipos` (
  `id_vendedor_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_vendedor_tipo` varchar(50) DEFAULT NULL,
  `es_activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_vendedor_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vendedores_tipos
-- ----------------------------
INSERT INTO `vendedores_tipos` VALUES ('1', 'Particular', '1');
INSERT INTO `vendedores_tipos` VALUES ('2', 'Profesional', '1');
