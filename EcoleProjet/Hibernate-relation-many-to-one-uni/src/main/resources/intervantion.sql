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