CREATE DATABASE IF NOT EXISTS `bdd_hibernate_demo`;
USE `bdd_hibernate_demo`;
--
-- Table structure for table `voiture`
--
DROP TABLE IF EXISTS `voiture`;
CREATE TABLE `voiture` (
                           `id` INT NOT NULL AUTO_INCREMENT,
                           `modele_name` varchar(45) DEFAULT NULL,
                           `immatriculation` varchar(10) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;