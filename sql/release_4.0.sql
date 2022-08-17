

-- product表字段变更
alter table product add column income_type tinyint(2) default 0 comment '产品返佣方式 0-按比例返佣 1-按金额返佣' after link;
alter table product add column income_m decimal(9,2) default '0.00' comment '资方返佣金额' after vip_b_rate;
alter table product add column vip_a_m decimal(9,2) default '0.00' comment '普通会员返佣金额' after income_m;
alter table product add column vip_b_m decimal(9,2) default '0.00' comment '超级会员返佣金额' after vip_a_m;
alter table product add column label varchar(64) default '' comment '标签' after vip_b_m;

-- 添加配置
INSERT INTO config_property(`config_key`, `config_value`, `config_type`, `comment`, `is_deleted`, `create_at`, `update_at`)
VALUES ('quanType', '[{\"name\": \"进件现金券\",\"value\": 0},{\"name\": \"邀请好友进件现金券\",\"value\": 1}]', 2, '现金券类型', 0, '2022-07-14 02:12:28', NULL);


-- manager_entry表字段变更
alter table `manager_entry` change column `uuid` `incoming_uuid` varchar(64) null comment '进件单号';
alter table `manager_entry` MODIFY column `amount` decimal(10,2)  null comment '入账金额' AFTER `product_uuid`;

-- settlement表字段变更
alter table `settlement` add column `third_loan_id` varchar(64) null comment '三方放款id' after update_at;

-- incoming表字段变更
ALTER TABLE `incoming`
	DROP COLUMN `vip_rate`,
	DROP COLUMN `income_rate`,
	ADD COLUMN `income_type` tinyint(4) NULL DEFAULT 0 COMMENT '产品返佣方式 0-按比例返佣 1-按金额返佣' AFTER `progress`,
	ADD COLUMN `vip_a_rate` decimal(8,5)  NULL DEFAULT 0.00000 COMMENT '普通会员返佣比例' AFTER `income_type`,
	ADD COLUMN `vip_b_rate` decimal(8,5)  NULL DEFAULT 0.00000 COMMENT '超级会员返佣比例' AFTER `vip_a_rate`,
	ADD COLUMN `vip_a_m` decimal(9,2)  NULL DEFAULT 0.00 COMMENT '普通会员返佣金额' AFTER `vip_b_rate`,
	ADD COLUMN `vip_b_m` decimal(9,2)  NULL DEFAULT 0.00 COMMENT '超级会员返佣金额' AFTER `vip_a_m`,
	ADD COLUMN `third_id` varchar(64) NULL COMMENT '三方进件id' AFTER `settlement_at`;

-- 最后执行这个循环（目的是将产品设置的那些金额插入到进件里）
-- （可能需要将product表和incoming表的uuid product_uuid 排序规则换成utf8mb4_general_ci）
-- delimiter $$ 告诉解释器使用$$结尾
delimiter $$
DROP PROCEDURE IF EXISTS update_incoming;
create PROCEDURE update_incoming ()
begin
-- 声明自定义变量
DECLARE iuuid VARCHAR(64);
-- 声明游标结束变量
DECLARE done INT DEFAULT 0;
-- 声明游标 cr 以及游标读取到结果集最后的处理方式
DECLARE cur CURSOR FOR SELECT product_uuid FROM incoming;
DECLARE continue handler for not found set done = 1;
-- 打开游标
OPEN cur;
-- 循环
  incoming_loop: LOOP

     -- 获取游标中值并赋值给变量
     FETCH cur INTO iuuid;
     -- 判断游标是否到底，若到底则退出游标
     -- 需要注意这个判断
     IF done=1 THEN
         LEAVE incoming_loop;
     END IF;
     -- 需要执行的语句
     update incoming set vip_a_rate = (SELECT vip_a_rate from product WHERE uuid = iuuid),vip_b_rate = (SELECT vip_b_rate from product WHERE uuid = iuuid),vip_a_m=(SELECT vip_a_m from product WHERE uuid = iuuid),vip_b_m=(SELECT vip_b_m from product WHERE uuid = iuuid) WHERE product_uuid = iuuid;
  END LOOP incoming_loop;
-- 关闭游标
CLOSE cur;
end$$
-- 最后重新定义为;
delimiter ;

-- 执行存储过程
call update_incoming;


drop table if exists coupon;
CREATE TABLE `coupon` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(64) DEFAULT NULL COMMENT '现金券uuid',
  `name` varchar(64) DEFAULT NULL COMMENT '现金券名称',
  `people_type` tinyint DEFAULT NULL COMMENT '参与人群 0-全部 1-新用户 2-老用户 3-指定用户',
  `product_type` tinyint DEFAULT NULL COMMENT '活动产品 0-全部 1-指定产品',
  `get_type` tinyint DEFAULT NULL COMMENT '领取方式 0-后台赠送',
  `coupon_type` tinyint DEFAULT NULL COMMENT '现金券类型 0-进件现金券 1-邀请好友进件现金券',
  `send_type` tinyint DEFAULT '0' COMMENT '发放状态 0-发放中 1-停止发放',
  `time_type` tinyint DEFAULT '0' COMMENT '有效期类型 0-自定义 1-当前 2-次日',
  `counts` int(11) DEFAULT NULL COMMENT '发行数量 -1-无上限',
  `money` decimal(10,2) DEFAULT NULL COMMENT '发行面额',
  `use_limit` tinyint DEFAULT NULL COMMENT '使用门槛 0-无门槛',
  `rule` varchar(1024) DEFAULT NULL COMMENT '使用规则',
  `comment` varchar(1024) DEFAULT NULL COMMENT '备注',
  `start_time` varchar(32) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(32) DEFAULT NULL COMMENT '结束时间',
  `no_send_reason` varchar(255) DEFAULT NULL COMMENT '停止发券原因',
  `deleted_reason` varchar(255) DEFAULT NULL COMMENT '失效原因',
  `day` int(11) DEFAULT NULL COMMENT '有效期天数',
  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`uuid`) USING BTREE COMMENT 'uuid'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='现金券表';

drop table if exists manager_coupon;
CREATE TABLE `manager_coupon` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `manager_uuid` varchar(64) DEFAULT NULL COMMENT '用户uuid',
  `coupon_uuid` varchar(64) DEFAULT NULL COMMENT '现金券uuid',
  `coupon_type` tinyint DEFAULT NULL COMMENT '现金券类型 0-进件现金券 1-邀请好友进件现金券',
  `is_check` tinyint DEFAULT '0' COMMENT '是否查看 0-否 1-是',
  `money` decimal(10,2) DEFAULT NULL COMMENT '发行面额',
  `rule` varchar(1024) DEFAULT NULL COMMENT '使用规则',
  `start_time` varchar(64) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(64) DEFAULT NULL COMMENT '结束时间',
  `use_time` varchar(64) DEFAULT NULL COMMENT '使用时间',
  `incoming_uuid` varchar(64) DEFAULT NULL COMMENT '进件单号',
  `status` tinyint DEFAULT '0' COMMENT '现金券状态 0-待使用 1-即将过期 2-已使用 3-已失效',
  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户经理现金券关联表';

drop table if exists product_coupon;
CREATE TABLE `product_coupon` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_uuid` varchar(64) DEFAULT NULL COMMENT '产品uuid',
  `coupon_uuid` varchar(64) DEFAULT NULL COMMENT '现金券uuid',
  `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除 0-否 1-是',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品现金券关联表';

-- 添加权限
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('ae1ceb9b-28ec-3929-c12f-adb67ff1726d', NULL, '现金券管理', NULL, 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('5a33899d-97ee-9284-101c-42ffb1e57f3c', 'ae1ceb9b-28ec-3929-c12f-adb67ff1726d', '新增现金券', '/zyk/admin/coupon/add', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('f394648d-7b2b-1039-019b-60008adf74ea', 'ae1ceb9b-28ec-3929-c12f-adb67ff1726d', '现金券列表', '/zyk/admin/coupon/list', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('677df7c9-794b-d1a9-835c-95426da36042', 'ae1ceb9b-28ec-3929-c12f-adb67ff1726d', '现金券详情', '/zyk/admin/coupon/detail', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`, `is_deleted`, `create_at`, `update_at`) VALUES ('cc835706-e4e4-ec79-5d09-d7f94cef4f7f', 'ae1ceb9b-28ec-3929-c12f-adb67ff1726d', '编辑现金券', '/zyk/admin/coupon/update', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');

INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'ae1ceb9b-28ec-3929-c12f-adb67ff1726d', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '5a33899d-97ee-9284-101c-42ffb1e57f3c', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'f394648d-7b2b-1039-019b-60008adf74ea', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', '677df7c9-794b-d1a9-835c-95426da36042', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`, `is_deleted`, `create_at`, `update_at`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'cc835706-e4e4-ec79-5d09-d7f94cef4f7f', 0, '2022-06-10 14:44:19', '2022-06-10 14:44:19');

alter table manager add is_send tinyint(2) DEFAULT 0 comment '是否重新发过券 0-否 1-是' after login_time;
