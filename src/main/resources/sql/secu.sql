/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/7/7 9:53:39                             */
/*==============================================================*/


drop index idx_code on sys_resource;

drop table if exists sys_resource;

drop index idx_status on sys_role;

drop index idex_code on sys_role;

drop table if exists sys_role;

drop index idx_roleid_rid on sys_role_resource;

drop table if exists sys_role_resource;

drop index idx_session_id on sys_session;

drop table if exists sys_session;

drop index idx_idcard on sys_user;

drop index idx_telphone on sys_user;

drop index idx_type on sys_user;

drop index idx_status on sys_user;

drop index idx_username on sys_user;

drop table if exists sys_user;

drop index idx_uid_rid on sys_user_resource;

drop table if exists sys_user_resource;

drop index idx_uid_rid on sys_user_role;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: sys_resource                                          */
/*==============================================================*/
create table sys_resource
(
   id                   Bigint(15) not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   updatetime           timestamp not null default CURRENT_TIMESTAMP,
   pid                  bigint(15) not null default 0,
   name                 varchar(30) not null,
   code                 varchar(30) not null,
   type                 varchar(10),
   url                  varchar(255),
   status               int,
   sort                 int,
   remark               varchar(200),
   primary key (id)
);

/*==============================================================*/
/* Index: idx_code                                              */
/*==============================================================*/
create unique index idx_code on sys_resource
(
   code
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   Bigint(10) not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   updatetime           timestamp not null default CURRENT_TIMESTAMP,
   name                 varchar(30) not null,
   code                 varchar(30) not null,
   status               int(11),
   sort                 int(11),
   remark               varchar(200),
   primary key (id)
);

/*==============================================================*/
/* Index: idex_code                                             */
/*==============================================================*/
create unique index idex_code on sys_role
(
   code
);

/*==============================================================*/
/* Index: idx_status                                            */
/*==============================================================*/
create index idx_status on sys_role
(
   status
);

/*==============================================================*/
/* Table: sys_role_resource                                     */
/*==============================================================*/
create table sys_role_resource
(
   id                   bigint(15) not null auto_increment,
   roleid               bigint(15) not null,
   rid                  bigint(15) not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_roleid_rid                                        */
/*==============================================================*/
create unique index idx_roleid_rid on sys_role_resource
(
   roleid,
   rid
);

/*==============================================================*/
/* Table: sys_session                                           */
/*==============================================================*/
create table sys_session
(
   id                   bigint not null auto_increment,
   createtime           timestamp,
   updatetime           timestamp,
   sessionid            varchar(64) not null,
   session              text not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_session_id                                        */
/*==============================================================*/
create unique index idx_session_id on sys_session
(
   sessionid
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   updatetime           timestamp not null default CURRENT_TIMESTAMP,
   username             varchar(20) not null,
   password             varchar(50) not null,
   nkname               varchar(20),
   status               tinyint not null default 0,
   type                 tinyint default 0,
   name                 varchar(12),
   email                varchar(50),
   telno                varchar(11),
   idcard               varchar(18),
   sex                  tinyint,
   birth                varchar(10),
   integral             int(11),
   address              varchar(50),
   weichat              varchar(30),
   qq                   bigint(11),
   face                 varchar(100),
   remark               varchar(400),
   openid               varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Index: idx_username                                          */
/*==============================================================*/
create unique index idx_username on sys_user
(
   username
);

/*==============================================================*/
/* Index: idx_status                                            */
/*==============================================================*/
create index idx_status on sys_user
(
   status
);

/*==============================================================*/
/* Index: idx_type                                              */
/*==============================================================*/
create index idx_type on sys_user
(
   type
);

/*==============================================================*/
/* Index: idx_telphone                                          */
/*==============================================================*/
create index idx_telphone on sys_user
(
   telno
);

/*==============================================================*/
/* Index: idx_idcard                                            */
/*==============================================================*/
create index idx_idcard on sys_user
(
   idcard
);

/*==============================================================*/
/* Table: sys_user_resource                                     */
/*==============================================================*/
create table sys_user_resource
(
   id                   bigint(10) not null auto_increment,
   uid                  bigint(10) not null,
   rid                  bigint(10) not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_uid_rid                                           */
/*==============================================================*/
create unique index idx_uid_rid on sys_user_resource
(
   uid,
   rid
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   id                   Bigint(10) not null auto_increment,
   uid                  Bigint(10) not null,
   rid                  Bigint(10) not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_uid_rid                                           */
/*==============================================================*/
create unique index idx_uid_rid on sys_user_role
(
   uid,
   rid
);

