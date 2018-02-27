CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `group_id` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `product_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_group_id` (`group_id`),
  CONSTRAINT `fk_group_id` FOREIGN KEY (`group_id`)
  REFERENCES `product_group` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION) 

