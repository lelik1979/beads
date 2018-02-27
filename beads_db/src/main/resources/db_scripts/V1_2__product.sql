CREATE TABLE `product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `group_id` INT(11) DEFAULT NULL,
  `price` DECIMAL(10,2) DEFAULT NULL,
  `description` VARCHAR(4000) DEFAULT NULL,
  `product_code` VARCHAR(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_group_id` (`group_id`),
  CONSTRAINT `fk_group_id` FOREIGN KEY (`group_id`)
  REFERENCES `product_group` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION) 

