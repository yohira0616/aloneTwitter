package jp.ne.yohira.model.dao.query;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class TweetDaoDeleteQuery extends SqlUpdate {

	private static final String DELETE_SQL = "DELETE FROM tweet WHERE post_id = ?";

	public TweetDaoDeleteQuery(DataSource ds) {
		super(ds, DELETE_SQL);
		declareParameter(new SqlParameter("post_id", Types.INTEGER));
		compile();
	}

	public void delete(long postId) {
		update(postId);
	}

}
