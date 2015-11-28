package jp.ne.yohira.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcのコネクションを渡すために必要なBaseDao
 * これを継承したDaoはgetDataSourceでDBとのコネクションを取得できる。
 */
public abstract class DaoBase {

	@Autowired
	protected JdbcTemplate template;

	protected DataSource getDataSource() {
		return template.getDataSource();
	}

	protected JdbcTemplate getTemplate() {
		return template;
	}

}
