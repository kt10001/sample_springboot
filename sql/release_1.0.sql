######################## 99资源客 版本1 sql #################

--模拟数据
drop table if exists mock_resp_data;
CREATE TABLE `mock_resp_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uri` varchar(128) NOT NULL COMMENT '请求的uri',
  `type` tinyint(4) NOT NULL COMMENT '返回数据类型 1-正常返回 2-异常返回',
  `response` text NOT NULL COMMENT 'mock返回结果',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 1-删除',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_uri` (`uri`,`type`) USING BTREE COMMENT 'uri索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='Mock返回数据表';
INSERT INTO `zyke`.`mock_resp_data`(`id`, `uri`, `type`, `response`, `is_deleted`, `create_at`) VALUES (1, '/zyk/a', 1, '{\"a\": 1}', 0, '2022-04-23 21:54:47');
INSERT INTO `zyke`.`mock_resp_data`(`id`, `uri`, `type`, `response`, `is_deleted`, `create_at`) VALUES (2, '/zyk/system/login', 1, '{\"token\": \"123456\"}', 1, '2022-04-29 09:40:07');

-- 新增user表
drop table if exists user;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `username` varchar(128) DEFAULT NULL COMMENT '用户名',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `login_time` datetime DEFAULT NULL COMMENT '最近一次登录时间',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
INSERT INTO `zyke`.`user`(`id`, `uuid`, `username`, `phone`, `email`, `password`, `login_time`, `is_deleted`, `create_at`, `update_at`) VALUES (1, 'a6fb081dfc24434cb5676486878b60d6', 'feikong', '13093323120', 'feikong@shouxin168.com', 'BcKq+puBy6SGxkPNd27hxg==', '2022-05-12 12:14:03', 0, '2022-05-02 20:55:45', '2022-05-12 12:14:02');

-- 广告位banner
drop table if exists advert_banner;
CREATE TABLE `advert_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型 0-首页弹窗',
  `link_type` tinyint(4) DEFAULT NULL COMMENT '链接类型 0-URL链接 1-产品详情 2-公众号全部页面',
  `link` varchar(128) DEFAULT NULL COMMENT '链接',
  `start_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `oss_url` varchar(255) DEFAULT NULL COMMENT '图片oss地址',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='广告banner';

-- 公告
drop table if exists announcement;
CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `link` varchar(255) DEFAULT NULL COMMENT '跳转链接',
  `receiver` varchar(128) DEFAULT NULL COMMENT '发布对象',
  `faber` varchar(128) DEFAULT NULL COMMENT '发布者',
  `fab_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '发布状态 0-未发布 1-已发布 2-已取消 3-发布失败',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='公告表';

-- 首页banner
drop table if exists index_banner;
CREATE TABLE `index_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `link_type` tinyint(4) DEFAULT NULL COMMENT '链接类型 0-URL链接\n1-产品详情\n2-公众号全部页面',
  `link` varchar(128) DEFAULT NULL COMMENT '链接',
  `start_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `rank_value` int(10) DEFAULT NULL COMMENT '排序值',
  `oss_url` varchar(255) DEFAULT NULL COMMENT '图片oss地址',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='首页banner';

-- manager
drop table if exists manager;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `parent_uuid` varchar(64) DEFAULT NULL COMMENT '上级uuid',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `ident_number` varchar(18) DEFAULT NULL COMMENT '身份证',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `wx_id` varchar(128) DEFAULT NULL COMMENT '微信号',
  `open_id` varchar(128) DEFAULT NULL COMMENT '微信open_id',
  `picture_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `login_time` datetime DEFAULT NULL COMMENT '最近一次登录时间',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_phone` (`phone`) USING BTREE COMMENT '手机号索引',
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='客户经理表';

--权限表
drop table if exists permission;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父id',
  `name` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `url` varchar(255) DEFAULT NULL COMMENT '接口',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='权限表';
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (1, 'c8723f05-ca15-11ec-9b33-0242ac110002', NULL, '会员规则', NULL, 0, '2022-05-02 20:44:19', '2022-05-02 20:46:10');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (2, 'e6231e51-ca15-11ec-9b33-0242ac110002', 'c8723f05-ca15-11ec-9b33-0242ac110002', '新增会员规则', '/zyk/vip/add', 0, '2022-05-02 20:46:30', '2022-05-04 17:27:49');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (3, '61b8f98a-cb93-11ec-9b33-0242ac110002', 'c8723f05-ca15-11ec-9b33-0242ac110002', '查看会员规则', '/zyk/vip/list', 0, '2022-05-04 18:18:17', '2022-05-04 18:18:43');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (4, '7d74f2f0-cc19-11ec-9b33-0242ac110002', 'c8723f05-ca15-11ec-9b33-0242ac110002', '编辑会员规则', '/zyk/vip/update', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (5, '60fa7d05-cc4c-11ec-9b33-0242ac110002', NULL, '公告', NULL, 0, '2022-05-05 16:21:59', '2022-05-05 16:21:59');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (6, '75aec7de-cc4c-11ec-9b33-0242ac110002', '60fa7d05-cc4c-11ec-9b33-0242ac110002', '查看公告', '/zyk/announcement/list', 0, '2022-05-05 16:22:05', '2022-05-05 16:22:33');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (7, '3d2086d8-cc73-11ec-9b33-0242ac110002', '60fa7d05-cc4c-11ec-9b33-0242ac110002', '新增公告', '/zyk/announcement/add', 0, '2022-05-05 20:59:55', '2022-05-05 21:00:05');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (8, '1473600f-ccdd-11ec-9b33-0242ac110002', '60fa7d05-cc4c-11ec-9b33-0242ac110002', '编辑公告', '/zyk/announcement/update', 0, '2022-05-06 09:41:00', '2022-05-06 09:41:15');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (9, 'dc9bca85-cd3b-11ec-9b33-0242ac110002', '60fa7d05-cc4c-11ec-9b33-0242ac110002', '发布公告', '/zyk/announcement/fab', 0, '2022-05-06 20:56:03', '2022-05-06 20:56:12');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (10, 'aa4730ae-cdd5-11ec-9b33-0242ac110002', '60fa7d05-cc4c-11ec-9b33-0242ac110002', '取消发布', '/zyk/announcement/cancel', 0, '2022-05-07 15:17:06', '2022-05-07 15:17:18');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (11, '655d339d-d024-11ec-9b33-0242ac110002', NULL, 'banner管理', NULL, 0, '2022-05-10 13:45:50', '2022-05-10 13:45:50');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (12, '57977197-d024-11ec-9b33-0242ac110002', '655d339d-d024-11ec-9b33-0242ac110002', '新增首页banner', '/zyk/admin/banner/index/add', 0, '2022-05-10 13:46:14', '2022-05-10 16:26:42');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (13, '9d67b0b6-d037-11ec-9b33-0242ac110002', '655d339d-d024-11ec-9b33-0242ac110002', '查看首页banner列表', '/zyk/admin/banner/index/list', 0, '2022-05-10 16:03:13', '2022-05-10 16:26:46');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (14, 'd82988b5-d03a-11ec-9b33-0242ac110002', '655d339d-d024-11ec-9b33-0242ac110002', '编辑首页banner', '/zyk/admin/banner/index/update', 0, '2022-05-10 16:26:22', '2022-05-10 16:26:52');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (15, 'f6fedcf9-d03a-11ec-9b33-0242ac110002', '655d339d-d024-11ec-9b33-0242ac110002', '删除首页banner', '/zyk/admin/banner/index/delete', 0, '2022-05-10 16:27:15', '2022-05-10 16:27:25');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (16, '1914ddfc-d042-11ec-9b33-0242ac110002', '655d339d-d024-11ec-9b33-0242ac110002', '新增广告banner', '/zyk/admin/banner/advert/add', 0, '2022-05-10 17:18:41', '2022-05-10 17:19:08');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (17, '317b64b4-d042-11ec-9b33-0242ac110002', '655d339d-d024-11ec-9b33-0242ac110002', '删除广告banner', '/zyk/admin/banner/advert/delete', 0, '2022-05-10 17:19:21', '2022-05-10 17:19:21');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (18, '4adb5da4-d042-11ec-9b33-0242ac110002', '655d339d-d024-11ec-9b33-0242ac110002', '编辑广告banner', '/zyk/admin/banner/advert/update', 0, '2022-05-10 17:19:44', '2022-05-10 17:19:44');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (19, '56a0004b-d042-11ec-9b33-0242ac110002', '655d339d-d024-11ec-9b33-0242ac110002', '查看广告banner列表', '/zyk/admin/banner/advert/list', 0, '2022-05-10 17:20:08', '2022-05-10 17:20:08');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (20, '1473600f-ccdd-11ec-9b33-0242ac110003', '60fa7d05-cc4c-11ec-9b33-0242ac110002', '删除公告', '/zyk/announcement/update', 0, '2022-05-06 09:41:00', '2022-05-06 09:41:15');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (21, 'faecd0f3-d1ea-11ec-9b33-0242ac110002', NULL, '产品管理', NULL, 0, '2022-05-06 09:41:00', '2022-05-06 09:41:15');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (22, '1d211552-d1eb-11ec-9b33-0242ac110002', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '新增产品', '/zyk/admin/product/add', 0, '2022-05-12 20:00:11', '2022-05-12 20:02:36');
INSERT INTO `zyke`.`permission`(`id`, `uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES (23, 'a38c89df-d1f0-11ec-9b33-0242ac110002', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '查看产品', '/zyk/admin/product/list', 0, '2022-05-12 20:40:07', '2022-05-12 20:40:22');
-- 角色表
drop table if exists role;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(128) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(64) DEFAULT NULL COMMENT '角色编码',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
INSERT INTO `zyke`.`role`(`id`, `uuid`, `name`, `code`, `is_deleted`, `create_at`, `update_at`) VALUES (1, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '开发', 'developer', 0, '2022-05-02 21:38:39', '2022-05-02 21:38:39');

-- role_permission
drop table if exists role_permission;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_uuid` varchar(64) DEFAULT NULL COMMENT '角色uuid',
  `permission_uuid` varchar(64) DEFAULT NULL COMMENT '权限uuid',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='角色权限表';
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (1, '1c7be48d-ca1d-11ec-9b33-0242ac110002', 'c8723f05-ca15-11ec-9b33-0242ac110002', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (2, '1c7be48d-ca1d-11ec-9b33-0242ac110002', 'e6231e51-ca15-11ec-9b33-0242ac110002', 0, '2022-05-02 21:40:04', '2022-05-02 21:40:04');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (3, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '61b8f98a-cb93-11ec-9b33-0242ac110002', 0, '2022-05-04 18:36:53', '2022-05-04 19:03:35');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (4, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '7d74f2f0-cc19-11ec-9b33-0242ac110002', 0, '2022-05-05 10:17:56', '2022-05-05 10:17:58');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (6, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '60fa7d05-cc4c-11ec-9b33-0242ac110002', 0, '2022-05-05 16:26:59', '2022-05-05 16:26:59');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (7, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '75aec7de-cc4c-11ec-9b33-0242ac110002', 0, '2022-05-05 16:27:09', '2022-05-05 16:27:09');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (8, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '3d2086d8-cc73-11ec-9b33-0242ac110002', 0, '2022-05-05 21:00:23', '2022-05-05 21:00:23');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (9, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '1473600f-ccdd-11ec-9b33-0242ac110002', 0, '2022-05-06 09:41:25', '2022-05-06 09:41:25');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (10, '1c7be48d-ca1d-11ec-9b33-0242ac110002', 'dc9bca85-cd3b-11ec-9b33-0242ac110002', 0, '2022-05-06 20:56:22', '2022-05-06 20:56:22');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (11, '1c7be48d-ca1d-11ec-9b33-0242ac110002', 'aa4730ae-cdd5-11ec-9b33-0242ac110002', 0, '2022-05-07 15:16:56', '2022-05-07 15:16:56');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (12, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '57977197-d024-11ec-9b33-0242ac110002', 0, '2022-05-10 13:45:10', '2022-05-10 13:45:10');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (13, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '655d339d-d024-11ec-9b33-0242ac110002', 0, '2022-05-10 13:47:59', '2022-05-10 13:47:59');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (14, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '9d67b0b6-d037-11ec-9b33-0242ac110002', 0, '2022-05-10 16:03:07', '2022-05-10 16:03:07');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (15, '1c7be48d-ca1d-11ec-9b33-0242ac110002', 'd82988b5-d03a-11ec-9b33-0242ac110002', 0, '2022-05-10 16:26:16', '2022-05-10 16:26:16');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (16, '1c7be48d-ca1d-11ec-9b33-0242ac110002', 'f6fedcf9-d03a-11ec-9b33-0242ac110002', 0, '2022-05-10 16:27:07', '2022-05-10 16:27:07');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (17, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '1914ddfc-d042-11ec-9b33-0242ac110002', 0, '2022-05-10 17:18:41', '2022-05-10 17:18:41');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (18, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '317b64b4-d042-11ec-9b33-0242ac110002', 0, '2022-05-10 17:19:21', '2022-05-10 17:19:21');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (19, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '4adb5da4-d042-11ec-9b33-0242ac110002', 0, '2022-05-10 17:19:44', '2022-05-10 17:19:44');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (20, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '56a0004b-d042-11ec-9b33-0242ac110002', 0, '2022-05-10 17:20:08', '2022-05-10 17:20:08');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (21, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '1473600f-ccdd-11ec-9b33-0242ac110003', 0, '2022-05-10 17:20:08', '2022-05-10 17:20:08');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (22, '1c7be48d-ca1d-11ec-9b33-0242ac110002', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', 0, '2022-05-10 17:20:08', '2022-05-10 17:20:08');
INSERT INTO `zyke`.`role_permission`(`id`, `role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (23, '1c7be48d-ca1d-11ec-9b33-0242ac110002', '1d211552-d1eb-11ec-9b33-0242ac110002', 0, '2022-05-10 17:20:08', '2022-05-10 17:20:08');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'a38c89df-d1f0-11ec-9b33-0242ac110002', 0, '2022-05-10 17:20:08', '2022-05-10 17:20:08');

-- search_log
drop table if exists search_log;
CREATE TABLE `search_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_uuid` varchar(64) DEFAULT NULL COMMENT '用户uuid',
  `product_name` varchar(64) DEFAULT NULL COMMENT '产品名称',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user` (`user_uuid`) USING BTREE COMMENT '用户索引';
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='产品搜索记录表';

-- user_msg
drop table if exists user_msg;
CREATE TABLE `user_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_uuid` varchar(64) DEFAULT NULL COMMENT '用户uuid',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `link` varchar(128) DEFAULT NULL COMMENT '链接',
  `status` tinyint(4) DEFAULT NULL COMMENT '0-未读 1-已读',
  `type` tinyint(4) DEFAULT NULL COMMENT '消息类型 0-系统通知 1-团队通知 2-业务通知',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user` (`user_uuid`) USING BTREE COMMENT '用户索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='用户通知表';

-- user_role
drop table if exists user_role;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_uuid` varchar(64) NOT NULL COMMENT '用户uuid',
  `role_uuid` varchar(128) NOT NULL COMMENT '角色uuid',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user` (`user_uuid`) USING BTREE COMMENT '用户索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';
INSERT INTO `zyke`.`user_role`(`id`, `user_uuid`, `role_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES (1, 'a6fb081dfc24434cb5676486878b60d6', '1c7be48d-ca1d-11ec-9b33-0242ac110002', 0, '2022-05-02 21:39:31', '2022-05-02 21:39:31');

-- user_vip
drop table if exists user_vip;
CREATE TABLE `user_vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_uuid` varchar(64) DEFAULT NULL COMMENT '用户uuid',
  `vip_uuid` varchar(64) DEFAULT NULL COMMENT '会员uuid',
  `expire_time` timestamp NULL DEFAULT NULL COMMENT '会员过期时间',
  `follower` int(5) DEFAULT null COMMENT '拉新数量',
  `be_follower` int(5) DEFAULT '0' COMMENT '已拉新数量',
  `status` tinyint(2) DEFAULT '0' COMMENT '是否领取 0-否 1-是',
  `is_recruit` tinyint(2) DEFAULT '0' COMMENT '是否被招募 0-否 1-是',
  `is_send` tinyint(2) DEFAULT '0' COMMENT '是否通知 0-否 1-是',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user` (`user_uuid`) USING BTREE COMMENT '用户索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='用户会员表';
INSERT INTO `zyke`.`user_vip`(`id`, `user_uuid`, `vip_uuid`, `expire_time`, `is_deleted`, `create_at`, `update_at`) VALUES (1, 'a6fb081dfc24434cb5676486878b60d6', 'a808a6337b624ed39c6aa10d9799fac5', NULL, 0, '2022-05-06 17:03:56', '2022-05-06 17:03:56');

-- vip
drop table if exists vip;
CREATE TABLE `vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `level` tinyint(2) DEFAULT NULL COMMENT '等级',
  `price` int(5) DEFAULT '0' COMMENT '价格',
  `rebate` decimal(3,2) DEFAULT NULL COMMENT '返佣比例',
  `parent_rebate` decimal(3,2) DEFAULT NULL COMMENT '上级返佣比例',
  `follower` int(5) DEFAULT '0' COMMENT '拉新数量',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='会员表';

-- product
drop table if exists product;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `full_name` varchar(128) DEFAULT NULL COMMENT '全称',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷',
  `company` varchar(64) DEFAULT NULL COMMENT '机构',
  `rank_value` int(10) DEFAULT NULL COMMENT '排序值',
  `amount` int(10) DEFAULT NULL COMMENT '额度',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo',
  `rate` varchar(64) DEFAULT NULL COMMENT '利率 多个利率,隔开',
  `repay_type` tinyint(4) DEFAULT NULL COMMENT '还款方式 0-等额本息 1-等额本金 2-等本等息 3-先息后本',
  `loan_month` varchar(32) DEFAULT NULL COMMENT '贷款周期，多个周期,隔开',
  `bill_type` tinyint(4) DEFAULT NULL COMMENT '结算方式 0-授信结算 1-放款结算',
  `link` varchar(512) DEFAULT NULL COMMENT '产品链接',
  `income_rate` decimal(6,5) DEFAULT NULL COMMENT '返佣比例',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 0-下架 1-上架',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-使用 1-删除',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='产品表';

-- 产品详情表
drop table if exists product_detail;
CREATE TABLE `product_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_uuid` varchar(64) DEFAULT NULL COMMENT '产品uuid',
  `area` varchar(64) DEFAULT NULL COMMENT '地区',
	content text DEFAULT NULL COMMENT '产品内容',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-使用 1-删除',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`product_uuid`) USING BTREE COMMENT '产品uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='产品详情表';

-- 产品动态表
drop table if exists product_msg;
CREATE TABLE `product_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_uuid` varchar(64) DEFAULT NULL COMMENT '产品uuid',
  `msg` varchar(255) DEFAULT NULL COMMENT '产品动态',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-使用 1-删除',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`product_uuid`) USING BTREE COMMENT '产品uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='产品动态表';


-- 新增数据
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'c630b982-d25f-11ec-9b33-0242ac110002');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`) VALUES ('c630b982-d25f-11ec-9b33-0242ac110002', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '编辑产品', '/zyk/admin/product/update');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'c630b982-d25f-11ec-9b33-0242ac110010');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`) VALUES ('c630b982-d25f-11ec-9b33-0242ac110010', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '发布产品', '/zyk/admin/product/fab');
alter table product modify column  repay_type  varchar(32) DEFAULT NULL COMMENT '还款方式 0-等额本息 1-等额本金 2-等本等息 3-先息后本';
alter table product add rate1 varchar(32) COMMENT '年化利率1' after rate;
alter table product add rate2 varchar(32) COMMENT '年化利率2' after rate1;
alter table product drop column rate;

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'c630b982-d25f-11ec-9b33-0242ac110003');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`) VALUES ('c630b982-d25f-11ec-9b33-0242ac110003', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '产品详情', '/zyk/admin/product/detail');

-- 新增信用卡产品表product_credit
drop table if exists product_credit;
CREATE TABLE `product_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `rank_value` int(10) DEFAULT NULL COMMENT '排序值',
  `name` varchar(64) DEFAULT NULL COMMENT '产品名称',
  `image` varchar(255) DEFAULT NULL COMMENT '行用卡图片',
  `company` varchar(64) DEFAULT NULL COMMENT '产品机构',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷 5-信用卡',
  `bill_type` tinyint(4) DEFAULT NULL COMMENT '结算方式0-首刷自动结算 1-核卡自动结算',
  `settlement_period` tinyint(4) DEFAULT NULL COMMENT '结算周期 0-日结',
  `settlement_rules` text COMMENT '结算规则',
  `link` varchar(512) DEFAULT NULL COMMENT '产品链接',
  `grade` varchar(32) DEFAULT NULL COMMENT '卡片等级',
  `back_money_ord` decimal(16,0) DEFAULT NULL COMMENT '返佣金额（普通会员）',
  `back_money_sup` decimal(16,0) DEFAULT NULL COMMENT '返佣金额（超级会员）',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 0-下架 1-上架',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-使用 1-删除',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='信用卡产品表';


-- 新增信用卡产品详细表product_credit_detail
drop table if exists product_credit_detail;
CREATE TABLE `product_credit_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_credit_uuid` varchar(64) DEFAULT NULL COMMENT '信用卡产品uuid',
  `area` varchar(64) DEFAULT NULL COMMENT '地区',
  `content` text COMMENT '信用卡产品内容',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-使用 1-删除',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='信用卡产品详细表';

-- 新增数据
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('kid29dir-70fc-0d3f-eb2f-7ba83e8720af', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '查看信用卡产品', '/zyk/admin/productCredit/list', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('cifs328w-oo90-w3e4-eb2f-7ba83e8720af', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '新增信用卡产品', '/zyk/admin/productCredit/add', 0, '2022-05-19 10:17:32', '2022-05-19 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('jjsi8910-xioe-34ue-eb2f-7ba83e8720af', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '信用卡产品详情', '/zyk/admin/productCredit/detail', 0, '2022-05-19 10:17:32', '2022-05-19 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('laei3849-ur32-1qmg-eb2f-7ba83e8720af', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '编辑信用卡产品', '/zyk/admin/productCredit/update', 0, '2022-05-19 10:17:32', '2022-05-19 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('yclui498-hhsa-46yr-eb2f-7ba83e8720af', 'faecd0f3-d1ea-11ec-9b33-0242ac110002', '发布信用卡产品', '/zyk/admin/productCredit/fab', 0, '2022-05-19 10:17:32', '2022-05-19 10:17:46');

-- 新增数据
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'kid29dir-70fc-0d3f-eb2f-7ba83e8720af', 0, '2022-05-19 11:39:48', '2022-05-19 11:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'cifs328w-oo90-w3e4-eb2f-7ba83e8720af', 0, '2022-05-19 11:39:48', '2022-05-19 11:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'jjsi8910-xioe-34ue-eb2f-7ba83e8720af', 0, '2022-05-19 11:39:48', '2022-05-19 11:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'laei3849-ur32-1qmg-eb2f-7ba83e8720af', 0, '2022-05-19 11:39:48', '2022-05-19 11:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'yclui498-hhsa-46yr-eb2f-7ba83e8720af', 0, '2022-05-19 11:39:48', '2022-05-19 11:39:50');


-- 新增表 model_card

drop table if exists model_card;

CREATE TABLE `model_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `rank_value` int(10) DEFAULT NULL COMMENT '排序值',
  `oss_url` varchar(255) DEFAULT NULL COMMENT '图片oss地址',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='名片模板';

INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('80721ee0-89e7-e85c-9d77-d9d531532bda', NULL, '名片模板管理', NULL, 0, '2022-05-02 20:44:19', '2022-05-02 20:46:10');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('67d2e975-8a7b-1886-eea8-7afe8069542a', '80721ee0-89e7-e85c-9d77-d9d531532bda', '查看名片模板列表', '/zyk/admin/card/list', 0, '2022-05-02 20:46:30', '2022-05-04 17:27:49');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('fcbea6e1-a7ef-33ea-5214-14cb7700b675', '80721ee0-89e7-e85c-9d77-d9d531532bda', '新增名片模板', '/zyk/admin/card/add', 0, '2022-05-04 18:18:17', '2022-05-04 18:18:43');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('1396bb40-2da9-9cac-1d2d-7e6d2b0a9d44', '80721ee0-89e7-e85c-9d77-d9d531532bda', '编辑名片模板', '/zyk/admin/card/update', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('b4bb371a-70fc-0d3f-eb2f-7ba83e8720af', '80721ee0-89e7-e85c-9d77-d9d531532bda', '删除名片模板', '/zyk/admin/card/delete', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '80721ee0-89e7-e85c-9d77-d9d531532bda', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '67d2e975-8a7b-1886-eea8-7afe8069542a', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'fcbea6e1-a7ef-33ea-5214-14cb7700b675', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '1396bb40-2da9-9cac-1d2d-7e6d2b0a9d44', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'b4bb371a-70fc-0d3f-eb2f-7ba83e8720af', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');


-- 新增表 card

drop table if exists card;

CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `position` varchar(64) DEFAULT NULL COMMENT '身份',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `wx_id` varchar(128) DEFAULT NULL COMMENT '微信号',
  `user_uuid` varchar(32) DEFAULT NULL COMMENT '工号',
  `temp_card_url` varchar(255) DEFAULT NULL COMMENT '名片模板地址',
  `picture_url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `code` varchar(255) DEFAULT NULL COMMENT '二维码',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='名片信息';


--
drop table if exists product_rule;
CREATE TABLE `product_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_uuid` varchar(64) DEFAULT NULL COMMENT '产品uuid',
  `name` varchar(128) DEFAULT NULL COMMENT '规则名称',
  `code` varchar(64) DEFAULT NULL COMMENT '规则编码',
  `symbol` varchar(8) DEFAULT NULL COMMENT '符号',
  `value` varchar(128) DEFAULT NULL COMMENT '值',
  `default_value` varchar(128) DEFAULT NULL COMMENT '默认值',
  `type` varchar(64) DEFAULT NULL COMMENT '类型 PERSON-个人 BUSINESS-企业 CREDIT-征信 TAX-税票',
  `data_type` varchar(32) DEFAULT NULL COMMENT '类型 PERSON-个人 BUSINESS-企业 CREDIT-征信 TAX-税票',
  `expression` varchar(128) DEFAULT NULL COMMENT '计算公式',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`product_uuid`) USING BTREE COMMENT '产品uuid索引',
  KEY `idx_code` (`code`) USING BTREE COMMENT '规则code索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='产品规则表';

--
drop table if exists rule;
CREATE TABLE `rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `type` varchar(64) DEFAULT NULL COMMENT '类型 PERSON-个人 BUSINESS-企业 CREDIT-征信 TAX-税票',
  `data_type` varchar(16) DEFAULT NULL COMMENT '数据类型 STRING-输入值 SINGLE-单选 MULTIPLE-多选',
  `data_value` varchar(16) DEFAULT NULL COMMENT '数据值',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='规则表';


-- 新增表 config_property

drop table if exists config_property;

CREATE TABLE `config_property` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `config_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置名称',
  `config_value` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '配置的值',
  `config_type` tinyint(2) DEFAULT NULL COMMENT '0-String 1-Integer 2-JsonArray 3-JsonObject 4-List',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `comment` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '此配置备注信息',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `config_key` (`config_key`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='配置属性表';


--
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('6个月内历史逾期次数', 'm6DueTimes', 'CREDIT', 'STRING', NULL);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('12个月内历史逾期次数', 'm12DueTimes', 'CREDIT', 'STRING', NULL);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('24个月内历史逾期次数', 'm24DueTimes', 'CREDIT', 'STRING', NULL);

INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('6个月内历史逾期时长', 'm6DueDays', 'CREDIT', 'STRING', NULL);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('12个月内历史逾期时长', 'm12DueDays', 'CREDIT', 'STRING', NULL);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('24个月内历史逾期时长', 'm24DueDays', 'CREDIT', 'STRING', NULL);

INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('3个月内征信查询次数', 'm3QueryTimes', 'CREDIT', 'STRING', NULL);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('6个月内征信查询次数', 'm6QueryTimes', 'CREDIT', 'STRING', NULL);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('12个月内征信查询次数', 'm12QueryTimes', 'CREDIT', 'STRING', NULL);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('24个月内征信查询次数', 'm24QueryTimes', 'CREDIT', 'STRING', NULL);

INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('信用贷款额度', 'loanAmount', 'CREDIT', 'STRING', NULL);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('信用卡额度最大使用率', 'loanUse', 'CREDIT', 'STRING', NULL);

INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('申请人身份', 'ident', 'BUSINESS', 'MULTIPLE', '企业法人,个体工商户,公司股东');
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('股份比例', 'share', 'BUSINESS', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('申请人最小年龄', 'ageMin', 'BUSINESS', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('申请人最大年龄', 'ageMax', 'BUSINESS', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('企业实际成立时长', 'bussAge', 'BUSINESS', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('企业缴纳社保人数', 'bussPersonNum', 'BUSINESS', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('企业注册资金实缴', 'bussMoney', 'BUSINESS', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('最近法人变更时长', 'bussFrTime', 'BUSINESS', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('月流水', 'bussTrade', 'BUSINESS', 'STRING', null);


INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('近12月有效开票月份', 'taxKpMonth', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('近12月有效开票对象', 'taxKpIns', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('连续纳税时长', 'taxTime', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('连续开票时长', 'taxKp', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('企业纳税欠缴次数', 'taxQjNum', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('企业纳税逾期次数', 'taxDueNum', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('12月内开票金额总计', 'taxM12KpMoney', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('24月内开票金额总计', 'taxM24KpMoney', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('12月内纳税额缴纳总计', 'taxM12JsMoney', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('24月内纳税额缴纳总计', 'taxM24JsMoney', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('近12个月应税销售额（应纳税、税前）', 'taxM12SqMoney', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('12月内月均应税销售收入', 'taxM12YjMoney', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('24月内月均应税销售收入', 'taxM24YjMoney', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('近3个月销售额同比下滑', 'taxM3Xh', 'TAX', 'STRING', null);
INSERT INTO `zyke`.`rule`(`name`, `code`, `type`, `data_type`, `data_value`)
VALUES ('近12个月申报经营收入', 'taxM12SbMoney', 'TAX', 'STRING', null);

--
drop table if exists match_log;
CREATE TABLE `match_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '客户名称',
  `type` varchar(255) DEFAULT NULL COMMENT '产品类型 person/business',
  `amount` varchar(16) DEFAULT NULL COMMENT '产品额度',
  `num` int(11) DEFAULT NULL COMMENT '产品数量',
  `detail` text COMMENT '产品列表',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引',
  KEY `idx_user` (`manager_uuid`) USING BTREE COMMENT '用户索引'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='匹配记录表';


-- 金刚区

drop table if exists transform_area;

CREATE TABLE `transform_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `status` tinyint(4) DEFAULT NULL COMMENT '显示状态 0-隐藏 1-显示',
  `rank_value` int(10) DEFAULT NULL COMMENT '排序值',
  `link` varchar(128) DEFAULT NULL COMMENT '跳转链接',
  `icon_url` varchar(255) DEFAULT NULL COMMENT 'icon图片地址',
  `corner_url` varchar(255) DEFAULT NULL COMMENT '角标图片地址',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='金刚区';

INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('90866b3b-93dd-6dde-ddfa-0ddc1f24ef1e', NULL, '金刚区管理', NULL, 0, '2022-05-02 20:44:19', '2022-05-02 20:46:10');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('db076c3e-9d09-5822-2a8f-55584357972e', '90866b3b-93dd-6dde-ddfa-0ddc1f24ef1e', '查看金刚区列表', '/zyk/admin/transformArea/list', 0, '2022-05-02 20:46:30', '2022-05-04 17:27:49');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('4a074f96-cd76-8918-e031-693f84c998cd', '90866b3b-93dd-6dde-ddfa-0ddc1f24ef1e', '新增金刚区', '/zyk/admin/transformArea/add', 0, '2022-05-04 18:18:17', '2022-05-04 18:18:43');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('3f7f5a93-e867-441c-b241-f43d312b0f8d', '90866b3b-93dd-6dde-ddfa-0ddc1f24ef1e', '编辑金刚区', '/zyk/admin/transformArea/update', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('2c21ab6d-1ce6-22ff-d4e9-2ff173327d23', '90866b3b-93dd-6dde-ddfa-0ddc1f24ef1e', '删除金刚区', '/zyk/admin/transformArea/delete', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '90866b3b-93dd-6dde-ddfa-0ddc1f24ef1e', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'db076c3e-9d09-5822-2a8f-55584357972e', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '4a074f96-cd76-8918-e031-693f84c998cd', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '3f7f5a93-e867-441c-b241-f43d312b0f8d', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '2c21ab6d-1ce6-22ff-d4e9-2ff173327d23', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');


INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('dd8525b3-c20f-4624-ad8c-fa734ecc9f06', NULL, '角色管理', NULL, 0, '2022-05-02 20:44:19', '2022-05-02 20:46:10');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('e537888d-044f-547f-642a-b18c6ab6882e', 'dd8525b3-c20f-4624-ad8c-fa734ecc9f06', '查看角色管理列表', '/zyk/admin/role/list', 0, '2022-05-02 20:46:30', '2022-05-04 17:27:49');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('6d0b7a17-8759-3cd4-32f1-e4cd57d8b496', 'dd8525b3-c20f-4624-ad8c-fa734ecc9f06', '新增角色', '/zyk/admin/role/add', 0, '2022-05-04 18:18:17', '2022-05-04 18:18:43');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('d182c653-8eba-3363-4c5c-3034767d3c4d', 'dd8525b3-c20f-4624-ad8c-fa734ecc9f06', '编辑角色', '/zyk/admin/role/update', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('020f78ee-1274-adf4-33bf-3f4498ac7043', 'dd8525b3-c20f-4624-ad8c-fa734ecc9f06', '删除角色', '/zyk/admin/role/delete', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('188da0e8-2e2e-efd5-0bb7-1681a3e66375', 'dd8525b3-c20f-4624-ad8c-fa734ecc9f06', '查看角色详情', '/zyk/admin/role/detail', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'dd8525b3-c20f-4624-ad8c-fa734ecc9f06', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'e537888d-044f-547f-642a-b18c6ab6882e', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '6d0b7a17-8759-3cd4-32f1-e4cd57d8b496', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'd182c653-8eba-3363-4c5c-3034767d3c4d', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '020f78ee-1274-adf4-33bf-3f4498ac7043', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '188da0e8-2e2e-efd5-0bb7-1681a3e66375', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');

INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('17b0aa99-7669-5eb2-4f2d-43649ae2f300', NULL, '用户管理', NULL, 0, '2022-05-02 20:44:19', '2022-05-02 20:46:10');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('882d5dac-6e3a-1b87-fdf8-52a0316f1518', '17b0aa99-7669-5eb2-4f2d-43649ae2f300', '查看用户管理列表', '/zyk/admin/user/list', 0, '2022-05-02 20:46:30', '2022-05-04 17:27:49');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('dab7cfe2-bdf4-73ff-7539-3bb71283409b', '17b0aa99-7669-5eb2-4f2d-43649ae2f300', '新增用户', '/zyk/admin/user/add', 0, '2022-05-04 18:18:17', '2022-05-04 18:18:43');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('f8fe627b-1e3a-ffed-2d73-ed1b3545fc9c', '17b0aa99-7669-5eb2-4f2d-43649ae2f300', '编辑用户', '/zyk/admin/user/update', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('7271ffaf-e1d0-63b7-b04f-03d50cc3b5f2', '17b0aa99-7669-5eb2-4f2d-43649ae2f300', '删除用户', '/zyk/admin/user/delete', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('81a32657-2ffb-7912-eee1-2b926f28ded9', '17b0aa99-7669-5eb2-4f2d-43649ae2f300', '查看用户详情', '/zyk/admin/user/detail', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('f1bd6ca0-7a87-d07b-0e4a-7245e5d6c6ba', '17b0aa99-7669-5eb2-4f2d-43649ae2f300', '重置用户密码', '/zyk/admin/user/resetPassword', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '17b0aa99-7669-5eb2-4f2d-43649ae2f300', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '882d5dac-6e3a-1b87-fdf8-52a0316f1518', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'dab7cfe2-bdf4-73ff-7539-3bb71283409b', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'f8fe627b-1e3a-ffed-2d73-ed1b3545fc9c', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '7271ffaf-e1d0-63b7-b04f-03d50cc3b5f2', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '81a32657-2ffb-7912-eee1-2b926f28ded9', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'f1bd6ca0-7a87-d07b-0e4a-7245e5d6c6ba', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');


-- 产品收藏

drop table if exists manager_product;

CREATE TABLE `manager_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `manager_uuid` varchar(64) NOT NULL COMMENT '客户经理uuid',
  `product_uuid` varchar(128) NOT NULL COMMENT '产品uuid',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user` (`manager_uuid`) USING BTREE COMMENT '用户索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='产品收藏表';

-- 产品通过率查询记录表
drop table if exists pass_log;
CREATE TABLE `pass_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `pass` varchar(255) DEFAULT NULL COMMENT '查询记录',
  `num` int(11) DEFAULT NULL COMMENT '其他产品数量',
  `detail` text COMMENT '查询结果详情',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user` (`manager_uuid`) USING BTREE COMMENT '用户索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='产品通过率查询记录表';

-- 提现
drop table if exists contract;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ident_number` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `contract_id` varchar(64) DEFAULT NULL COMMENT '合同id',
  `template_id` varchar(64) DEFAULT NULL COMMENT '合同模板id',
  `file` varchar(255) DEFAULT NULL COMMENT '合同文件',
  `status` tinyint(4) DEFAULT NULL COMMENT '签署状态 1 - 待签约（员工已同步，但未发起签约） 2 - 签约文件生成中（用户已确认签署，合同文件正在生成，此状态可发起提现） 3 - 签约完成 （用户已签约，签约合同生成完成）',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_contract` (`contract_id`) USING BTREE COMMENT '合同索引',
  UNIQUE KEY `idx_ident` (`ident_number`) USING BTREE COMMENT '身份证索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='合同表'

drop table if exists manager_income;
CREATE TABLE `manager_income` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `request_id` varchar(64) DEFAULT NULL COMMENT '提现请求id',
  `status` varchar(16) DEFAULT NULL COMMENT '状态(20:成功 30:失败)',
  `fail_reason` varchar(255) DEFAULT NULL COMMENT '失败原因',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `amount` decimal(10,3) DEFAULT NULL COMMENT '提现金额',
  `current_real_wage` decimal(10,3) DEFAULT NULL COMMENT '实发金额',
  `current_tax` decimal(10,3) DEFAULT NULL COMMENT '当次缴纳个税 （算税方式为标准时个税）',
  `current_manage_fee` decimal(10,3) DEFAULT NULL COMMENT '当次提现管理费 （算税方式为标准时管理费）',
  `current_add_tax` decimal(10,3) DEFAULT NULL COMMENT '当次提现附加税（算税方式为标准时附加税）',
  `current_add_value_tax` decimal(10,3) DEFAULT NULL COMMENT '当次提现增值税（算税方式为标准时增值税）',
  `identity` varchar(32) DEFAULT NULL COMMENT '身份证号码',
  `bankName` varchar(32) DEFAULT NULL COMMENT '银行名称',
  `bankAccount` varchar(32) DEFAULT NULL COMMENT '银行卡',
  `dateTime` varchar(32) DEFAULT NULL COMMENT '申请时间(yyyyMMddHHmmss)',
  `payTime` varchar(32) DEFAULT NULL COMMENT '实际付款时间(yyyyMMddHHmmss)',
  `remark` varchar(255) DEFAULT NULL COMMENT '单据描叙',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`manager_uuid`) USING BTREE COMMENT 'uuid'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='客户经理提现记录表'

drop table if exists bankcard;
CREATE TABLE `bankcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `ident_number` varchar(32) DEFAULT NULL COMMENT '身份证',
  `bankcard` varchar(32) DEFAULT NULL COMMENT '银行卡号',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_bankcard` (`ident_number`,`bankcard`) USING BTREE COMMENT '银行卡',
  KEY `idx_ident` (`ident_number`) USING BTREE COMMENT '身份证'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='银行卡表';

-- 进件表
drop table if exists incoming;

CREATE TABLE `incoming` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT '进件uuid',
  `product_name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `product_company` varchar(255) DEFAULT NULL COMMENT '产品机构',
  `un_user_name` varchar(255) DEFAULT NULL COMMENT '客户名字',
  `manager_name` varchar(255) DEFAULT NULL COMMENT '客户经理名字',
  `un_user_type` tinyint(4) DEFAULT NULL COMMENT '用户身份',
  `settlement_type` tinyint(4) DEFAULT NULL COMMENT '结算类型 0-授信结算 1-放款结算 2-首刷自动结算 3-核卡自动结算',
  `product_type` tinyint(4) DEFAULT NULL COMMENT '类型 0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷 5-信用卡',
  `progress` tinyint(4) DEFAULT NULL COMMENT '业务进度 0 贷款-已申请 | 1 贷款-授信中 |2 贷款-审批未通过 |3 贷款-授信通过 |4 贷款-已提款| 5信用卡-待审核 |6 信用卡-审核不通过| 7 信用卡-审核已通过',
  `income_rate` decimal(8,6) DEFAULT NULL COMMENT '返佣比例',
  `vip_rate` decimal(8,6) DEFAULT '0.000000' COMMENT '会员返佣',
  `settlement_amount` decimal(32,2) DEFAULT '0.00' COMMENT '总结算金额',
  `settlement_status` tinyint(4) DEFAULT '0' COMMENT '结算状态 0-未结算 1-已结算',
  `un_user_uuid` varchar(64) DEFAULT NULL COMMENT '客户uuid',
  `product_uuid` varchar(64) DEFAULT NULL COMMENT '产品uuid',
  `manager_uuid` varchar(11) DEFAULT NULL COMMENT '客户经理id',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `apply_at` datetime DEFAULT NULL COMMENT '申请时间',
  `credit_at` datetime DEFAULT NULL COMMENT '授信时间',
  `loan_at` datetime DEFAULT NULL COMMENT '放款时间',
  `settlement_at` datetime DEFAULT NULL COMMENT '结算时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='进件表';


-- 用户表(客户经理的用户)
drop table if exists un_user;
CREATE TABLE `un_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT '用户uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `id_no` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `type` tinyint(2) DEFAULT NULL COMMENT '用户类型 0-企业用户 1-个人用户',
  `company_name` varchar(255) DEFAULT NULL COMMENT '企业名称',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户表（客户经理的用户）';
-- 新增数据
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('oqutbf38-clb8-java-eb2f-7ba83e8720af', NULL , '进件管理', NULL , 0, '2022-05-23 10:17:32', '2022-05-23 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('3kfnh8ir-90it-ciot-eb2f-7ba83e8720af', 'oqutbf38-clb8-java-eb2f-7ba83e8720af', '查看进件列表', '/zyk/admin/incoming/list', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('cy64vloa-xy76-0pqa-eb2f-7ba83e8720af', 'oqutbf38-clb8-java-eb2f-7ba83e8720af', '编辑进件信息', '/zyk/admin/incoming/update', 0, '2022-05-19 10:17:32', '2022-05-19 10:17:46');

-- 新增数据
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'oqutbf38-clb8-java-eb2f-7ba83e8720af', 0, '2022-05-23 11:39:48', '2022-05-23 11:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '3kfnh8ir-90it-ciot-eb2f-7ba83e8720af', 0, '2022-05-23 11:39:48', '2022-05-23 11:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'cy64vloa-xy76-0pqa-eb2f-7ba83e8720af', 0, '2022-05-23 11:39:48', '2022-05-23 11:39:50');

INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('ja3x8nrt-cimn-aasd-cftu-7ba83e8720af', NULL , '客户管理', NULL , 0, '2022-05-26 10:17:32', '2022-05-26 10:17:46');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'ja3x8nrt-cimn-aasd-cftu-7ba83e8720af', 0, '2022-05-26 11:39:48', '2022-05-26 11:39:50');

-- 进件结算表
drop table if exists settlement;
CREATE TABLE `settlement` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT '结算uuid',
  `credit_amount` decimal(16,0) DEFAULT '0' COMMENT '授信金额',
  `loan_amount` decimal(16,0) DEFAULT '0' COMMENT '放款金额',
  `settlement_amount` decimal(16,2) DEFAULT '0.00' COMMENT '结算金额',
  `progress` tinyint(4) DEFAULT NULL COMMENT '业务进度 0 贷款-已申请 | 1 贷款-授信中 |2 贷款-审批未通过 |3 贷款-授信通过 |4 贷款-已提款| 5信用卡-待审核 |6 信用卡-审核不通过| 7 信用卡-审核已通过',
  `settlement_type` tinyint(4) DEFAULT NULL COMMENT '结算类型 0-授信结算 1-放款结算 2-首刷自动结算 3-核卡自动结算',
  `settlement_status` tinyint(4) DEFAULT NULL COMMENT '结算状态 0-未结算 1-已结算',
  `incoming_uuid` varchar(64) DEFAULT NULL COMMENT '进件uuid',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注失败原因',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='进件放款表';

-- 入账表
drop table if exists manager_entry;
CREATE TABLE `manager_entry` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT '单号',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `product_uuid` varchar(64) DEFAULT NULL COMMENT '产品uuid',
  `amount` decimal(10,3) DEFAULT NULL COMMENT '入账金额',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='入账表';



drop table if exists un_user_follow_log;
CREATE TABLE `un_user_follow_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `un_user_uuid` varchar(64) DEFAULT NULL COMMENT '客户uuid',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `comment` varchar(256) DEFAULT NULL COMMENT '跟进内容',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`un_user_uuid`,`manager_uuid`) USING BTREE COMMENT '客户和客户经理索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='用户跟进历史表';


drop table if exists manager_freeze_log;
CREATE TABLE `manager_freeze_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT 'manager_uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `operator` varchar(18) DEFAULT NULL COMMENT '操作者',
  `freeze_time` varchar(32) DEFAULT NULL COMMENT '冻结时间',
  `freeze_reason` varchar(255) DEFAULT NULL COMMENT '冻结原因',
  `un_freeze_time` varchar(32) DEFAULT NULL COMMENT '解冻时间',
  `un_freeze_reason` varchar(255) DEFAULT NULL COMMENT '解冻原因',
  `type` tinyint(2) DEFAULT NULL COMMENT '操作类型 1-冻结 0-解冻',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_manager_uuid` (`manager_uuid`) USING BTREE COMMENT 'manager_uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='冻结历史表';

INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('e753e4b1-6425-37ca-35d1-92d57a924358', NULL, '客户经理管理', NULL, 0, '2022-05-02 20:44:19', '2022-05-02 20:46:10');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('61ba16b3-d95a-8669-fd53-514ec3634cfd', 'e753e4b1-6425-37ca-35d1-92d57a924358', '查看客户经理列表', '/zyk/admin/manager/list', 0, '2022-05-02 20:46:30', '2022-05-04 17:27:49');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('f61b7f70-1a29-c376-44b2-1adf7470525a', 'e753e4b1-6425-37ca-35d1-92d57a924358', '冻结解冻客户经理', '/zyk/admin/manager/freeze', 0, '2022-05-04 18:18:17', '2022-05-04 18:18:43');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('36c3c219-9169-ebe0-e018-baf0c2decab5', 'e753e4b1-6425-37ca-35d1-92d57a924358', '查看冻结历史列表', '/zyk/admin/manager/freezeList', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'e753e4b1-6425-37ca-35d1-92d57a924358', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '61ba16b3-d95a-8669-fd53-514ec3634cfd', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'f61b7f70-1a29-c376-44b2-1adf7470525a', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '36c3c219-9169-ebe0-e018-baf0c2decab5', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');


drop table if exists account_log;

CREATE TABLE `account_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` varchar(64) DEFAULT NULL COMMENT '订单号',
  `name` varchar(32) DEFAULT NULL COMMENT '客户经理姓名',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `type` tinyint(4) DEFAULT NULL COMMENT '0税务付费1会员充值',
  `money` decimal(10, 2) DEFAULT NULL COMMENT '金额',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='入账记录表';

INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('3e78a2df-6697-a32b-24d8-010619b3fe44', NULL, '入账管理', NULL, 0, '2022-05-02 20:44:19', '2022-05-02 20:46:10');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('cf7592e7-8d4e-5574-a423-c12cd1869c26', '3e78a2df-6697-a32b-24d8-010619b3fe44', '查看入账历史列表', '/zyk/admin/account/list', 0, '2022-05-02 20:46:30', '2022-05-04 17:27:49');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '3e78a2df-6697-a32b-24d8-010619b3fe44', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'cf7592e7-8d4e-5574-a423-c12cd1869c26', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');


-- 字段变更
alter table product add vip_a_rate decimal(5, 3) default 0 comment '普通会员返佣' after income_rate;
alter table product add vip_b_rate decimal(5, 3) default 0 comment '普通会员返佣' after vip_a_rate;
alter table vip drop column rebate;

-- 新增二维码参数表
drop table if exists qr_code;
CREATE TABLE `qr_code` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `context` text COMMENT '内容',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='二维码参数表';

-- 税票记录表
drop table if exists tax_bill_journal;
CREATE TABLE `tax_bill_journal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '客户姓名',
  `license_num` varchar(64) DEFAULT NULL COMMENT '统一社会信用代码',
  `tax_msg` varchar(255) DEFAULT NULL COMMENT '税票信息',
  `credit_level` varchar(32) DEFAULT NULL COMMENT '纳税等级',
  `fp_prev12mths_mths_of_amt_eq0` int(11) DEFAULT NULL COMMENT '近12月有效开票月份',
  `fp_first12mths_supplier` int(11) DEFAULT NULL COMMENT '近12月有效开票对象',
  `fp_maxbilldttd_tmspan` int(11) DEFAULT NULL COMMENT '连续开票时长',
  `cnt_of_pending_taxarrearcase` int(11) DEFAULT NULL COMMENT '企业纳税欠缴次数',
  `fp_prev12mths_tot_amt` decimal(11, 2) DEFAULT NULL COMMENT '12月内开票金额总计',
  `tax_ppev12mths_tax_paid` decimal(11, 2) DEFAULT NULL COMMENT '12月内纳税额缴纳总计',
  `tax_prev12mths_tax_payable` decimal(11, 2) DEFAULT NULL COMMENT '近12个月应税销售额',
  `tax_prev12mths_income` decimal(11, 2) DEFAULT NULL COMMENT '近12个月申报经营收入',
  `expire_time` varchar(64) DEFAULT NULL COMMENT '过期时间',
  `status` tinyint(2) DEFAULT '0' COMMENT '采集状态 0-未采集 1-采集中 2-采集完成 3-调用完成',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user` (`manager_uuid`) USING BTREE COMMENT '用户索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='税票记录表';

drop table if exists wx_recharge_journal;
CREATE TABLE `wx_recharge_journal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `out_trade_no` varchar(64) DEFAULT NULL COMMENT '商家订单号',
  `transaction_id` varchar(64) DEFAULT NULL COMMENT '微信订单号',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `manager_name` varchar(64) DEFAULT NULL COMMENT '客户经理姓名',
  `status` tinyint(4) DEFAULT '0' COMMENT '0未支付1支付成功2支付失败',
  `type` tinyint(4) DEFAULT NULL COMMENT '0税务付费1会员充值',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='微信支付记录表';


####################### end #################################