package jp.ne.yohira.model.dao.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import jp.ne.yohira.model.dto.TweetDto;

public class TweetDaoSelectQuery extends MappingSqlQuery<TweetDto> {

	private static final String SELECT_SQL = "SELECT post_id,contents,prc_date FROM tweet ORDER BY PRC_DATE DESC";

	public TweetDaoSelectQuery(DataSource ds) {
		super(ds, SELECT_SQL);
	}

	@Override
	protected TweetDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TweetDto dto = new TweetDto();
		dto.setPostId(rs.getLong("POST_ID"));
		dto.setContents(rs.getString("CONTENTS"));
		dto.setPrcDate(rs.getDate("PRC_DATE"));
		return dto;
	}

}
