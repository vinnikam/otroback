create role userdb with password '123456';
create database userdata owner userdb;
ALTER ROLE userdb LOGIN;
