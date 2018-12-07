/*
Navicat MySQL Data Transfer

Source Server         : sw
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : pay

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-07 20:00:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alipay_order_information
-- ----------------------------
DROP TABLE IF EXISTS `alipay_order_information`;
CREATE TABLE `alipay_order_information` (
  `out_trade_no` double DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `total_amount` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for commodity_list
-- ----------------------------
DROP TABLE IF EXISTS `commodity_list`;
CREATE TABLE `commodity_list` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hello
-- ----------------------------
DROP TABLE IF EXISTS `hello`;
CREATE TABLE `hello` (
  `id` int(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
