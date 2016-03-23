package jp.ne.yohira.model.dao.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

public class TweetDaoPostIdSeq extends MappingSqlQuery<Long> {

	private static final String SEQ_SQL = "SELECT nextval('tweet_post_id_seq')";

	public TweetDaoPostIdSeq(DataSource ds) {
		super(ds, SEQ_SQL);
	}

	@Override
	protected Long mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getLong(1);
	}

}
