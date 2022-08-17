################### v5.0 sql ###################

-- 采票管理
drop table if exists collect_ticket;

CREATE TABLE `collect_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '采票名称',
  `status` tinyint(4) DEFAULT NULL COMMENT '显示状态 0-隐藏 1-显示',
  `online_link` varchar(255) DEFAULT NULL COMMENT '在线采票链接',
  `tax_link` varchar(255) DEFAULT NULL COMMENT '税盘采集链接',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid索引'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='采票管理';

-- 采票与产品关联
drop table if exists product_ticket;

CREATE TABLE `product_ticket` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_uuid` varchar(64) DEFAULT NULL COMMENT '产品uuid',
  `ticket_uuid` varchar(64) DEFAULT NULL COMMENT '采票uuid',
  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品和采票关联表';

INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('86fc17ba-ce84-f79f-fa2d-e91def447feb', NULL, '采票管理', NULL, 0, '2022-05-02 20:44:19', '2022-05-02 20:46:10');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('73661d50-bc8a-171e-0716-911fe9384d72', '86fc17ba-ce84-f79f-fa2d-e91def447feb', '新增采票', '/zyk/admin/collectTicket/add', 0, '2022-05-02 20:46:30', '2022-05-04 17:27:49');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('ea963667-1552-6808-4456-f55e3f55da6a', '86fc17ba-ce84-f79f-fa2d-e91def447feb', '采票详情', '/zyk/admin/collectTicket/detail', 0, '2022-05-04 18:18:17', '2022-05-04 18:18:43');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('3ade6bfb-9edc-1bb9-7d84-8d9ac7ac16f4', '86fc17ba-ce84-f79f-fa2d-e91def447feb', '查看采票列表', '/zyk/admin/collectTicket/list', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('083f991c-a4d6-3e8a-e34b-28116e367223', '86fc17ba-ce84-f79f-fa2d-e91def447feb', '编辑采票', '/zyk/admin/collectTicket/update', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('ab585751-db33-213f-6550-f29fd2dae784', '86fc17ba-ce84-f79f-fa2d-e91def447feb', '删除采票', '/zyk/admin/collectTicket/delete', 0, '2022-05-05 10:17:32', '2022-05-05 10:17:46');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '86fc17ba-ce84-f79f-fa2d-e91def447feb', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '73661d50-bc8a-171e-0716-911fe9384d72', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'ea963667-1552-6808-4456-f55e3f55da6a', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '3ade6bfb-9edc-1bb9-7d84-8d9ac7ac16f4', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '083f991c-a4d6-3e8a-e34b-28116e367223', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'ab585751-db33-213f-6550-f29fd2dae784', 0, '2022-05-02 21:39:48', '2022-05-02 21:39:50');
