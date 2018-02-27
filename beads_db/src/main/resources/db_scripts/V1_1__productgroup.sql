CREATE TABLE `product_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prd_grp_id` (`parent_id`),
  CONSTRAINT `fk_prd_grp_id` FOREIGN KEY (`parent_id`) REFERENCES `productgroup` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)

