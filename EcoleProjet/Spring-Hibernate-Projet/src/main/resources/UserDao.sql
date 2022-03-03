DROP SCHEMA IF EXISTS `bdd_spring_hibernate_projet`;
CREATE SCHEMA `bdd_spring_hibernate_projet`;
USE `bdd_spring_hibernate_projet`;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `T_user`;

-- Table structure for table `moteur`
CREATE TABLE `T_user` (
                          `id` INT NOT NULL AUTO_INCREMENT,
                          `first_name` varchar(45) DEFAULT NULL,
                          `last_name` varchar(45) DEFAULT NULL,
                          `email` varchar(45) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
-- Table structure for table `voiture`
SET FOREIGN_KEY_CHECKS = 1;