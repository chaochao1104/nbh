create table prof_goods (
  id              BIGINT not null primary key auto_increment,
  goods_name      VARCHAR(500) not null,
  goods_desc      LONGTEXT
);