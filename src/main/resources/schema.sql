--スーパーユーザでCREATE EXTENSION pgcrypto;を実行して、暗号化関数のモジュールをインポートしておく必要あり

--CREATE TABLE
CREATE TABLE IF NOT EXISTS users (user_id VARCHAR(30) PRIMARY KEY,passwd VARCHAR(256) NOT NULL)
CREATE TABLE IF NOT EXISTS tweet (post_id SERIAL PRIMARY KEY,contents VARCHAR(280) NOT NULL,PRC_DATE TIMESTAMP NOT NULL)