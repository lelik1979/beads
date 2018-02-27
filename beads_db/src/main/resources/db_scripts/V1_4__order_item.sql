CREATE TABLE `order_item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `product_id` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
)
