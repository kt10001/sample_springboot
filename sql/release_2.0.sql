################### v2.0 sql ###################

-- vip表字段变更
alter table vip drop column follower;
alter table vip drop column parent_rebate;
alter table vip drop column price;

alter table vip add price_m int(5) DEFAULT 0 comment '月卡金额' after level;
alter table vip add price_hy int(5) DEFAULT 0 comment '半年卡金额' after price_m;
alter table vip add price_y int(5) DEFAULT 0 comment '年卡金额' after price_hy;

-- 新增经理等级表
drop table if exists level;
CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `level` tinyint(2) DEFAULT NULL COMMENT '等级',
  `income_amount` int(5) DEFAULT '0' COMMENT '进件数',
  `member_amount` int(5) DEFAULT '0' COMMENT '团队人数',
  `vip_amount` int(5) DEFAULT '0' COMMENT '会员人数',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='经理等级表';

-- product表 添加字段
alter table product add level_a_rate decimal(8,5) DEFAULT 0 comment '出师奖' after vip_b_rate;
alter table product add level_b_rate decimal(8,5) DEFAULT 0 comment '越级奖' after level_a_rate;

-- user_vip表 添加字段
alter table user_vip drop column follower;
alter table user_vip drop column be_follower;
alter table user_vip drop column is_recruit;
alter table user_vip drop column is_send;

alter table user_vip add type tinyint(2) DEFAULT '0' comment '是否终身0否1是' after vip_uuid;

-- config_property表 添加数据
INSERT INTO `zyke`.`config_property`(`config_key`, `config_value`, `config_type`, `is_deleted`, `comment`, `create_at`, `update_at`) VALUES ('eventDate', '2023-06-23 23:59:59', 0, 0, '活动截止日期', '2022-06-24 14:55:06', NULL);


-- 新增海报类型表
drop table if exists poster_type;
CREATE TABLE `poster_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) DEFAULT NULL COMMENT '海报类型名',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-使用 1-删除',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='海报类型表';

-- 新增海报表
drop table if exists poster;
CREATE TABLE `poster` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT '海报uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '海报名称',
  `poster_type_id` int(11) DEFAULT NULL COMMENT '海报类型id',
  `product_uuid` varchar(64) DEFAULT NULL COMMENT '关联产品uuid',
  `rank_value` int(10) DEFAULT NULL COMMENT '排序值',
  `image` varchar(255) DEFAULT NULL COMMENT '图片',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态 0-下架 1-上架',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0-使用 1-删除',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='海报表';

--新增权限
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('ksor40kd-kk9a-oawi-24d8-847269b3fe44', NULL, '海报配置', NULL, 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('nxueys89-shha-17sy-soru-0qusd1869c26', 'ksor40kd-kk9a-oawi-24d8-847269b3fe44', '新增海报', '/zyk/admin/poster/addPosterType', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('iiiis783-12sd-siad-28du-0qusd186lsia', 'ksor40kd-kk9a-oawi-24d8-847269b3fe44', '编辑海报', '/zyk/admin/poster/updatePosterType', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('s2j4j3l5-1ua7-ao82-ap05-0qu29fuwlsia', 'ksor40kd-kk9a-oawi-24d8-847269b3fe44', '删除海报', '/zyk/admin/poster/delPosterType', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('3id90fv9-x0s9-ap94-kfi4-lvie9fuw93ud', 'ksor40kd-kk9a-oawi-24d8-847269b3fe44', '查询海报', '/zyk/admin/poster/queryPosterType', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('as12df34-gj57-01ki-ghui-lvie90xkisud', 'ksor40kd-kk9a-oawi-24d8-847269b3fe44', '发布海报', '/zyk/admin/poster/fab', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'ksor40kd-kk9a-oawi-24d8-847269b3fe44', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'nxueys89-shha-17sy-soru-0qusd1869c26', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'iiiis783-12sd-siad-28du-0qusd186lsia', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 's2j4j3l5-1ua7-ao82-ap05-0qu29fuwlsia', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '3id90fv9-x0s9-ap94-kfi4-lvie9fuw93ud', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'as12df34-gj57-01ki-ghui-lvie90xkisud', 0, '2022-06-08 14:44:19', '2022-06-08 14:44:19');



-- 新增文案类型表
drop table if exists copywriting_type;
CREATE TABLE `copywriting_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) DEFAULT NULL COMMENT '文案类型名',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0-使用 1-删除',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='文案类型表';

-- 新增文案表
drop table if exists copywriting;
CREATE TABLE `copywriting` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `rank_value` int(10) DEFAULT NULL COMMENT '排序值',
  `name` varchar(255) DEFAULT NULL COMMENT '文案名称',
  `content` text COMMENT '文案内容',
  `copywriting_type_id` int(11) DEFAULT NULL COMMENT '文案类型id',
  `product_uuid` varchar(64) DEFAULT NULL COMMENT '关联产品uuid',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态 0-下架 1-上架',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-使用 1-删除',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='文案表';

-- 新增文案图片表
drop table if exists copywriting_image;
CREATE TABLE `copywriting_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `image` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `copywriting_uuid` varchar(64) DEFAULT NULL COMMENT '文案uuid',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='文案关联图片表';

--新增权限
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('73c4bc28-aac6-4b2e-9973-9cf9ffd45c8c', NULL, '文案配置', NULL, 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('51da1576-d6bc-4508-a577-bc0ad5cc9061', '73c4bc28-aac6-4b2e-9973-9cf9ffd45c8c', '新增文案', '/zyk/admin/Copywriting/addCopywritingType', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('b50891a8-57c5-4018-8794-eec2210593f1', '73c4bc28-aac6-4b2e-9973-9cf9ffd45c8c', '编辑文案', '/zyk/admin/Copywriting/updateCopywritingType', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('c3bf19f9-df23-47f8-8645-fb8f3207ba1f', '73c4bc28-aac6-4b2e-9973-9cf9ffd45c8c', '查询文案', '/zyk/admin/Copywriting/queryCopywritingType', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('a0bdb049-498d-43d8-beff-e132feb014b0', '73c4bc28-aac6-4b2e-9973-9cf9ffd45c8c', '删除文案', '/zyk/admin/Copywriting/delCopywritingType', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('db7adebd-ceaf-4c63-b2c2-56ca3fa50747', '73c4bc28-aac6-4b2e-9973-9cf9ffd45c8c', '发布文案', '/zyk/admin/Copywriting/fab', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '73c4bc28-aac6-4b2e-9973-9cf9ffd45c8c', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '51da1576-d6bc-4508-a577-bc0ad5cc9061', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'b50891a8-57c5-4018-8794-eec2210593f1', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'c3bf19f9-df23-47f8-8645-fb8f3207ba1f', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'a0bdb049-498d-43d8-beff-e132feb014b0', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'db7adebd-ceaf-4c63-b2c2-56ca3fa50747', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');


alter table product_msg add is_fab tinyint(2) DEFAULT '0' COMMENT '是否已发布 0未发布 1已发布' after is_deleted;

-- 新增manager_level表
CREATE TABLE `manager_level` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '用户uuid',
  `level_uuid` varchar(64) DEFAULT NULL COMMENT '会员uuid',
  `incoming` int(5) DEFAULT '0' COMMENT '高级经理进件数',
  `incoming2` int(5) DEFAULT '0' COMMENT '高级总监进件数',
  `be_incoming` int(5) DEFAULT '0' COMMENT '已进件数',
  `team_count` int(5) DEFAULT '0' COMMENT '高级经理团队人数',
  `team_count2` int(5) DEFAULT '0' COMMENT '高级总监团队人数',
  `be_team_count` int(5) DEFAULT '0' COMMENT '已达团队人数',
  `vip_count` int(5) DEFAULT '0' COMMENT '高级经理会员数',
  `vip_count2` int(5) DEFAULT '0' COMMENT '高级总监会员数',
  `be_vip_count` int(5) DEFAULT '0' COMMENT '已成为会员数',
  `is_send` tinyint DEFAULT '0' COMMENT '高级经理是否通知',
  `is_send2` tinyint DEFAULT '0' COMMENT '高级总监是否通知',
  `level_time` varchar(64) DEFAULT NULL COMMENT '升级时间',
  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户经理等级关联表';


-- 存量数据变更，将用户添加为服务经理
--存储过程
CREATE DEFINER=`root`@`%` PROCEDURE `add_manager_level`()
BEGIN
	DECLARE end_flag int DEFAULT 0;
	DECLARE albumId varchar(32);
	DECLARE album_curosr CURSOR FOR SELECT uuid FROM manager;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET end_flag=1;
	OPEN album_curosr;
	REPEAT
		FETCH album_curosr INTO albumId;
			INSERT INTO `zyke`.`manager_level`(`manager_uuid`, `level_uuid`, `incoming`, `incoming2`, `be_incoming`, `team_count`, `team_count2`, `be_team_count`, `vip_count`, `vip_count2`, `be_vip_count`, `is_send`, `is_send2`, `level_time`, `is_deleted`, `create_at`, update_at) VALUES (albumId, '128665cd8b494e87901de591844de2ce', 39, 99, 0, 19, 49, 0, 3, 9, 0, 0, 0, null, 0, '2022-07-03 18:16:42', null);
	UNTIL end_flag END REPEAT;
	close album_curosr;
	DELETE FROM manager_level ORDER BY id DESC LIMIT 1;
END

call add_manager_level();
DROP PROCEDURE add_manager_level;

INSERT INTO `zyke`.`level`(`uuid`, `name`, `level`, `income_amount`, `member_amount`, `vip_amount`, `is_deleted`, `create_at`, `update_at`) VALUES ('128665cd8b494e87901de591844de2ce', '服务经理', 1, 0, 0, 0, 0, '2022-06-27 03:52:56', '2022-06-27 03:52:56');
INSERT INTO `zyke`.`level`(`uuid`, `name`, `level`, `income_amount`, `member_amount`, `vip_amount`, `is_deleted`, `create_at`, `update_at`) VALUES ('18181445cb8e4f06af568d0375c3aedd', '高级经理', 2, 39, 19, 3, 0, '2022-06-27 03:52:56', '2022-06-27 03:52:56');
INSERT INTO `zyke`.`level`(`uuid`, `name`, `level`, `income_amount`, `member_amount`, `vip_amount`, `is_deleted`, `create_at`, `update_at`) VALUES ('23181445cb8e4f06af568d0375c3aedd', '高级总监', 3, 99, 49, 9, 0, '2022-06-27 03:52:56', '2022-06-27 03:54:42');

