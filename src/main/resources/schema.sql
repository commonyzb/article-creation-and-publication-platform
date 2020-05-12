//用户帐号信息表
CREATE TABLE IF NOT EXISTS 'user'(
    'uid' INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    'user_name' VARCHAR(30) NOT NULL,
    'user_password' VARCHAR(100) NOT NULL ,
    'status' INT NOT NULL,
    'salt' VARCHAR NOT NULL
);

//用户详细信息表
CREATE TABLE IF NOT EXISTS 'user_info'(
  'id' INT PRIMARY KEY AUTO_INCREMENT,
  'name' VARCHAR(30) ,
  'sex' INT,
  'age' INT,
  'email' VARCHAR(50),
  'uid' INT NOT NULL
);

//文章表
CREATE TABLE IF NOT EXISTS 'article'(
  'aid' INT PRIMARY KEY AUTO_INCREMENT,
  'author' varchar(30),
  'title' varchar(50) NOT NULL ,
  'content' text NOT NULL ,
  'label' varchar(50) NOT NULL ,
  'create_time' DATETIME,
  'likes' INT , //点赞数
  'views' INT , //阅读数
  'uid' INT NOT NULL,
  'status' varchar(10) NOT NULL
);

//文章分类
CREATE TABLE IF NOT EXISTS 'article_category'(
  'id' INT PRIMARY KEY AUTO_INCREMENT,
  'category_name' VARCHAR(100) NOT NULL,
  'create_time' DATETIME
);

//文章及其分类关联表
CREATE TABLE IF NOT EXISTS 'relation_article_category'(
  'id' INT PRIMARY KEY AUTO_INCREMENT,
  'aid' INT,
  'category_id' INT
);

//评论表
CREATE TABLE IF NOT EXISTS 'comment'(
  'id' INT PRIMARY KEY AUTO_INCREMENT,
  'aid' INT NOT NULL ,
  'content' TEXT NOT NULL ,
  'uid' INT NOT NULL ,
  'parent_id' INT ,
  'create_time' DATETIME,
  'status' INT //0未审核 1已审核
);

//管理员帐号表
CREATE TABLE IF NOT EXISTS 'admin'(
  'id' INT PRIMARY KEY AUTO_INCREMENT,
  'admin_name' VARCHAR(30) NOT NULL ,
  'admin_password' VARCHAR(100),
  'status' INT NOT NULL
)
