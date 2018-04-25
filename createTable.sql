drop table `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `role` smallint(1) NOT NULL COMMENT '角色(0:管理员,1:康复教练,2:病患)',
  `sex` smallint(1) NOT NULL COMMENT '性别(0:男,1:女)',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `birthday` varchar(16) NOT NULL COMMENT '出生日期',
  `mobile_phone` varchar(11) NOT NULL COMMENT '手机' DEFAULT '',
  `mark` varchar(128) NOT NULL COMMENT '备注' DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_mod_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_u_user_user_id` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
insert into `user`(`username`, `password`, `role`, `sex`, `name`, `birthday`, `mobile_phone`) values ('admin', 'admin', 0, 0, '管理员', '1992-01-01', '');



drop table `menu`;
CREATE TABLE `menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `text` varchar(64) NOT NULL COMMENT '名称',
  `url` varchar(64) NOT NULL COMMENT '链接',
  `icon` varchar(32) NOT NULL COMMENT '图标' DEFAULT 'icon-dashboard',
  `sort` smallint(8) NOT NULL COMMENT '顺序',
  `mark` varchar(128) NOT NULL COMMENT '备注' DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_mod_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';
insert into `menu` (`text`, `url`,  `sort`) values ('用户管理', '/user/list.htm', 0);
insert into `menu` (`text`, `url`,  `sort`) values ('病患信息', '/user/patientList.htm', 10);
insert into `menu` (`text`, `url`,  `sort`) values ('姿势管理', '/posture/list.htm', 11);
insert into `menu` (`text`, `url`,  `sort`) values ('动作管理', '/action/list.htm', 12);
insert into `menu` (`text`, `url`,  `sort`) values ('训练管理', '/training/list.htm', 13);
insert into `menu` (`text`, `url`,  `sort`) values ('训练记录管理', '/trainingRecord/list.htm', 14);




drop table `role_menu_relationship`;
CREATE TABLE `role_menu_relationship` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role` smallint(1) NOT NULL COMMENT '角色(0:管理员,1:康复教练,2:病患)',
  `menu_id` int(10) unsigned NOT NULL  COMMENT '菜单id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_u_role_menu_relationship_role_menu_id` (`role`, `menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单关系表';
insert into `role_menu_relationship` (`role`, `menu_id`) values (0, 1);
insert into `role_menu_relationship` (`role`, `menu_id`) values (1, 2);
insert into `role_menu_relationship` (`role`, `menu_id`) values (1, 3);
insert into `role_menu_relationship` (`role`, `menu_id`) values (1, 4);
insert into `role_menu_relationship` (`role`, `menu_id`) values (1, 5);
insert into `role_menu_relationship` (`role`, `menu_id`) values (1, 6);



drop table `coach_patient_relationship`;
CREATE TABLE `coach_patient_relationship` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `coach_user_id` int(10) unsigned NOT NULL  COMMENT '教练id',
  `patient_user_id` int(10) unsigned NOT NULL  COMMENT '病患id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_u_coach_patient_relationship_coach_user_id_patient_user_id` (`coach_user_id`, `patient_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教练-病患关系表';




drop table `action`;
CREATE TABLE `action` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '动作名称',
  `data_file` varchar(64) NOT NULL COMMENT '动作数据文件名称',
  `mark` varchar(128) NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_mod_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_u_action_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动作表'




drop table `training_record`;
CREATE TABLE `training_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL COMMENT '训练者id',
  `training_name` varchar(32) NOT NULL COMMENT '训练名称',
  `training_type` smallint(1) NOT NULL COMMENT '训练类型(0:姿势训练,1:动作训练)',
  `times_used` varchar(512) NOT NULL COMMENT '训练用时',
  `result` varchar(256) NOT NULL COMMENT '训练结果',
  `score` int(11) DEFAULT NULL COMMENT '训练评分',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='训练记录表';
insert into `training_record` (`user_id`, `training_name`, `training_type`, `times_used`, `result`) values (2, '基本姿势训练', 0, '[6,2,7,1,5,3,1,4,8]', '[1,1,1,1,1,1,1,1,1]');