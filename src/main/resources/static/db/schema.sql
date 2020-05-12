CREATE TABLE IF NOT EXISTS user(
  uid INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name  VARCHAR(30) NOT NULL,
  user_password  VARCHAR(100) NOT NULL ,
  status  INT NOT NULL,
  salt  VARCHAR
);


CREATE TABLE IF NOT EXISTS user_info(
   id  INT PRIMARY KEY AUTO_INCREMENT,
   name  VARCHAR(30) ,
   sex  INT,
   age  INT,
   email  VARCHAR(50),
   uid  INT
);

CREATE TABLE IF NOT EXISTS  article (
   aid  INT PRIMARY KEY AUTO_INCREMENT,
   author  varchar(30),
   title  varchar(50) NOT NULL ,
   content  text NOT NULL ,
   label  varchar(50) NOT NULL ,
   create_time  DATETIME,
   likes  INT ,
   views  INT ,
   uid  INT NOT NULL,
   status  varchar(10)
);

CREATE TABLE IF NOT EXISTS  article_category (
   id  INT PRIMARY KEY AUTO_INCREMENT,
   category_name  VARCHAR(100) NOT NULL,
   create_time  DATETIME
);


CREATE TABLE IF NOT EXISTS  relation_article_category (
   id  INT PRIMARY KEY AUTO_INCREMENT,
   aid  INT,
   category_id  INT
);


CREATE TABLE IF NOT EXISTS  comment (
   id  INT PRIMARY KEY AUTO_INCREMENT,
   aid  INT NOT NULL ,
   content  TEXT NOT NULL ,
   uid  INT NOT NULL ,
   parent_id  INT ,
   create_time  DATETIME,
   status  INT
);


CREATE TABLE IF NOT EXISTS  admin (
   id  INT PRIMARY KEY AUTO_INCREMENT,
   admin_name  VARCHAR(30) NOT NULL ,
   admin_password  VARCHAR(100),
   status  INT
);
