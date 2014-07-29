insert into mysql.user(Host,User,Password) values("localhost","nbh_app_user",password("jog6hfdlqHG"));

grant all privileges on nbh.* to nbh_app@localhost identified by 'jog6hfdlqHG';

flush privileges;