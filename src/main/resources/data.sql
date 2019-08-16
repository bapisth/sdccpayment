--ROLE
INSERT INTO org_role(id, created_on, description, last_modified, name) VALUES (1, now(), 'Super User', now(), 'super_user');
select nextval('org_role_id_seq');

--PERMISSION
INSERT INTO org_permission (id, description, name) VALUES (1, 'user_admin', 'Ability to create, update, and delete users');
select nextval('org_permission_id_seq');
INSERT INTO org_permission (id, description, name) VALUES (2, 'mobile_user', 'Mobile User');
select nextval('org_permission_id_seq');
INSERT INTO org_permission (id, description, name) VALUES (3, 'download_user', 'Ability to download raw data');
select nextval('org_permission_id_seq');
INSERT INTO org_permission (id, description, name) VALUES (4, 'sudo_user', 'Ability to login as another user');
select nextval('org_permission_id_seq');
INSERT INTO org_permission (id, description, name) VALUES (5, 'role_admin', 'Ability to create, update, and delete roles (Super Admin)');
select nextval('org_permission_id_seq');

--USER (Default Username and Password is admin/admin)
INSERT INTO org_user(id, created_on, is_deleted, last_modified, mobile, name, password, username) VALUES (1, now(), 1 , now(), '9438437865', 'Techsofin Administrator', '$2a$10$nLNSsLS78F3iAXeQQO5oduvj8864ssI.JZPmn3ZX7N0Ha/aEqEw3i', 'admin');
select nextval('org_user_id_seq');
--USER ROLE
INSERT INTO org_user_role(id, org_role_id, org_user_id) VALUES (1, 1, 1); select nextval('org_user_role_id_seq');

