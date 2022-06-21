/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : property

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 05/01/2022 16:12:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_building
-- ----------------------------
DROP TABLE IF EXISTS `db_building`;
CREATE TABLE `db_building`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `buildingNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roomNum` int NULL DEFAULT NULL,
  `buildingDesc` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buildHiredate` date NULL DEFAULT NULL,
  `cid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_building
-- ----------------------------
INSERT INTO `db_building` VALUES (1, 'CJ20191210001', 'A栋', 200, '金域华府欢迎您', '2021-02-09', 103);
INSERT INTO `db_building` VALUES (3, 'CJ20191210003', '1栋', 150, '望江台欢迎您', '2021-02-05', 2);
INSERT INTO `db_building` VALUES (4, 'sdfa4524', 'B栋', 132, '阿巴阿巴', '2021-02-05', 106);
INSERT INTO `db_building` VALUES (5, 'DF888455', 'C栋', 3, '阿巴阿巴', '2021-11-03', 95);
INSERT INTO `db_building` VALUES (7, 'sdfa4524', 'D栋', 254, '阿巴阿巴', '2021-11-03', 62);
INSERT INTO `db_building` VALUES (8, 'DF888487', 'E栋', 2222, '阿巴阿巴', '2021-11-03', 95);
INSERT INTO `db_building` VALUES (9, 'DF888452', 'F栋', 144, '阿巴阿巴', '2021-11-03', 62);
INSERT INTO `db_building` VALUES (10, 'DF225511', 'Y栋', 20, '阿巴阿巴', '2021-11-03', 83);
INSERT INTO `db_building` VALUES (13, 'DF888444', '3栋', 3, '阿巴阿巴', '2021-11-03', 97);
INSERT INTO `db_building` VALUES (17, 'sr444455', 'rr', 33, '阿巴阿巴', '2021-11-04', 106);
INSERT INTO `db_building` VALUES (18, 'DF888444', 'R栋', 50, '阿巴阿巴', '2021-11-05', 96);

-- ----------------------------
-- Table structure for db_car
-- ----------------------------
DROP TABLE IF EXISTS `db_car`;
CREATE TABLE `db_car`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '车辆ID',
  `oid` int NULL DEFAULT NULL COMMENT '所属成员（业主）',
  `carNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  `color` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆颜色',
  `picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆照片',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_car
-- ----------------------------
INSERT INTO `db_car` VALUES (1, 16, 'HY5533', '灰色', 'c1.jpg', '阿巴阿巴', '2021-11-12 09:57:03');
INSERT INTO `db_car` VALUES (2, 17, 'HQ5531', '浅蓝', 'c2.jpg', '阿巴阿巴', '2021-11-12 09:57:03');
INSERT INTO `db_car` VALUES (3, 12, 'HQ5535', '黑色', 'c3.jpg', '阿巴阿巴', '2021-11-06 11:03:42');
INSERT INTO `db_car` VALUES (9, 19, 'HQ5585', '白色', 'c4.jpg', '阿巴阿巴', '2021-11-10 22:16:21');

-- ----------------------------
-- Table structure for db_community
-- ----------------------------
DROP TABLE IF EXISTS `db_community`;
CREATE TABLE `db_community`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `communityNum` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `communityArea` double(20, 2) NULL DEFAULT NULL,
  `buildingNum` int NULL DEFAULT NULL,
  `roomNum` int NULL DEFAULT NULL,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `greeningRate` double(10, 2) NULL DEFAULT NULL,
  `developerName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `propertyName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hiredate` date NULL DEFAULT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  `uid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_community
-- ----------------------------
INSERT INTO `db_community` VALUES (1, 'XY20191210001', '金域华府', '合肥市蜀山区五里墩', 12000.00, 25, 160, 'xq5.jpg', 45.00, '万科', '万科物业', '2020-01-15', 1, NULL);
INSERT INTO `db_community` VALUES (2, 'XY20191210002', '望江台', '合肥市高新区望江西路', 20000.00, 35, 400, 'xq3.jpg', 60.00, '旭辉', '永升物业', '2021-02-19', 1, 1);
INSERT INTO `db_community` VALUES (62, 'XY20191210003', '仙人府', '合肥市蜀山区五里墩', 12000.00, 25, 200, 'xq2.jpg', 70.00, '万科', '万科物业', '2020-01-15', 1, NULL);
INSERT INTO `db_community` VALUES (83, 'XY20191210004', '荔湾区', '广州市', 1300.00, 50, 500, 'xq1.jpg', 90.00, '万科', 'xxx物业', '2021-10-28', 1, NULL);
INSERT INTO `db_community` VALUES (84, 'XY20191210005', '白云区', '广州市', 2340.00, 70, 600, 'xq4.jpg', 80.00, '永泰', 'xxx物业', '2021-10-28', 1, NULL);
INSERT INTO `db_community` VALUES (86, 'XY20191210006', '黄浦区', '广州市', 560.00, 100, 200, 'xq5.jpg', 90.00, '永泰', 'xxx物业', '2021-10-29', 1, NULL);
INSERT INTO `db_community` VALUES (87, 'XY20191210007', '天河区', '广州市', 980.00, 40, 300, 'xq3.jpg', 60.00, '永泰', 'xxx物业', '2021-10-29', 1, NULL);
INSERT INTO `db_community` VALUES (95, 'XY20191210008', '知识区', '广州市', 230.00, 30, 400, 'xq1.jpg', 80.00, '永泰', 'xxx物业', '2021-10-30', 1, NULL);
INSERT INTO `db_community` VALUES (96, 'XY20191210086', '鬼畜区', '广州市', 239.00, 70, 200, 'xq2.jpg', 70.00, '永泰', 'xxx物业', '2021-10-30', 1, NULL);
INSERT INTO `db_community` VALUES (97, 'XY20191210453', '游戏区', '广州市', 265.00, 70, 100, 'xq4.jpg', 90.00, '永泰', 'xxx物业', '2021-10-30', 0, NULL);
INSERT INTO `db_community` VALUES (103, 'XY20191210776', '番禺区', '广州市', 340.00, 40, 300, 'xq2.jpg', 80.00, '万科', 'xxx物业', '2021-10-31', 1, NULL);

-- ----------------------------
-- Table structure for db_house
-- ----------------------------
DROP TABLE IF EXISTS `db_house`;
CREATE TABLE `db_house`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房屋ID',
  `cid` int NULL DEFAULT NULL COMMENT '所属小区ID',
  `bid` int NULL DEFAULT NULL COMMENT '所属栋数ID',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房产编码',
  `hname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房产名称',
  `ownerName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户主（业主）名称',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `roomNum` int NULL DEFAULT NULL COMMENT '房间数',
  `unit` int NULL DEFAULT NULL COMMENT '单元',
  `floor` int NULL DEFAULT NULL COMMENT '楼层',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `liveTime` date NOT NULL COMMENT '入住时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '房屋表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_house
-- ----------------------------
INSERT INTO `db_house` VALUES (1, 103, 4, 'FC888998', '房产名称7', '张全蛋', '18822223333', 4, 2, 7, '阿巴阿巴', '2021-11-06');
INSERT INTO `db_house` VALUES (2, 95, 7, 'FC888997', '房产名称6', '张全蛋', '18822223333', 2, 1, 6, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (3, 83, 10, 'FC888996', '房产名称5', '张全蛋', '18822223333', 1, 1, 2, '阿巴阿巴', '2021-11-01');
INSERT INTO `db_house` VALUES (4, 84, 1, 'FC888999', '房产名称8', '张全蛋', '18822223333', 3, 3, 6, '阿巴阿巴', '2021-11-03');
INSERT INTO `db_house` VALUES (7, 1, 1, 'FC888995', '房产名称4', '张全蛋', '18822223333', 3, 3, 5, '阿巴阿巴', '2021-11-02');
INSERT INTO `db_house` VALUES (9, 84, 1, 'FC888994', '房产名称3', '张全蛋', '18822223333', 2, 4, 6, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (10, 1, 1, 'FC888993', '房产名称2', '张全蛋', '18822223333', 1, 2, 4, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (11, 1, 1, 'FC888992', '房产名称1', '张全蛋', '18822223333', 2, 3, 6, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (12, 1, 1, 'FC888991', '房产名称9', '张全蛋', '18822223333', 3, 2, 6, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (13, 1, 1, 'FC888990', '测试8', '张全蛋', '18822223333', 4, 3, 7, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (14, 1, 1, 'FC888950', '测试9', '张全蛋', '18822223333', 4, 4, 6, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (15, 1, 1, 'FC888951', '测试10', '张全蛋', '18822223333', 4, 5, 6, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (16, 84, 10, 'FC888952', '测试1', '张全蛋', '18822223333', 2, 2, 5, '阿巴阿巴', '2021-11-05');
INSERT INTO `db_house` VALUES (20, 87, 13, 'DFS55', '测试12', '张全蛋', '18822223333', 5, 6, 4, '阿巴阿巴', '2021-11-10');
INSERT INTO `db_house` VALUES (21, 1, 1, 'CS1', '测试1', '张全蛋', '18822223333', 4, 5, 3, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (22, 1, 1, 'CS2', '测试2', '张全蛋', '18822223333', 3, 4, 3, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (23, 1, 1, 'CS3', '测试3', '张全蛋', '18822223333', 2, 7, 4, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (24, 1, 1, 'CS4', '测试4', '张全蛋', '18822223333', 3, 7, 4, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (25, 97, 1, 'CS5', '测试5', '张全蛋', '18822223333', 4, 7, 5, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (26, 96, 1, 'CS6', '测试6', '张全蛋', '18822223333', 3, 7, 5, '阿巴阿巴', '2021-11-04');
INSERT INTO `db_house` VALUES (34, 97, 1, 'CS7', '测试7', '张全蛋', '18822223333', 2, 6, 5, NULL, '2021-11-11');

-- ----------------------------
-- Table structure for db_owner
-- ----------------------------
DROP TABLE IF EXISTS `db_owner`;
CREATE TABLE `db_owner`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '业主ID',
  `cid` int NULL DEFAULT NULL COMMENT '所属小区',
  `hid` int NULL DEFAULT NULL COMMENT '所属房产',
  `oname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成员名称',
  `picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成员照片',
  `idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `profession` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `sex` int NULL DEFAULT 0 COMMENT '性别:0-男（默认），1-女',
  `type` int NULL DEFAULT 0 COMMENT '类型:0-房主（默认），1-租客,2-家庭成员',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '无' COMMENT '备注（默认无）',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `birthday` date NULL DEFAULT '0000-00-00' COMMENT '出生日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '业主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_owner
-- ----------------------------
INSERT INTO `db_owner` VALUES (1, 83, 4, '李靖', 'yh3.jpg', '123456789012345678', '18812345678', '54354', 0, 0, '无', '2021-11-05 18:53:57', '2021-12-31');
INSERT INTO `db_owner` VALUES (3, 83, 9, '哪吒', 'yh1.jpg', '123456789012345678', '18812345678', '54354', 1, 1, '无', '2021-11-05 18:53:57', '2021-12-31');
INSERT INTO `db_owner` VALUES (10, 84, 10, '敖丙', 'yh3.jpg', '123456789012345678', '18812345678', '54354', 0, 2, '无', '2021-11-05 18:53:57', '2021-12-08');
INSERT INTO `db_owner` VALUES (11, 106, 4, '仙人', 'yh4.jpg', '123456789012345678', '18812345678', '54354', 1, 1, '无', '2021-11-05 18:53:57', '2021-11-30');
INSERT INTO `db_owner` VALUES (12, 106, 4, '张全蛋', 'yh5.jpg', '123456789012345678', '18812345678', '54354', 0, 1, '无', '2021-11-05 18:53:57', '2021-12-31');
INSERT INTO `db_owner` VALUES (13, 106, 4, '大娃', 'yh2.jpg', '123456789012345678', '18812345678', '54354', 1, 2, '无', '2021-11-05 18:53:57', '2021-12-31');
INSERT INTO `db_owner` VALUES (14, 87, 9, '二娃', 'yh4.jpg', '123456789012345678', '18812345678', '2', 1, 0, '无', '2021-11-05 21:43:49', '2021-11-10');
INSERT INTO `db_owner` VALUES (15, 87, 1, '三娃', 'yh5.jpg', '123456789012345678', '18812345678', '律师', 0, 2, '无', '2021-11-05 22:30:05', '2021-11-24');
INSERT INTO `db_owner` VALUES (16, 103, 1, '四娃', 'yh1.jpg', '123456789012345678', '18812345678', '1', 1, 1, '无', '2021-11-05 22:42:42', '2021-11-30');
INSERT INTO `db_owner` VALUES (17, 87, 1, '五娃', 'yh3.jpg', '123456789012345678', '18812345678', '1', 0, 0, '无', '2021-11-05 22:50:56', '2021-11-24');
INSERT INTO `db_owner` VALUES (18, 62, 1, '六娃', 'yh1.jpg', '123456789012345678', '18812345678', '1', 1, 2, '无', '2021-11-06 09:10:25', '2021-11-24');
INSERT INTO `db_owner` VALUES (19, 97, 1, '七娃', 'yh5.jpg', '123456789012345678', '18812345678', '1', 0, 0, '无', '2021-11-10 22:15:40', '2021-11-30');

-- ----------------------------
-- Table structure for db_pet
-- ----------------------------
DROP TABLE IF EXISTS `db_pet`;
CREATE TABLE `db_pet`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '宠物ID',
  `picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宠物照片',
  `oid` int NULL DEFAULT NULL COMMENT '所属成员（业主）ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宠物名称',
  `color` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '宠物颜色',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `adoptTime` date NOT NULL DEFAULT '0000-00-00' COMMENT '收养时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '宠物表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_pet
-- ----------------------------
INSERT INTO `db_pet` VALUES (1, 'kj.jpg', 12, '柯基', '棕白', '无', '2021-11-09');
INSERT INTO `db_pet` VALUES (2, 'eh.jpg', 3, '二哈', '黑白', '无', '2021-11-02');
INSERT INTO `db_pet` VALUES (3, 'wg.jpg', 13, '乌龟', '深蓝色', '无', '2021-11-17');
INSERT INTO `db_pet` VALUES (4, 'gz.jpg', 19, '鸽子', '白色', '无', '2021-11-30');
INSERT INTO `db_pet` VALUES (5, 'xhr.jpg', 12, '小黄人', '黄色', '无', '2021-11-16');
INSERT INTO `db_pet` VALUES (7, '', 1, '2', '2', '2', '2022-01-19');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `pid` int NOT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `spread` int NULL DEFAULT NULL,
  `url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '小区物业管理系统', 1, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (2, 1, '小区管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (3, 1, '房产管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (4, 1, '业主信息管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (5, 1, '停车位管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (6, 1, '服务管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (7, 1, '资产管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (8, 1, '收费管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (9, 1, '管理员管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (10, 1, '系统设置', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (11, 2, '小区列表', 0, 'communitylist.jsp', NULL, 1);
INSERT INTO `sys_menu` VALUES (12, 3, '房产管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (13, 3, '栋数管理', 0, 'buildinglist.jsp', NULL, 1);
INSERT INTO `sys_menu` VALUES (14, 4, '人员管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (15, 4, '车辆管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (16, 4, '宠物管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (17, 5, '车位管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (18, 5, '车位使用管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (19, 6, '活动管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (20, 6, '保修管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (21, 6, '投诉管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (22, 6, '信箱管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (23, 7, '资产设备管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (24, 8, '收费项目', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (25, 8, '收费明细管理', 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (26, 9, '管理员列表', 0, 'userManager.jsp', NULL, 1);
INSERT INTO `sys_menu` VALUES (27, 9, '用户组管理', 0, 'roleManager.jsp', NULL, 1);
INSERT INTO `sys_menu` VALUES (28, 9, '权限管理', 0, 'menuManager.jsp', NULL, 1);
INSERT INTO `sys_menu` VALUES (29, 10, '系统设置', 0, '', NULL, 1);
INSERT INTO `sys_menu` VALUES (30, 10, '个人设置', 0, NULL, NULL, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rolename` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roledesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', '拥有所有菜单', 1);
INSERT INTO `sys_role` VALUES (2, '业务管理员', '拥有所有业务菜单', 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rid` int NULL DEFAULT NULL,
  `mid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (57, 1, 1);
INSERT INTO `sys_role_menu` VALUES (58, 1, 2);
INSERT INTO `sys_role_menu` VALUES (59, 1, 11);
INSERT INTO `sys_role_menu` VALUES (60, 1, 3);
INSERT INTO `sys_role_menu` VALUES (61, 1, 12);
INSERT INTO `sys_role_menu` VALUES (62, 1, 13);
INSERT INTO `sys_role_menu` VALUES (63, 1, 4);
INSERT INTO `sys_role_menu` VALUES (64, 1, 14);
INSERT INTO `sys_role_menu` VALUES (65, 1, 15);
INSERT INTO `sys_role_menu` VALUES (66, 1, 16);
INSERT INTO `sys_role_menu` VALUES (67, 1, 5);
INSERT INTO `sys_role_menu` VALUES (68, 1, 17);
INSERT INTO `sys_role_menu` VALUES (69, 1, 18);
INSERT INTO `sys_role_menu` VALUES (70, 1, 6);
INSERT INTO `sys_role_menu` VALUES (71, 1, 19);
INSERT INTO `sys_role_menu` VALUES (72, 1, 20);
INSERT INTO `sys_role_menu` VALUES (73, 1, 21);
INSERT INTO `sys_role_menu` VALUES (74, 1, 22);
INSERT INTO `sys_role_menu` VALUES (75, 1, 7);
INSERT INTO `sys_role_menu` VALUES (76, 1, 23);
INSERT INTO `sys_role_menu` VALUES (77, 1, 8);
INSERT INTO `sys_role_menu` VALUES (78, 1, 24);
INSERT INTO `sys_role_menu` VALUES (79, 1, 25);
INSERT INTO `sys_role_menu` VALUES (80, 1, 9);
INSERT INTO `sys_role_menu` VALUES (81, 1, 26);
INSERT INTO `sys_role_menu` VALUES (82, 1, 27);
INSERT INTO `sys_role_menu` VALUES (83, 1, 28);
INSERT INTO `sys_role_menu` VALUES (84, 1, 10);
INSERT INTO `sys_role_menu` VALUES (85, 1, 29);
INSERT INTO `sys_role_menu` VALUES (86, 2, 1);
INSERT INTO `sys_role_menu` VALUES (87, 2, 2);
INSERT INTO `sys_role_menu` VALUES (88, 2, 11);
INSERT INTO `sys_role_menu` VALUES (89, 2, 3);
INSERT INTO `sys_role_menu` VALUES (90, 2, 12);
INSERT INTO `sys_role_menu` VALUES (91, 2, 13);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hiredate` date NULL DEFAULT NULL,
  `type` int NULL DEFAULT 2 COMMENT '1管理员；2普通用户',
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '超级管理员', '123', '13511112222', '1351112222@163.com', '2020-12-24', 1, 'admin.jpg', 1);
INSERT INTO `sys_user` VALUES (2, 'lisi', '李四', '123', '13522221111', '136@163.com', '2021-02-04', 2, 'user.jpg', 0);
INSERT INTO `sys_user` VALUES (4, 'fly', 'fly', '123', '15325644723', '136@163.com', '2021-11-06', 2, 'user.jpg', 1);
INSERT INTO `sys_user` VALUES (6, 'ADMIN2', 'ADMIN2', '123', '15325644724', '136@163.com', '2021-11-06', 2, 'user.jpg', 1);
INSERT INTO `sys_user` VALUES (8, 'eee', 'eee', '123', '15325644725', '136@163.com', '2021-11-06', 2, 'user.jpg', 1);
INSERT INTO `sys_user` VALUES (18, 'zhangsan', '张三', '123', '15325644726', '136@163.com', '2021-11-10', 2, 'user.jpg', 1);
INSERT INTO `sys_user` VALUES (19, '2', '2', '123', '15325644727', '136@163.com', '2021-11-10', 2, 'user.jpg', 1);
INSERT INTO `sys_user` VALUES (20, '3', '3', '123', '15325644728', '136@163.com', '2021-11-10', 2, 'user.jpg', 1);
INSERT INTO `sys_user` VALUES (22, '4', '4', '123', '15325644729', '136@163.com', '2021-11-10', 2, 'user.jpg', 1);
INSERT INTO `sys_user` VALUES (23, '5', '5', '123', '15325644730', '5', '2021-11-10', 2, 'user.jpg', 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NULL DEFAULT NULL,
  `rid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (13, 1, 1);
INSERT INTO `sys_user_role` VALUES (14, 1, 2);
INSERT INTO `sys_user_role` VALUES (15, 3, 2);

SET FOREIGN_KEY_CHECKS = 1;
