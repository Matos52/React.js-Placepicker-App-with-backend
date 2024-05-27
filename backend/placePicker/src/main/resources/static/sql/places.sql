CREATE DATABASE  IF NOT EXISTS `places`;
USE `places`;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;

CREATE TABLE `place` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `image` longblob NOT NULL,
  `image_alt` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lon` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

