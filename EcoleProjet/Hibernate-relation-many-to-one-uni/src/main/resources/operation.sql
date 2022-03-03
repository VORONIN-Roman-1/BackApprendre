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