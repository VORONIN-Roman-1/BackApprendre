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