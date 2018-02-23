CREATE TABLE `product_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `comment` VARCHAR(4000) NOT NULL,
  `disadvantages` VARCHAR(400) NULL DEFAULT NULL,
  `advantage` VARCHAR(400) NULL DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` ENUM('VISIBLE', 'INVISIBLE') NOT NULL DEFAULT 'INVISIBLE',
  `rating` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `index_product_id` (`product_id` ASC),
  CONSTRAINT `fk_product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`ID`)
    ON DELETE CASCADE
 )
