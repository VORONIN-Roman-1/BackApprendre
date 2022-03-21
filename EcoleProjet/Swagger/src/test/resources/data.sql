--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
 id INT AUTO_INCREMENT  PRIMARY KEY,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `signature` varchar(45) DEFAULT NULL  
) ;
--
-- Data for table `message`
--

INSERT INTO `message` VALUES 
	(1,'test 01 title','Vous êtes en train de lire mon premier message de test 01','obiwan@ecole.fr'),
	(2,'bonjour test 02 title ','merci de m'' accuellir sur ce chat test 02','emma@ecole.com'),
	(3,'test 03title programme','aujourd'' hui on va coder une api avec spring boot test 03','premierdeleclasse@ecole.com'),
	(4,'absence imprévue test 04 title','désolé, je ne pourrai pas suivre la leçon aujourd'' hui. test 04 Je rattraperai très vite','bran@ecole.com'),
	(5,'test 05 title Diego','de toute façon je te donnerai mes support de cours test 05 ','diego@outlook.com'),
	(6,'test 06','test 06 content','test06@test.com');
	
