/*
 Navicat Premium Data Transfer

 Source Server         : local Mysql57
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : homemaking

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 03/05/2020 09:56:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '分类描述',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '职业保姆', '比较熟悉家庭的生活习惯、卫生标准及饮食口味，对婴幼保育方面也有一定的服务经验，能独立担当日常家庭事物的打理', 1, '2020-05-02 11:43:08', '2020-05-02 11:43:08');
INSERT INTO `category` VALUES (2, '涉外保姆', '具备高端家庭事务的打理和管理，擅长儿童中英文教育和学习辅导', 1, '2020-05-02 11:47:08', '2020-05-02 17:49:18');
INSERT INTO `category` VALUES (3, '高级管家', '既能主理家务，又能处理商务；既能教书育童，又懂饮食营养；既会待人接物，又懂礼仪着装；日常采买、洗衣熨烫、简单花艺、宠物饲养、虽不算优秀，也基本上良好', 1, '2020-05-02 11:47:08', '2020-05-02 11:47:08');
INSERT INTO `category` VALUES (4, '育婴早教', '不但对婴幼保育、早期教育有一定的能力，而且在打理家务上与普通家政服务员工相比也不逊色。她们的沟通互动能力和理解能力都是相当不错的', 1, '2020-05-02 11:47:08', '2020-05-02 11:47:08');
INSERT INTO `category` VALUES (5, '钟点服务', '临时用工随叫随到，但不定位到某一个服务钟点工，包月钟点工是定时、定点、定人的固定服务', 1, '2020-05-02 11:47:08', '2020-05-02 11:47:08');
INSERT INTO `category` VALUES (6, '幼教保育', '善于和儿童做游戏，唱儿歌，讲故事，跳舞蹈和进行户外活动', 1, '2020-05-02 11:47:08', '2020-05-02 11:47:08');
INSERT INTO `category` VALUES (7, '清洁清洗', '清洁家具和常用电器设备以及各种物品的清理', 1, '2020-05-02 11:47:08', '2020-05-02 11:47:08');

-- ----------------------------
-- Table structure for clean
-- ----------------------------
DROP TABLE IF EXISTS `clean`;
CREATE TABLE `clean`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '服务编号',
  `clean_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务名称',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '服务内容',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '服务描述',
  `price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '价格',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '发布人',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '服务分类编号',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `clicked` int(11) NOT NULL DEFAULT 0 COMMENT '点击量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '清洁服务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clean
-- ----------------------------
INSERT INTO `clean` VALUES (1, '带孩子哈哈', '正经大孩子', '我喜欢带孩子123', '面议啊', 3, 4, 2, 1, '2020-05-02 23:35:30', '2020-05-02 23:45:53', 3);
INSERT INTO `clean` VALUES (3, '找个管家', '带娃找个管家', '再次掐额', '200元每小时', 3, 5, 2, 1, '2020-05-02 23:39:29', '2020-05-02 23:39:40', 0);
INSERT INTO `clean` VALUES (4, '找一个管家', '真的要一个好管家', '好的', '200', 2, 3, 1, 1, '2020-05-02 23:43:23', '2020-05-02 23:43:57', 2);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '评论内容',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `comment_user_id` int(11) NULL DEFAULT NULL COMMENT '留言用户编号',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '你能带多大的孩子？', 3, 2, '2020-05-02 23:41:27');
INSERT INTO `comment` VALUES (2, '请回复我，抱歉打扰了', 3, 2, '2020-05-02 23:41:37');
INSERT INTO `comment` VALUES (3, '我可以', 2, 3, '2020-05-02 23:43:54');
INSERT INTO `comment` VALUES (4, '我都能带', 2, 3, '2020-05-02 23:52:23');
INSERT INTO `comment` VALUES (5, '那好，我马上下单', 3, 2, '2020-05-02 23:52:44');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻编号',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '描述',
  `type` int(11) NULL DEFAULT NULL COMMENT '新闻类型',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '新闻信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '“我值得尊重吗？”', '一个保姆的思考', '发生在一个晚上不好吧', 1, '2020-05-02 23:40:18', '2020-05-02 23:40:25');
INSERT INTO `news` VALUES (2, '系统马上更新', '我们系统则证', '在升级', 2, '2020-05-02 23:40:42', '2020-05-02 23:40:42');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '分类编号',
  `clean_id` int(11) NULL DEFAULT NULL COMMENT '服务编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `service_id` int(11) NULL DEFAULT NULL COMMENT '家政编号',
  `status` int(11) NULL DEFAULT 0 COMMENT '订单状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `create_user_id` int(11) NULL DEFAULT NULL COMMENT '发起人编号',
  `to_user_id` int(11) NULL DEFAULT NULL COMMENT '接收人编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 3, 4, 2, 3, 2, '2020-05-02 23:43:57', 3, 2);
INSERT INTO `order` VALUES (2, 4, 1, 2, 3, 3, '2020-05-02 23:45:53', 2, 3);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评分',
  `service_id` int(11) NULL DEFAULT NULL COMMENT '家政编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '追加时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分值记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (2, '100', 3, 2, '2020-05-02 23:46:37', '2020-05-02 23:46:37');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '住址',
  `qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123', '未满18岁', '男', '12345', '北京海淀区123', '', 'test.@163.com', 1);
INSERT INTO `user` VALUES (2, 'User', '123', NULL, NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `user` VALUES (3, 'work', '123', NULL, NULL, NULL, NULL, NULL, NULL, 3);

SET FOREIGN_KEY_CHECKS = 1;
