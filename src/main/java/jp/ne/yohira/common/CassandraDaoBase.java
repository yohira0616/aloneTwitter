package jp.ne.yohira.common;

import com.datastax.driver.core.Session;

/**
 * cassandraへの接続コネクションを保持するベースクラス
 *
 */
public abstract class CassandraDaoBase {

	//@Autowired
	protected Session session;

}
