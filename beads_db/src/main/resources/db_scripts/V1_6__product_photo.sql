CREATE TABLE `product_photo` (
  `product_id` int(11) NOT NULL,
  `photo` longblob,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `id` FOREIGN KEY (`product_id`) REFERENCES `product` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8
