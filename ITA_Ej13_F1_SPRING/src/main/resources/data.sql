DROP TABLE IF EXISTS `paint`;
DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NULL,
  `capacity` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
);

CREATE TABLE `paint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(250) DEFAULT 'ANONIMO',
  `name` varchar(250) NULL,
  `price` decimal(10,2) DEFAULT 0.00,
  `date_entry` date NULL,
  `shop_id` int(11) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `paint_fk` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`)
  ON DELETE CASCADE ON UPDATE CASCADE

);


insert into `shop`(name, capacity) values('Shop1', 3);
insert into `shop`(name, capacity) values('Shop2', 3);
insert into `shop`(name, capacity) values('Shop3', 3);

insert into `paint`(author, name, price, date_entry, shop_id) values('Author1', 'Paint1', 100, NOW(), 1);
insert into `paint`(author, name, price, date_entry, shop_id) values('Author2', 'Paint2', 300, NOW(), 2);
insert into `paint`(author, name, price, date_entry, shop_id) values('Author3', 'Paint3', 400, NOW(), 2);
insert into `paint`(author, name, price, date_entry, shop_id) values('Author3', 'Paint32', 500, NOW(), 3);
insert into `paint`(author, name, price, date_entry, shop_id) values('Author4', 'Paint4', 600, NOW(), 3);
insert into `paint`(author, name, price, date_entry, shop_id) values('Author5', 'Paint5', 700, NOW(), 3);