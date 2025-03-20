create role userdb with password '123456';
create database bd_invest owner userdb;
ALTER ROLE userdb LOGIN;

-- select generid
select u.username, ,password, r.role_name, p.name as permission_name
from users u
         inner join
     user_roles ur on u.id = ur.user_id
         inner join
     roles r on ur.role_id = r.id
         inner join
     role_permissions rp on r.id = rp.role_id
         inner join
     permissions p on rp.permission_id = p.id;
