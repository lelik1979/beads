CREATE TABLE `users` (
  `user_name` VARCHAR (45) NOT NULL,
  `password` VARCHAR (45) NOT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_name`)
)
