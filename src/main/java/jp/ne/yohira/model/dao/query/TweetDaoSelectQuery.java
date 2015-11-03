package jp.ne.yohira.model.dao.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

import jp.ne.yohira.model.dto.TweetDto;

public class TweetDaoSelectQuery extends MappingSqlQuery<TweetDto> {

	@Override
	protected TweetDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TweetDto dto = new TweetDto();
		dto.setPostId(rs.getLong("POST_ID"));
		dto.setContents(rs.getString("CONTENTS"));
		dto.setPrcDate(rs.getDate("PRC_DATE"));
		return dto;
	}

}
