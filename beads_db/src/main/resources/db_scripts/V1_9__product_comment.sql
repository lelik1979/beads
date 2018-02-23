CREATE TABLE `product_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `comment` VARCHAR(4000) NULL DEFAULT NULL,
  `disadvantages` VARCHAR(400) NULL DEFAULT NULL,
  `dignity` VARCHAR(400) NULL DEFAULT NULL,
  `create_date` TIMESTAMP NULL DEFAULT 'CURRENT_TIMESTAMP',
  `status` ENUM('VISIBLE', 'INVISIBLE') NULL DEFAULT 'INVISIBLE',
  `rating` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `index_product_comment` (`product_id` ASC),
  CONSTRAINT `fk_product_comment`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)