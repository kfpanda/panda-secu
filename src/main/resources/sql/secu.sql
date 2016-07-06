/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/7/5 17:35:54                            */
/*==============================================================*/


DROP INDEX idx_code ON sys_resource;

DROP TABLE IF EXISTS sys_resource;

DROP INDEX idx_status ON sys_role;

DROP INDEX idex_code ON sys_role;

DROP TABLE IF EXISTS sys_role;

DROP INDEX idx_roleid_rid ON sys_role_resource;

DROP TABLE IF EXISTS sys_role_resource;

DROP INDEX idx_idcard ON sys_user;

DROP INDEX idx_telphone ON sys_user;

DROP INDEX idx_type ON sys_user;

DROP INDEX idx_status ON sys_user;

DROP INDEX idx_username ON sys_user;

DROP TABLE IF EXISTS sys_user;

DROP INDEX idx_uid_rid ON sys_user_resource;

DROP TABLE IF EXISTS sys_user_resource;

DROP INDEX idx_uid_rid ON sys_user_role;

DROP TABLE IF EXISTS sys_user_role;

/*==============================================================*/
/* Table: sys_resource                                          */
/*==============================================================*/
CREATE TABLE sys_resource
(
   id                   BIGINT(15) NOT NULL AUTO_INCREMENT,
   createtime           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   pid                  BIGINT(15) NOT NULL DEFAULT 0,
   NAME                 VARCHAR(30) NOT NULL,
   CODE                 VARCHAR(30) NOT NULL,
   TYPE                 VARCHAR(10),
   url                  VARCHAR(255),
   STATUS               INT,
   sort                 INT,
   remark               VARCHAR(200),
   PRIMARY KEY (id)
);

/*==============================================================*/
/* Index: idx_code                                              */
/*==============================================================*/
CREATE UNIQUE INDEX idx_code ON sys_resource
(
   CODE
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
CREATE TABLE sys_role
(
   id                   BIGINT(10) NOT NULL AUTO_INCREMENT,
   createtime           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   NAME                 VARCHAR(30) NOT NULL,
   CODE                 VARCHAR(30) NOT NULL,
   STATUS               INT(11),
   sort                 INT(11),
   remark               VARCHAR(200),
   PRIMARY KEY (id)
);

/*==============================================================*/
/* Index: idex_code                                             */
/*==============================================================*/
CREATE UNIQUE INDEX idex_code ON sys_role
(
   CODE
);

/*==============================================================*/
/* Index: idx_status                                            */
/*==============================================================*/
CREATE INDEX idx_status ON sys_role
(
   STATUS
);

/*==============================================================*/
/* Table: sys_role_resource                                     */
/*==============================================================*/
CREATE TABLE sys_role_resource
(
   id                   BIGINT(15) NOT NULL AUTO_INCREMENT,
   roleid               BIGINT(15) NOT NULL,
   rid                  BIGINT(15) NOT NULL,
   PRIMARY KEY (id)
);

/*==============================================================*/
/* Index: idx_roleid_rid                                        */
/*==============================================================*/
CREATE UNIQUE INDEX idx_roleid_rid ON sys_role_resource
(
   roleid,
   rid
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
CREATE TABLE sys_user
(
   id                   BIGINT NOT NULL AUTO_INCREMENT,
   createtime           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   updatetime           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   username             VARCHAR(20) NOT NULL,
   PASSWORD             VARCHAR(50) NOT NULL,
   nkname               VARCHAR(20),
   STATUS               TINYINT NOT NULL DEFAULT 0,
   TYPE                 TINYINT DEFAULT 0,
   NAME                 VARCHAR(12),
   email                VARCHAR(50),
   telno                VARCHAR(11),
   idcard               VARCHAR(18),
   sex                  TINYINT,
   birth                DATE,
   integral             INT(11),
   address              VARCHAR(50),
   weichat              VARCHAR(30),
   qq                   BIGINT(11),
   face                 VARCHAR(100),
   remark               VARCHAR(400),
   openid               VARCHAR(20),
   PRIMARY KEY (id)
);

/*==============================================================*/
/* Index: idx_username                                          */
/*==============================================================*/
CREATE UNIQUE INDEX idx_username ON sys_user
(
   username
);

/*==============================================================*/
/* Index: idx_status                                            */
/*==============================================================*/
CREATE INDEX idx_status ON sys_user
(
   STATUS
);

/*==============================================================*/
/* Index: idx_type                                              */
/*==============================================================*/
CREATE INDEX idx_type ON sys_user
(
   TYPE
);

/*==============================================================*/
/* Index: idx_telphone                                          */
/*==============================================================*/
CREATE INDEX idx_telphone ON sys_user
(
   telno
);

/*==============================================================*/
/* Index: idx_idcard                                            */
/*==============================================================*/
CREATE INDEX idx_idcard ON sys_user
(
   idcard
);

/*==============================================================*/
/* Table: sys_user_resource                                     */
/*==============================================================*/
CREATE TABLE sys_user_resource
(
   id                   BIGINT(10) NOT NULL AUTO_INCREMENT,
   uid                  BIGINT(10) NOT NULL,
   rid                  BIGINT(10) NOT NULL,
   PRIMARY KEY (id)
);

/*==============================================================*/
/* Index: idx_uid_rid                                           */
/*==============================================================*/
CREATE UNIQUE INDEX idx_uid_rid ON sys_user_resource
(
   uid,
   rid
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
CREATE TABLE sys_user_role
(
   id                   BIGINT(10) NOT NULL AUTO_INCREMENT,
   uid                  BIGINT(10) NOT NULL,
   rid                  BIGINT(10) NOT NULL,
   PRIMARY KEY (id)
);

/*==============================================================*/
/* Index: idx_uid_rid                                           */
/*==============================================================*/
CREATE UNIQUE INDEX idx_uid_rid ON sys_user_role
(
   uid,
   rid
);






DROP INDEX idx_session_id ON sys_session;

DROP TABLE IF EXISTS sys_session;

/*==============================================================*/
/* Table: sys_session                                           */
/*==============================================================*/
CREATE TABLE sys_session
(
   id                   BIGINT NOT NULL AUTO_INCREMENT,
   createtime           TIMESTAMP,
   updatetime           TIMESTAMP,
   sessionid            VARCHAR(64) NOT NULL,
   SESSION              TEXT NOT NULL,
   PRIMARY KEY (id)
);

/*==============================================================*/
/* Index: idx_session_id                                        */
/*==============================================================*/
CREATE UNIQUE INDEX idx_session_id ON sys_session
(
   sessionid
);