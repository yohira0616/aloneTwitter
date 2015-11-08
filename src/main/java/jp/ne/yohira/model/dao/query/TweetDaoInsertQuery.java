package jp.ne.yohira.model.dao.query;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import jp.ne.yohira.model.dto.TweetDto;

public class TweetDaoInsertQuery extends SqlUpdate {

	private static final String INSERT_SQL = "INSERT INTO tweet(post_id,contents,prc_date) VALUES (?,?,current_timestamp)";

	public TweetDaoInsertQuery(DataSource ds) {
		super(ds, INSERT_SQL);
		declareParameter(new SqlParameter(Types.INTEGER));
		declareParameter(new SqlParameter(Types.VARCHAR));
		compile();
	}

	public void create(TweetDto dto) {
		Object[] bind = {
				Long.valueOf(dto.getPostId()), dto.getContents()
		};
		super.update(bind);
	}

}
