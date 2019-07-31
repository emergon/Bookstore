CREATE SCHEMA bookstore;
USE bookstore;

CREATE TABLE customer
(
  cid INT NOT NULL AUTO_INCREMENT,
  fname VARCHAR(15) NOT NULL,
  lname VARCHAR(15) NOT NULL,
  email VARCHAR(30) NOT NULL,
  password VARCHAR(15) NOT NULL,
  phone VARCHAR(15) NOT NULL,
  address VARCHAR(20) NOT NULL,
  zip VARCHAR(10) NOT NULL,
  country VARCHAR(15) NOT NULL,
  city VARCHAR(15) NOT NULL,
  register_on datetime NOT NULL,
  PRIMARY KEY (cid)
);

CREATE TABLE category
(
  cid INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  PRIMARY KEY (cid),
  UNIQUE (name)
);

CREATE TABLE book_order
(
  boid INT NOT NULL AUTO_INCREMENT,
  quantity INT NOT NULL,
  order_date DATETIME NOT NULL,
  payment_method VARCHAR(15) NOT NULL,
  shipping_address VARCHAR(15) NOT NULL,
  status VARCHAR(15) NOT NULL,
  total FLOAT NOT NULL,
  recipient_name VARCHAR(15) NOT NULL,
  recipient_phone VARCHAR(15) NOT NULL,
  cid INT NOT NULL,
  PRIMARY KEY (boid),
  CONSTRAINT fk1_cid FOREIGN KEY (cid) REFERENCES customer(cid)
);

CREATE TABLE user
(
  uid INT NOT NULL AUTO_INCREMENT,
  fname VARCHAR(15) NOT NULL,
  lname VARCHAR(15) NOT NULL,
  email VARCHAR(30) NOT NULL,
  password VARCHAR(15) NOT NULL,
  PRIMARY KEY (uid),
  UNIQUE (email)
);

CREATE TABLE book
(
  bid INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(30) NOT NULL,
  description mediumtext NOT NULL,
  author VARCHAR(15) NOT NULL,
  isbn VARCHAR(15) NOT NULL,
  price FLOAT NOT NULL,
  publish_date DATE NOT NULL,
  last_updated DATETIME NOT NULL,
  image LONGBLOB NOT NULL,
  cid INT NOT NULL,
  PRIMARY KEY (bid),
  CONSTRAINT fk1_catid FOREIGN KEY (cid) REFERENCES category(cid),
  UNIQUE (title)
);

CREATE TABLE order_details
(
  quantity INT NOT NULL,
  subtotal FLOAT NOT NULL,
  bid INT NOT NULL,
  boid INT NOT NULL,
  PRIMARY KEY (bid, boid),
  CONSTRAINT fk1_bid FOREIGN KEY (bid) REFERENCES book(bid),
  CONSTRAINT fk2_boid FOREIGN KEY (boid) REFERENCES book_order(boid)
);

CREATE TABLE `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `headline` varchar(128) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `review_time` datetime NOT NULL,
  PRIMARY KEY (`review_id`),
  UNIQUE KEY `review_id_UNIQUE` (`review_id`),
  KEY `book_fk_idx` (`book_id`),
  KEY `customer_fk_idx` (`customer_id`),
  CONSTRAINT `book_fk` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `customer_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

