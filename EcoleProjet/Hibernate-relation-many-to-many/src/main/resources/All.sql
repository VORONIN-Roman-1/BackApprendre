DROP SCHEMA IF EXISTS `bdd_many_to_many`;
CREATE SCHEMA `bdd_many_to_many`;
USE `bdd_many_to_many`;
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
-- Table structure for table `intervention`
DROP TABLE IF EXISTS `intervention`;
CREATE TABLE `intervention` (
                                `id` INT NOT NULL AUTO_INCREMENT,
                                `dateheure` DATETIME DEFAULT NULL,
                                `prix` DECIMAL( 10, 2 ) DEFAULT NULL,
                                `titre`varchar (100) DEFAULT NULL,
                                `technicien`varchar (50) DEFAULT NULL,
                                `voiture_id` INT DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `FK_VOITURE_idx`(`voiture_id`),
                                CONSTRAINT `FK_to_voiture_id`
                                    FOREIGN KEY (`voiture_id`)
                                        REFERENCES `voiture`(`id`)
                                        ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT
    CHARSET=latin1;
-- Table structure for table `operation`
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
                             `id` INT NOT NULL AUTO_INCREMENT,
                             `libelle`varchar (255) DEFAULT NULL,
                             `categorie`varchar (50) DEFAULT NULL,
                             `securitaire`BIT(1) DEFAULT NULL,
                             `intervention_id`INT DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FK_to_intervention_idx`(`intervention_id`),
                             CONSTRAINT `FK_to_intervention_id`
                                 FOREIGN KEY (`intervention_id`) REFERENCES `intervention` (`id`)
                                     ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
-- Table structure for table `mecanicien`
DROP TABLE IF EXISTS `mecanicien`;
CREATE TABLE `mecanicien` (
                              `id` INT NOT NULL AUTO_INCREMENT,
                              `nom`varchar (100) DEFAULT NULL,
                              `prenom`varchar (100) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
-- Table structure for table `intervention_mecanicien`
DROP TABLE IF EXISTS `intervention_mecanicien`;
CREATE TABLE `intervention_mecanicien` (
                                           `intervention_id` INT NOT NULL ,
                                           `mecanicien_id` INT NOT NULL ,
                                           PRIMARY KEY (`intervention_id`,`mecanicien_id`),
                                           KEY `FK_MECANICIEN_idx` (`mecanicien_id`),
                                           CONSTRAINT `FK_INTERVENTION` FOREIGN KEY (`intervention_id`) REFERENCES `intervention`(`id`)
                                               ON DELETE NO ACTION ON UPDATE NO ACTION ,
                                           CONSTRAINT `FK_MECANICIEN` FOREIGN KEY (`mecanicien_id`) REFERENCES `mecanicien`(`id`)
                                               ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;