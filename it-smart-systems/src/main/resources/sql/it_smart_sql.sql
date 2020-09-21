CREATE USER 'smart'@'localhost' IDENTIFIED BY 'smart';
GRANT ALL PRIVILEGES ON * . * TO 'smart'@'localhost';
ALTER USER 'smart'@'localhost' IDENTIFIED WITH mysql_native_password BY 'smart';

CREATE DATABASE  IF NOT EXISTS `it_smart_systems`;
USE `it_smart_systems`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(20)  DEFAULT NULL ,
  `user_role` varchar(20)  DEFAULT NULL,
  `vfsso_username` varchar(20)  DEFAULT NULL,
  `vfsso_status` varchar(20)  DEFAULT NULL,
  `contact_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SELECT * from user;
truncate table user;

USE `it_smart_systems`;

DROP TABLE IF EXISTS `login_data`;
CREATE TABLE `login_data`(
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `username` varchar(20)  DEFAULT NULL,
  `last_login` varchar(30)  DEFAULT NULL,
  `last_logout` varchar(30)  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SELECT * from login_data;
truncate table login_data;
