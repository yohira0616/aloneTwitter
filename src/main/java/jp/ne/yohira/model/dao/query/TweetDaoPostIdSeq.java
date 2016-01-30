package jp.ne.yohira.model.dao.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

//FIXME ありえないシーケンスの取り方
public class TweetDaoPostIdSeq extends MappingSqlQuery<Long> {

	private static final String getSeqSql = "SELECT post_id FROM tweet order by post_id desc";

	public TweetDaoPostIdSeq(DataSource ds) {
		super(ds, getSeqSql);
	}

	@Override
	protected Long mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getLong(1);
	}

}
