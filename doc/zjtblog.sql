/*
Navicat MySQL Data Transfer

Source Server         : 我的阿里云2
Source Server Version : 50718
Source Host           : i.tzxylao.com:3306
Source Database       : zjtblog

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-09-28 09:47:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for d_page_config
-- ----------------------------
DROP TABLE IF EXISTS `d_page_config`;
CREATE TABLE `d_page_config` (
  `json_id` bigint(20) NOT NULL,
  `text` text,
  PRIMARY KEY (`json_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_page_config
-- ----------------------------

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', 'menu-plugin', '系统菜单', '1', null, '-1');
INSERT INTO `t_menu` VALUES ('10', '&#xe609;', '组件管理', '1', null, '1');
INSERT INTO `t_menu` VALUES ('60', '&#xe631;', '系统管理', '1', null, '1');
INSERT INTO `t_menu` VALUES ('61', '&#xe705;', '新闻资讯', '1', 'http://www.ifeng.com/', '1');
INSERT INTO `t_menu` VALUES ('62', '&#xe61d;', 'ZYS项目', '1', '', '1');
INSERT INTO `t_menu` VALUES ('1001', 'icon-text', 'rocketmq-console', '2', 'http://i.tzxylao.com:12581', '10');
INSERT INTO `t_menu` VALUES ('1002', 'icon-caidan', 'xxl-job', '2', 'http://i.tzxylao.com:8081/xxl-job-admin/toLogin', '10');
INSERT INTO `t_menu` VALUES ('1003', 'icon-liulanqi', 'activemq', '2', 'http://i.tzxylao.com:8161/', '10');
INSERT INTO `t_menu` VALUES ('6000', '&#xe631;', '菜单管理', '2', 'admin/menu/tomunemanage', '60');
INSERT INTO `t_menu` VALUES ('6010', 'icon-icon10', '角色管理', '2', 'admin/role/torolemanage', '60');
INSERT INTO `t_menu` VALUES ('6020', '&#xe612;', '用户管理', '2', 'admin/user/tousermanage', '60');
INSERT INTO `t_menu` VALUES ('6030', '&#xe631;', 'sql监控', '2', 'druid/index.html', '60');
INSERT INTO `t_menu` VALUES ('6040', 'icon-ziliao', '修改密码', '2', 'admin/user/toUpdatePassword', '60');
INSERT INTO `t_menu` VALUES ('6050', 'icon-tuichu', '安全退出', '2', 'user/logout', '60');
INSERT INTO `t_menu` VALUES ('6100', 'icon-text', '凤凰网', '2', 'http://www.ifeng.com/', '61');
INSERT INTO `t_menu` VALUES ('6200', 'icon-vip', 'contract合同', '2', 'http://tech.zhiyis.com:8086/contract-auth/', '62');
INSERT INTO `t_menu` VALUES ('6201', 'icon-xiugai', '项目管理中心', '2', 'http://tech.zhiyis.com:10003/', '62');
INSERT INTO `t_menu` VALUES ('200000', '44', '44', '3', '44', '2000');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bz` varchar(1000) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '系统管理员 最高权限', '管理员', null);
INSERT INTO `t_role` VALUES ('2', '主管', '主管', null);
INSERT INTO `t_role` VALUES ('4', '采购员', '采购员', null);
INSERT INTO `t_role` VALUES ('5', '销售经理', '销售经理', '22');
INSERT INTO `t_role` VALUES ('7', '仓库管理员', '仓库管理员', null);
INSERT INTO `t_role` VALUES ('9', '总经理', '总经理', null);
INSERT INTO `t_role` VALUES ('15', '111111', '111111', null);
INSERT INTO `t_role` VALUES ('16', '222', '222222', null);
INSERT INTO `t_role` VALUES ('17', '33', '333333', null);
INSERT INTO `t_role` VALUES ('18', '444444', '444444', null);
INSERT INTO `t_role` VALUES ('19', '555', '555555', null);
INSERT INTO `t_role` VALUES ('20', '666666', '666666', null);

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=361 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('36', '10', '2');
INSERT INTO `t_role_menu` VALUES ('42', '1', '2');
INSERT INTO `t_role_menu` VALUES ('45', '1', '4');
INSERT INTO `t_role_menu` VALUES ('48', '1', '5');
INSERT INTO `t_role_menu` VALUES ('55', '1', '9');
INSERT INTO `t_role_menu` VALUES ('65', '1', '7');
INSERT INTO `t_role_menu` VALUES ('66', '10', '7');
INSERT INTO `t_role_menu` VALUES ('126', '60', '15');
INSERT INTO `t_role_menu` VALUES ('127', '6010', '15');
INSERT INTO `t_role_menu` VALUES ('128', '6020', '15');
INSERT INTO `t_role_menu` VALUES ('129', '6030', '15');
INSERT INTO `t_role_menu` VALUES ('130', '6040', '15');
INSERT INTO `t_role_menu` VALUES ('131', '6050', '15');
INSERT INTO `t_role_menu` VALUES ('248', '2000', '1');
INSERT INTO `t_role_menu` VALUES ('259', '100000', '1');
INSERT INTO `t_role_menu` VALUES ('345', '10', '1');
INSERT INTO `t_role_menu` VALUES ('346', '1001', '1');
INSERT INTO `t_role_menu` VALUES ('347', '1002', '1');
INSERT INTO `t_role_menu` VALUES ('348', '1003', '1');
INSERT INTO `t_role_menu` VALUES ('349', '60', '1');
INSERT INTO `t_role_menu` VALUES ('350', '6000', '1');
INSERT INTO `t_role_menu` VALUES ('351', '6010', '1');
INSERT INTO `t_role_menu` VALUES ('352', '6020', '1');
INSERT INTO `t_role_menu` VALUES ('353', '6030', '1');
INSERT INTO `t_role_menu` VALUES ('354', '6040', '1');
INSERT INTO `t_role_menu` VALUES ('355', '6050', '1');
INSERT INTO `t_role_menu` VALUES ('356', '61', '1');
INSERT INTO `t_role_menu` VALUES ('357', '6100', '1');
INSERT INTO `t_role_menu` VALUES ('358', '62', '1');
INSERT INTO `t_role_menu` VALUES ('359', '6200', '1');
INSERT INTO `t_role_menu` VALUES ('360', '6201', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bz` varchar(1000) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `true_name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '管理员', '6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b', '劳梁梁', 'admin', '1');
INSERT INTO `t_user` VALUES ('2', '主管', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '王大锤', 'jackson', '2');
INSERT INTO `t_user` VALUES ('3', '销售经理', '123', '玛丽', 'marry', '33');
INSERT INTO `t_user` VALUES ('5', '1', '111111', '1', '111111', null);
INSERT INTO `t_user` VALUES ('6', '2', '222222', '2', '222222', null);
INSERT INTO `t_user` VALUES ('7', '3', '333333', '3', '333333', null);
INSERT INTO `t_user` VALUES ('8', '', '444444', '44', '444444', null);
INSERT INTO `t_user` VALUES ('9', '5', '555555', '5', '555555', null);
INSERT INTO `t_user` VALUES ('11', '7', '777777', '7', '777777', null);
INSERT INTO `t_user` VALUES ('12', '88', '888888', '88', '888888', null);
INSERT INTO `t_user` VALUES ('13', '9', '999999', '9', '999999', null);
INSERT INTO `t_user` VALUES ('14', '121212', '121212', '121212', '121212', null);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_user_role` VALUES ('19', '2', '2');
INSERT INTO `t_user_role` VALUES ('20', '4', '2');
INSERT INTO `t_user_role` VALUES ('21', '5', '2');
INSERT INTO `t_user_role` VALUES ('28', '2', '3');
INSERT INTO `t_user_role` VALUES ('29', '4', '3');
INSERT INTO `t_user_role` VALUES ('30', '5', '3');
INSERT INTO `t_user_role` VALUES ('31', '7', '3');
INSERT INTO `t_user_role` VALUES ('49', '15', '5');
INSERT INTO `t_user_role` VALUES ('50', '1', '5');
