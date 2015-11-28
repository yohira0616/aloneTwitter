package jp.ne.yohira.common;

import org.springframework.beans.factory.annotation.Autowired;

import com.datastax.driver.core.Session;

/**
 * cassandraへの接続コネクションを保持するベースクラス
 * @author yukito ohira
 *
 */
public class CassandraDaoBase {

	@Autowired
	protected Session session;

}
