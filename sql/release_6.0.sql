################### v6.0 sql ###################
-- 新增配置表不脱敏角色uuid
INSERT INTO `zyke`.`config_property`(`config_key`, `config_value`, `config_type`,`comment`, `is_deleted`,`create_at`, `update_at`) VALUES ('desRole','1c7be48d-ca1d-11ec-9b33-0242ac110002',4,'不脱敏角色uuid',0,'2022-08-03 09:12:28', '2022-08-03 09:34:37')

INSERT INTO `zyke`.`config_property`(`config_key`, `config_value`, `config_type`, `comment`, `is_deleted`, `create_at`, `update_at`) VALUES ('problemType', '[{\"name\": \"系统bug\",\"value\": 0},{\"name\": \"优化体验\",\"value\": 1},{\"name\": \"功能操作\",\"value\": 2},{\"name\": \"账号登录\",\"value\": 3},{\"name\": \"其他问题\",\"value\": 4},{\"name\": \"商务合作\",\"value\": 5}]\n', 2, '问题反馈类型', 0, '2022-08-02 02:12:28', '2022-08-02 07:34:37');

-- 新增问题记录表
drop table if exists problem_log;

CREATE TABLE `problem_log` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `type` tinyint DEFAULT NULL COMMENT '问题类型 0-系统bug 1-优化体验 2-功能操作 3-账号登录 4-其他问题 5-商务合作',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '客户经理uuid',
  `register_phone` varchar(32) DEFAULT NULL COMMENT '注册手机号',
  `write_phone` varchar(32) DEFAULT NULL COMMENT '填写手机号',
  `picture_url` text COMMENT '反馈图片',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `problem` varchar(1024) DEFAULT NULL COMMENT '反馈内容',
  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='问题记录表';

INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('74bc65a2-396a-97ad-3141-f2234b63ee83', NULL, '反馈管理', NULL, 0, '2022-05-02 20:44:19', '2022-05-02 20:46:10');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('7f031ebd-5ddf-313d-4e88-d2aa0527b4ed', '74bc65a2-396a-97ad-3141-f2234b63ee83', '查看反馈详情', '/zyk/admin/problem/detail', 0, '2022-05-02 20:46:30', '2022-05-04 17:27:49');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('80c08a8e-ed86-c6c9-e8c7-746dbf2d449c', '74bc65a2-396a-97ad-3141-f2234b63ee83', '反馈备注', '/zyk/admin/problem/comment', 0, '2022-05-04 18:18:17', '2022-05-04 18:18:43');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('0257ffc4-0b17-9979-91b6-4ee95873673f', '74bc65a2-396a-97ad-3141-f2234b63ee83', '查看反馈管理列表', '/zyk/admin/problem/list', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '74bc65a2-396a-97ad-3141-f2234b63ee83', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '7f031ebd-5ddf-313d-4e88-d2aa0527b4ed', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '80c08a8e-ed86-c6c9-e8c7-746dbf2d449c', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '0257ffc4-0b17-9979-91b6-4ee95873673f', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
