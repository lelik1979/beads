CREATE TABLE `order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `details` LONGTEXT,
  `status` VARCHAR(10) NOT NULL DEFAULT 'PENDING',
  `phone_number` VARCHAR(15) DEFAULT NULL,
  `modified_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delivery_address` VARCHAR(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
