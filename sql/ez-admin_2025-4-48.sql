/*
 Navicat Premium Dump SQL

 Source Server         : tongtong
 Source Server Type    : MySQL
 Source Server Version : 80402 (8.4.2)
 Source Host           : 110.40.175.47:3306
 Source Schema         : ez-admin

 Target Server Type    : MySQL
 Target Server Version : 80402 (8.4.2)
 File Encoding         : 65001

 Date: 18/04/2025 14:30:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ez_admin_dept
-- ----------------------------
DROP TABLE IF EXISTS `ez_admin_dept`;
CREATE TABLE `ez_admin_dept`  (
  `dept_id` bigint UNSIGNED NOT NULL COMMENT '部门ID',
  `dept_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `dept_sort` int NOT NULL DEFAULT 999 COMMENT '排序',
  `ancestors` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '祖级列表',
  `parent_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级菜单ID',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '部门状态【0 停用 1 正常】',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除【0 正常 1 已删除】',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ez_admin_dept
-- ----------------------------
INSERT INTO `ez_admin_dept` VALUES (1912353447214342145, '111', 999, '', 0, 1, '12', 'admin', 'admin', '2025-04-16 11:52:46', '2025-04-16 15:20:58', 0);
INSERT INTO `ez_admin_dept` VALUES (1912397922749984770, '222', 999, '', 1912353447214342145, 1, '', 'admin', 'admin', '2025-04-16 14:49:30', '2025-04-16 15:20:58', 0);
INSERT INTO `ez_admin_dept` VALUES (1912398034905673730, '查出', 999, '', 0, 1, '', 'admin', 'admin', '2025-04-16 14:49:57', '2025-04-16 15:47:34', 1);
INSERT INTO `ez_admin_dept` VALUES (1912398173066047489, '555', 1, '', 0, 1, '', 'admin', 'admin', '2025-04-16 14:50:30', '2025-04-16 17:51:14', 0);
INSERT INTO `ez_admin_dept` VALUES (1912398267765043201, 'g公告', 999, '', 0, 1, '', 'admin', 'admin', '2025-04-16 14:50:52', '2025-04-16 15:47:53', 1);
INSERT INTO `ez_admin_dept` VALUES (1912424338992414722, '12123', 999, '', 0, 1, '', 'admin', 'admin', '2025-04-16 16:34:28', '2025-04-16 16:34:30', 0);
INSERT INTO `ez_admin_dept` VALUES (1912424808003682306, '123124', 999, '', 1912424338992414722, 1, '', 'admin', 'admin', '2025-04-16 16:36:20', '2025-04-16 16:36:21', 0);
INSERT INTO `ez_admin_dept` VALUES (1912424841801383938, '儿', 999, '', 1912424808003682306, 1, '', 'admin', 'admin', '2025-04-16 16:36:28', '2025-04-16 16:36:28', 0);

-- ----------------------------
-- Table structure for ez_admin_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `ez_admin_dict_data`;
CREATE TABLE `ez_admin_dict_data`  (
  `dict_data_id` bigint UNSIGNED NOT NULL COMMENT '字典详情主键ID',
  `dict_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '字典类型ID',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_sort` int NULL DEFAULT 0 COMMENT '字典排序',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '是否默认【0 否 1 是】',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态【0 停用 1 正常】',
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '描述信息',
  PRIMARY KEY (`dict_data_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ez_admin_dict_data
-- ----------------------------

-- ----------------------------
-- Table structure for ez_admin_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `ez_admin_dict_type`;
CREATE TABLE `ez_admin_dict_type`  (
  `dict_id` bigint NOT NULL COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态【0 停用 1 正常】',
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '描述信息',
  PRIMARY KEY (`dict_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ez_admin_dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for ez_admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `ez_admin_menu`;
CREATE TABLE `ez_admin_menu`  (
  `menu_id` bigint UNSIGNED NOT NULL COMMENT '菜单ID',
  `menu_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `menu_icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '菜单图标',
  `menu_label` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单标识',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT '父级菜单ID',
  `menu_sort` int UNSIGNED NOT NULL DEFAULT 999 COMMENT '菜单排序',
  `menu_type` tinyint UNSIGNED NOT NULL COMMENT '菜单类型【1 目录 2 菜单 3 按钮】',
  `menu_perm` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `route_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由地址',
  `route_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由名称',
  `component_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径',
  `status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜单状态【0 停用 1 正常】',
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '描述信息',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除【0 正常 1 已删除】',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ez_admin_menu
-- ----------------------------
INSERT INTO `ez_admin_menu` VALUES (1909490924932939778, '系统管理', 'ep:setting', '', 0, 1, 1, '', '/system', 'system', '', 0, 'admin', '2025-04-08 14:18:08', 'admin', '2025-04-09 17:03:12', '', 0);
INSERT INTO `ez_admin_menu` VALUES (1909902055530905601, '用户管理', 'ep:user-filled', '', 1909490924932939778, 11, 2, 'sys:user:list', 'user', 'user', '/system/user/UserManagementPage.vue', 0, 'admin', '2025-04-09 17:31:49', 'admin', '2025-04-10 11:31:29', '', 0);
INSERT INTO `ez_admin_menu` VALUES (1909902213773606914, '角色管理', 'icon-park-solid:peoples', '', 1909490924932939778, 12, 2, 'sys:role:list', 'role', 'role', '/system/role/RoleManagementPage.vue', 0, 'admin', '2025-04-09 17:32:27', 'admin', '2025-04-10 11:26:51', '', 0);
INSERT INTO `ez_admin_menu` VALUES (1909902275278880769, '菜单管理', 'ep:menu', '', 1909490924932939778, 13, 2, 'sys:menu:list', 'menu', 'menu', '/system/menu/MenuManagementPage.vue', 0, 'admin', '2025-04-09 17:32:41', 'admin', '2025-04-10 11:31:14', '', 0);
INSERT INTO `ez_admin_menu` VALUES (1909902335215484930, '部门管理', 'ep:office-building', '', 1909490924932939778, 14, 2, 'sys:dept:list', 'dept', 'dept', '/system/dept/DeptManagementPage.vue', 0, 'admin', '2025-04-09 17:32:56', 'admin', '2025-04-10 11:31:47', '', 0);
INSERT INTO `ez_admin_menu` VALUES (1909902393692471298, '字典管理', 'ep:memo', '', 1909490924932939778, 15, 2, 'sys:dict:list', 'dict', 'dict', '/system/dict/DictManagementPage.vue', 0, 'admin', '2025-04-09 17:33:10', 'admin', '2025-04-10 11:29:32', '', 0);
INSERT INTO `ez_admin_menu` VALUES (1909902443113955330, '配置管理', 'ep:edit', '', 1909490924932939778, 16, 2, 'sys:config:list', 'config', 'config', '/system/config/ConfigManagementPage.vue', 0, 'admin', '2025-04-09 17:33:21', 'admin', '2025-04-15 16:06:32', '', 0);
INSERT INTO `ez_admin_menu` VALUES (1912407916132245505, '爱玩游戏', 'icon-park-outline:game-ps', '', 0, 0, 1, '', '/aiwan', 'aiwan', '', 0, 'admin', '2025-04-16 15:29:13', 'admin', '2025-04-16 15:29:13', '', 0);
INSERT INTO `ez_admin_menu` VALUES (1912408705965764609, '游戏分类', 'icon-park-outline:category-management', '', 1912407916132245505, 0, 2, 'aiwan:category:list', 'category', 'category', '', 0, 'admin', '2025-04-16 15:32:21', 'admin', '2025-04-16 15:32:21', '', 0);

-- ----------------------------
-- Table structure for ez_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `ez_admin_role`;
CREATE TABLE `ez_admin_role`  (
  `role_id` bigint UNSIGNED NOT NULL COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `role_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色权限字符标识',
  `role_sort` int UNSIGNED NOT NULL DEFAULT 999 COMMENT '排序',
  `data_scope` tinyint UNSIGNED NOT NULL DEFAULT 1 COMMENT '数据范围【1 仅本人数据权限 2 本部门数据权限 3 本部门及以下数据权限 4 自定义数据权限 5 全部数据权限】',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '角色状态【0 停用 1 正常】',
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '描述信息',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除【0 正常 1 已删除】',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ez_admin_role
-- ----------------------------
INSERT INTO `ez_admin_role` VALUES (1901525301556682754, '超级管理员', 'admin', 1, 5, 1, 'init', '2025-04-10 15:31:45', 'admin', '2025-04-15 15:15:40', '超级管理员', 0);
INSERT INTO `ez_admin_role` VALUES (1912032533201358850, 'aa', 'aa', 1, 1, 0, 'admin', '2025-04-15 14:37:34', 'admin', '2025-04-15 15:32:08', 'asd', 1);
INSERT INTO `ez_admin_role` VALUES (1912033117522382850, 'test', 'e6', 2, 1, 0, 'admin', '2025-04-15 14:39:54', 'admin', '2025-04-15 15:31:59', 'asda', 1);
INSERT INTO `ez_admin_role` VALUES (1912048791120568321, '测试一', 'test', 2, 1, 0, 'admin', '2025-04-15 15:42:11', 'admin', '2025-04-15 15:42:11', '测试角色', 0);

-- ----------------------------
-- Table structure for ez_admin_role_dept_relation
-- ----------------------------
DROP TABLE IF EXISTS `ez_admin_role_dept_relation`;
CREATE TABLE `ez_admin_role_dept_relation`  (
  `id` bigint UNSIGNED NOT NULL COMMENT '主键ID',
  `role_id` bigint UNSIGNED NOT NULL COMMENT '角色ID',
  `dept_id` bigint UNSIGNED NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ez_admin_role_dept_relation
-- ----------------------------

-- ----------------------------
-- Table structure for ez_admin_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `ez_admin_role_menu_relation`;
CREATE TABLE `ez_admin_role_menu_relation`  (
  `id` bigint UNSIGNED NOT NULL COMMENT '主键ID',
  `role_id` bigint UNSIGNED NOT NULL COMMENT '角色ID',
  `menu_id` bigint UNSIGNED NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ez_admin_role_menu_relation
-- ----------------------------
INSERT INTO `ez_admin_role_menu_relation` VALUES (1912408964955668482, 1901525301556682754, 1912407916132245505);
INSERT INTO `ez_admin_role_menu_relation` VALUES (1912408964955668483, 1901525301556682754, 1912408705965764609);
INSERT INTO `ez_admin_role_menu_relation` VALUES (1912408964955668484, 1901525301556682754, 1909490924932939778);
INSERT INTO `ez_admin_role_menu_relation` VALUES (1912408964955668485, 1901525301556682754, 1909902055530905601);
INSERT INTO `ez_admin_role_menu_relation` VALUES (1912408964955668486, 1901525301556682754, 1909902213773606914);
INSERT INTO `ez_admin_role_menu_relation` VALUES (1912408964955668487, 1901525301556682754, 1909902275278880769);
INSERT INTO `ez_admin_role_menu_relation` VALUES (1912408964955668488, 1901525301556682754, 1909902335215484930);
INSERT INTO `ez_admin_role_menu_relation` VALUES (1912408964955668489, 1901525301556682754, 1909902393692471298);
INSERT INTO `ez_admin_role_menu_relation` VALUES (1912408964955668490, 1901525301556682754, 1909902443113955330);

-- ----------------------------
-- Table structure for ez_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `ez_admin_user`;
CREATE TABLE `ez_admin_user`  (
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `dept_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '部门ID',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户手机号码',
  `gender` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别【0 保密 1 男 2 女】',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `status` tinyint UNSIGNED NOT NULL DEFAULT 1 COMMENT '用户状态【0 禁用 1 正常】',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '描述信息',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除【0 正常 1 已删除】',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ez_admin_user
-- ----------------------------
INSERT INTO `ez_admin_user` VALUES (1901525301489573889, 1912398173066047489, 'admin', '$2a$10$uoxSqjKqP2NSZZp1Kz5R2uBt1Xnf4qv4KGsWp6nMa4WXN10/2dOPC', 'admin', '2417254000@qq.com', '13022647899', 1, NULL, 1, NULL, NULL, 'init', '2025-04-17 10:23:10', 'admin', '2025-04-17 16:45:35', '', 0);
INSERT INTO `ez_admin_user` VALUES (1912756304375750657, 1912398173066047489, 'test', '$2a$10$8OcxS0Ztalr0TwwYVTV0leNG6tazoZuE4fMVg0FKsKftKpA1gNzL6', 'test', NULL, NULL, 1, NULL, 1, NULL, NULL, 'admin', '2025-04-17 14:33:35', 'admin', '2025-04-17 14:33:35', '', 0);

-- ----------------------------
-- Table structure for ez_admin_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `ez_admin_user_role_relation`;
CREATE TABLE `ez_admin_user_role_relation`  (
  `id` bigint UNSIGNED NOT NULL COMMENT '主键ID',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `role_id` bigint UNSIGNED NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ez_admin_user_role_relation
-- ----------------------------
INSERT INTO `ez_admin_user_role_relation` VALUES (1901525301678317569, 1901525301489573889, 1901525301556682754);

SET FOREIGN_KEY_CHECKS = 1;
