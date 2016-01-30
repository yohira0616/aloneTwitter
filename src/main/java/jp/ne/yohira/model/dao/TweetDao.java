package jp.ne.yohira.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import jp.ne.yohira.model.dao.query.TweetDaoPostIdSeq;
import jp.ne.yohira.model.dto.TweetDto;

@Primary
@Repository
public class TweetDao extends JdbcDaoSupport implements TweetDaoSpec {

	private static final String SELECT_SQL = "SELECT post_id,contents,prc_date FROM tweet ORDER BY PRC_DATE DESC";

	private static final String DELETE_SQL = "DELETE FROM tweet WHERE post_id = :post_id";

	private static final String INSERT_SQL = "INSERT INTO tweet(post_id,contents,prc_date) VALUES (:post_id,:contents,current_timestamp)";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static RowMapper<TweetDto> mapper = (rs, rowNum) -> {
		TweetDto result = new TweetDto();
		result.setPostId(rs.getInt("POST_ID"));
		result.setContents(rs.getString("CONTENTS"));
		result.setPrcDate(rs.getDate("PRC_DATE"));
		return result;
	};

	@Autowired
	public TweetDao(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<TweetDto> getTweets() {
		return jdbcTemplate.query(SELECT_SQL, mapper);
	}

	@Override
	public void delete(long postId) {
		jdbcTemplate.update(DELETE_SQL, new MapSqlParameterSource().addValue("post_id", postId));
	}

	@Override
	public void createTweet(TweetDto dto) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("post_id", dto.getPostId()).addValue("contents",
				dto.getContents());
		jdbcTemplate.update(INSERT_SQL, param);
	}

	@Override
	public long getNewPostId() {
		List<Long> postIds = new TweetDaoPostIdSeq(getDataSource()).execute();
		return postIds.isEmpty() ? 0L : postIds.get(0) + 1;
	}

}
