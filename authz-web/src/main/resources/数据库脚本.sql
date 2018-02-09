-- 对内统一鉴权表设计

DROP TABLE
IF EXISTS `oauth_user`;

CREATE TABLE `oauth_user` (
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`username` CHAR (20) NOT NULL,
	`password` VARCHAR (60),
	PRIMARY KEY (`id`),
	UNIQUE KEY `unique_index_user` (`username`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS `oauth_token`;

CREATE TABLE `oauth_token` (
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT UNSIGNED NOT NULL COMMENT '表示token属于哪个用户',
	`username` CHAR (20) NOT NULL COMMENT '冗余字段，用户名',
	`access_token` CHAR (32) NOT NULL COMMENT '访问token',
	`refresh_token` CHAR (32) NOT NULL COMMENT '用于刷新获取新token的token',
	`create_at` TIMESTAMP NOT NULL COMMENT 'token创建时间',
	`expire_at` TIMESTAMP NOT NULL COMMENT '访问token过期时间',
	`refresh_expire_at` TIMESTAMP NOT NULL COMMENT '刷新token过期时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS `oauth_role`;

CREATE TABLE `oauth_role` (
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`code` VARCHAR (20) NOT NULL,
	`name` VARCHAR (20),
	`description` VARCHAR (60),
	PRIMARY KEY (`id`),
	UNIQUE KEY `unique_index_role` (`code`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS `oauth_user_role`;

CREATE TABLE `oauth_user_role` (
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT UNSIGNED NOT NULL,
	`role_id` BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `unique_index_user_role` (`user_id`, `role_id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS `oauth_resource`;

CREATE TABLE `oauth_resource` (
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`code` VARCHAR (40) NOT NULL,
	`name` VARCHAR (20) NOT NULL,
	`description` VARCHAR (60) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `unique_index_resource` (`code`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS `oauth_role_resource`;

CREATE TABLE `oauth_role_resource` (
	`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`role_id` BIGINT UNSIGNED NOT NULL,
	`resource_id` BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `unique_index_role_resource` (`role_id`, `resource_id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8;

-- 数据插入
INSERT INTO oauth_user (`username`, `password`)
VALUES
	('admin', 'admin');

INSERT INTO oauth_role (
	`code`,
	`name`,
	`description`
)
VALUES
	(
		'admin',
		'管理员',
		'系统的管理员'
	);

INSERT INTO oauth_resource (
	`code`,
	`name`,
	`description`
)
VALUES
	(
		'manager:view',
		'后台页面查看',
		'允许进入查看后台页面'
	),
	(
		'manager:add',
		'后台页面新增',
		'允许进入新增后台页面'
	),
	(
		'manager:edit',
		'后台页面编辑',
		'允许进入编辑后台页面'
	);

INSERT INTO oauth_user_role (`user_id`, `role_id`)
VALUES
	(1, 1);

INSERT INTO oauth_role_resource (`role_id`, `resource_id`)
VALUES
	(1, 1),
	(1, 2),
	(1, 3);
