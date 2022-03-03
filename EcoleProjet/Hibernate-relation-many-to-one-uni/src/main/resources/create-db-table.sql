DROP SCHEMA IF EXISTS `bdd_many_to_one_vrai_uni`;
CREATE SCHEMA `bdd_many_to_one_vrai_uni`;
USE `bdd_many_to_one_vrai_uni`;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `voiture`;
DROP TABLE IF EXISTS `moteur`;
-- Table structure for table `moteur`
CREATE TABLE `moteur` (
                          `id` INT NOT NULL AUTO_INCREMENT,
                          `puissance` INT DEFAULT NULL,
                          `carburant` varchar(10) DEFAULT NULL,
                          `cylindree` INT DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
-- Table structure for table `voiture`
CREATE TABLE `voiture` (
                           `id` INT NOT NULL AUTO_INCREMENT,
                           `modele` varchar(45) DEFAULT NULL,
                           `immatriculation` varchar(10) DEFAULT NULL,
                           `moteur_id` INT DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FK_moteur_idx` (`moteur_id`),
                           CONSTRAINT `FK_to_moteur_id` FOREIGN KEY (`moteur_id`)
                               REFERENCES `moteur`(`id`)
                               ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;