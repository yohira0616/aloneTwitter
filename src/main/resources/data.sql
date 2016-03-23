-- USERS INITIALIZE
DELETE FROM USERS;
--CREATE TEST USERS
INSERT INTO users(user_id,passwd) VALUES('admin',crypt('admin',gen_salt('bf',10)));
INSERT INTO users(user_id,passwd) VALUES('testuser',crypt('testuser',gen_salt('bf',10)));
INSERT INTO users(user_id,passwd) VALUES('admin1',crypt('user1',gen_salt('bf',10)));