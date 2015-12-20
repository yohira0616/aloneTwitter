package jp.ne.yohira.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * jdbcのコネクションを渡すために必要なBaseDao
 * これを継承したDaoはgetDataSourceでDBとのコネクションを取得できる。
 */
public abstract class JdbcDaoBase extends JdbcDaoSupport {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	protected JdbcTemplate getTemplate() {
		return jdbcTemplate;
	}

}
