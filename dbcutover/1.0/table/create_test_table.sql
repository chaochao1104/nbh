create table person (
  oid             BIGINT not null primary key auto_increment,
  description     TEXT,
  birth_date      DATE,
  weight          DOUBLE(10, 4),
  is_male         BOOLEAN
);