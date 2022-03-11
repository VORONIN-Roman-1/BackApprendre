CREATE DATABASE IF NOT EXISTS `message_bdd`;
USE `message_bdd`;
--
-- Table structure for table `message`
--
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `title` varchar(50) DEFAULT NULL,
                           `content` varchar(200) DEFAULT NULL,
                           `signature` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;