/*
 Navicat Premium Data Transfer

 Source Server         : yzb
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : article_website_db

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 23/12/2019 22:34:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (6, 'admin', 'D553D148479A268914CECB77B2B88E6A', 1);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id,主键',
  `author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `label` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标签',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `likes` int(11) NULL DEFAULT NULL COMMENT '赞',
  `views` int(11) NULL DEFAULT NULL COMMENT '访问次数',
  `uid` int(11) NOT NULL COMMENT '创作者id',
  `status` int(10) NULL DEFAULT NULL COMMENT '文章状态：00未发布未审核；01未发布已审核；10已发布未审核；11已发布已审核',
  `enableComment` int(2) NULL DEFAULT NULL COMMENT '文章是否允许评论',
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 'yzb', 'Hello World', '# Hello World', 'Markdown', '2019-10-29 15:49:33', 1, 1, 1, 1, 1);
INSERT INTO `article` VALUES (2, 'yzb', '1', '1', '1', '2019-12-02 15:18:50', 1, 1, 1, 10, 1);

-- ----------------------------
-- Table structure for article_category
-- ----------------------------
DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_category
-- ----------------------------
INSERT INTO `article_category` VALUES (1, 'Markdown', 'Markdown 是一种轻量级标记语言，它允许人们使用易读易写的纯文本格式编写文档。', '2019-10-29 15:53:02');
INSERT INTO `article_category` VALUES (2, 'Hello World', 'Hello World 中文意思是『你好,世界』。因为《The C Programming Language》中使用它做为第一个演示程序，非常著名，所以后来的程序员在学习编程或进行设备调试时延续了这一习惯。', '2019-10-29 15:59:46');
INSERT INTO `article_category` VALUES (3, '默认分类', '默认分类', '2019-11-15 10:01:20');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` int(11) NOT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, '第一篇文章！', 1, NULL, '2019-10-29 15:58:14', 0);

-- ----------------------------
-- Table structure for relation_article_category
-- ----------------------------
DROP TABLE IF EXISTS `relation_article_category`;
CREATE TABLE `relation_article_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NULL DEFAULT NULL,
  `category_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relation_article_category
-- ----------------------------
INSERT INTO `relation_article_category` VALUES (1, 1, 1);
INSERT INTO `relation_article_category` VALUES (2, 1, 2);
INSERT INTO `relation_article_category` VALUES (3, 2, 3);
INSERT INTO `relation_article_category` VALUES (4, 2, 1);
INSERT INTO `relation_article_category` VALUES (5, 2, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(11) NOT NULL,
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'yzb', '202AA6C70D7F5F1D88D9DA1CB2DBF494', 1, 'bK33a0');
INSERT INTO `user` VALUES (2, 'user', '260B8867CEDAC6D7ED2CCACC8E083029', 1, 'H5yJ81');
INSERT INTO `user` VALUES (3, 'user1', '2741CE3249737F500C9DE7AC2C5F36FD', 1, 'oKWSTv');
INSERT INTO `user` VALUES (4, 'user2', '6BAC2D43E1988C1E6C7374F38BA4978C', 1, 'DV7T88');
INSERT INTO `user` VALUES (5, 'user3', 'CAA1B4794357EE7B3CBA437AC1A7B6D5', 1, 'v2t4OX');
INSERT INTO `user` VALUES (6, 'user4', '0F029096804EC5FDAE874B526A0E26D8', 0, 'kK867m');
INSERT INTO `user` VALUES (7, 'user5', 'E20A38E33E91897961DC1D574CC6A2A6', 0, 'HVx8cb');
INSERT INTO `user` VALUES (8, 'user6', 'E328E312F476BE3A6E6488E739A12F57', 0, '0315DY');
INSERT INTO `user` VALUES (9, 'user7', '2B07B319285332473234203339BF9A1B', 1, '2FY5ay');
INSERT INTO `user` VALUES (10, 'user8', 'BA64C7CA8DAE7EBD8BBA8E4B91D47E55', 1, '77VV6p');
INSERT INTO `user` VALUES (11, 'user9', '5FEF2714C6703233EA2573117395ECF6', 1, 'M8Bf31');
INSERT INTO `user` VALUES (12, 'user10', '9286C0694E680D16400DCE7E3FAE5E44', 1, '734P46');
INSERT INTO `user` VALUES (13, 'user11', '002736C68BB1891D38CA05F8F6C952BF', 1, 'O113Lj');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'yzb', '男', 22, 'yzb-clear@qq.com', 1);
INSERT INTO `user_info` VALUES (2, NULL, NULL, NULL, NULL, 2);
INSERT INTO `user_info` VALUES (3, NULL, NULL, NULL, NULL, 3);
INSERT INTO `user_info` VALUES (4, NULL, NULL, NULL, NULL, 4);
INSERT INTO `user_info` VALUES (5, NULL, NULL, NULL, NULL, 5);
INSERT INTO `user_info` VALUES (6, NULL, NULL, NULL, NULL, 6);
INSERT INTO `user_info` VALUES (7, NULL, NULL, NULL, NULL, 7);
INSERT INTO `user_info` VALUES (8, NULL, NULL, NULL, NULL, 8);
INSERT INTO `user_info` VALUES (9, NULL, NULL, NULL, NULL, 9);
INSERT INTO `user_info` VALUES (10, NULL, NULL, NULL, NULL, 10);
INSERT INTO `user_info` VALUES (11, NULL, NULL, NULL, NULL, 11);
INSERT INTO `user_info` VALUES (12, NULL, NULL, NULL, NULL, 12);
INSERT INTO `user_info` VALUES (13, NULL, NULL, NULL, NULL, 13);

SET FOREIGN_KEY_CHECKS = 1;
