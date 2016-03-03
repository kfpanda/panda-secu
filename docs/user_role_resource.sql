-- ----------------------------
-- Table structure for `sys_session`
-- ----------------------------
DROP TABLE IF EXISTS `sys_session`;
CREATE TABLE `sys_session` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `sessionid` varchar(255) NOT NULL,
  `session` varchar(5000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_session_sessionid_index` (`sessionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
ALTER TABLE `sys_session` ADD UNIQUE(`sessionid`);

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `pid` bigint(10) NOT NULL DEFAULT 0,
  `name` varchar(30) NOT NULL,
  `code` varchar(30) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_resource_pid_index` (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

ALTER TABLE `sys_resource` ADD UNIQUE(`url`);
-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO sys_resource VALUES ('1', CURRENT_TIMESTAMP, '0', '超级资源', 'superadmin', 'admin', '/*', '1', null, null);


-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(30) NOT NULL,
  `code` varchar(30) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

ALTER TABLE `sys_role` ADD UNIQUE(`code`);
-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO sys_role VALUES ('1', CURRENT_TIMESTAMP, '超级管理员', 'role_superadmin', '1', '1', null);

-- ----------------------------
-- Table structure for `sys_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `roleid` bigint(10) NOT NULL,
  `rid` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_role_resource_roleid_index` (`roleid`) USING BTREE,
  KEY `sys_role_resource_rid_index` (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO sys_role_resource VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nkname` varchar(20) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '状态 0为未激活 1为激活，2为冻结状态',
  `type` tinyint(4) DEFAULT 0 COMMENT '类型 0是普通客户',
  `name` varchar(12) DEFAULT NULL COMMENT '姓名 4-12位，由字母和汉字组成',
  `email` varchar(50) DEFAULT NULL,
  `telno` char(11) DEFAULT NULL,
  `idcard` char(18) DEFAULT NULL COMMENT '身份证号码 由18位字母和数字组成',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别 1男 0女 ',
  `birth` date DEFAULT NULL COMMENT '生日',
  `integral` int(11) DEFAULT NULL COMMENT '积分',
  `address` varchar(50) DEFAULT NULL COMMENT '联系地址及邮编',
  `weichat` char(20) DEFAULT NULL COMMENT '微信号6-20个字母、数字、下划线和减号，必须以字母开头',
  `qq` bigint(11) DEFAULT NULL COMMENT 'QQ号  4-11位数字组成',
  `face` varchar(100) DEFAULT NULL COMMENT '头像',
  `remark` varchar(400) DEFAULT NULL,
  `openid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_user_username_index` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33384 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'superadmin', '21232f297a57a5a743894a0e4a801fc3', 'kfpanda', 1, 0, '超级管理员', 'liuhualuo@163.com', '18989893671', NULL, 1, '2015-08-19', NULL, 'address', '18989893671', 35652734, NULL, 'remark', NULL);

-- ----------------------------
-- Table structure for `sys_user_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_resource`;
CREATE TABLE `sys_user_resource` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `uid` bigint(10) NOT NULL,
  `rid` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_user_resource_uid_index` (`uid`) USING BTREE,
  KEY `sys_user_resource_rid_index` (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_resource
-- ----------------------------
-- INSERT INTO sys_user_resource VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `uid` bigint(10) NOT NULL,
  `roleid` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_user_role_uid_index` (`uid`) USING BTREE,
  KEY `sys_user_role_roleid_index` (`roleid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO sys_user_role VALUES ('1', '1', '1');