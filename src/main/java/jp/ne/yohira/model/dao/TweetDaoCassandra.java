package jp.ne.yohira.model.dao;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.google.common.collect.Lists;

import jp.ne.yohira.common.CassandraDaoBase;
import jp.ne.yohira.model.dto.TweetDto;

@Primary
@Repository
public class TweetDaoCassandra extends CassandraDaoBase implements TweetDaoSpec {

	private String SELECT_CQL = "SELECT post_id,contents,prc_date FROM tweet;";
	private String INSERT_CQL = "INSERT INTO tweet (post_id,contents,prc_date) VALUES (?,?,dateof(now()));";
	private String DELETE_CQL = "DELETE FROM tweet where post_id=?";

	@Override //FIXME contentsが正しい形式で取得できない
	public List<TweetDto> getTweets() {
		ResultSet resultSet = session.execute(SELECT_CQL);
		List<TweetDto> result = Lists.newArrayList();
		for (Row row : resultSet) {
			TweetDto dto = new TweetDto();
			dto.setPostId(row.getLong("post_id"));
			dto.setContents(row.getString("contents"));
			dto.setPrcDate(row.getDate("prc_date"));
			result.add(dto);
		}
		return result;
	}

	@Override
	public void delete(long postId) {
		PreparedStatement stmt = session.prepare(DELETE_CQL);
		BoundStatement boundStmt = new BoundStatement(stmt);
		session.execute(boundStmt.bind(postId));
	}

	@Override
	public void createTweet(TweetDto dto) {
		PreparedStatement stmt = session.prepare(INSERT_CQL);
		BoundStatement boundStmt = new BoundStatement(stmt);
		session.execute(boundStmt.bind(dto.getPostId(), dto.getContents()));
	}

	@Override
	public long getNewPostId() {
		return getTweets().size() + 1;
	}

}
