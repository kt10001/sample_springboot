-- 提现审批
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`) VALUES ('e0f06238-fb70-11ec-82b6-0242ac110123', 'c8723f05-ca15-11ec-9b33-0242ac110001', '划付审批', '/zyk/admin/pay/reApprove');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'e0f06238-fb70-11ec-82b6-0242ac110123');
-- 提现备注
INSERT INTO `zyke`.`permission`(`uuid`, `parent_id`, `name`, `url`) VALUES ('e0f06238-fb70-11ec-82b6-0242ac110345', 'c8723f05-ca15-11ec-9b33-0242ac110001', '提现备注', '/zyk/admin/pay/comment');
INSERT INTO `zyke`.`role_permission`(`role_uuid`, `permission_uuid`) VALUES ('1c7be48d-ca1d-11ec-9b33-0242ac110002', 'e0f06238-fb70-11ec-82b6-0242ac110345');

-- 用户提现表添加字段
alter table manager_income add comment varchar(500) DEFAULT '' comment '备注' after current_add_value_tax;