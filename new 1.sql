



create database if not exists shop charset=utf8 collate utf8_bin;    //建立数据库时不可指定引擎
create table if not exists goods(
goods_id int primary key auto_increment comment '商品编号',
goods_name varchar(20) not null comment '商品名称',
unitprice float(6,2) not null default 0 comment '商品单价',
category varchar(10) not null comment '商品类别'
);
create table if not exists customer(
custemer_id int primary key auto_increment comment '客户编号',
name varchar(10) not null comment '客户姓名',
adress varchar(64) comment '客户地址',
email varchar(64) unique key comment '电子邮箱',
sex enum('男','女') not null comment '性别',
card_id char(18) unique key comment '身份证'
);
create table if not exists purchase(
order_id int primary key auto_increment comment '订单号',
customer_id int comment '客户编号',
goods_id int comment '商品编号',
nums int default 0 comment '购买数量',
foreign key (customer_id) references custemer(custemer_id),
foreign key (goods_id) references goods(goods_id)
);