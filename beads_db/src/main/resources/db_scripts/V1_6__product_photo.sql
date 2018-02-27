CREATE TABLE `product_photo` (
  `product_id` INT(11) NOT NULL,
  `photo` LONGBLOB,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
)
