package jp.ne.yohira.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.ne.yohira.common.JdbcDaoBase;
import jp.ne.yohira.model.dao.query.TweetDaoDeleteQuery;
import jp.ne.yohira.model.dao.query.TweetDaoInsertQuery;
import jp.ne.yohira.model.dao.query.TweetDaoPostIdSeq;
import jp.ne.yohira.model.dao.query.TweetDaoSelectQuery;
import jp.ne.yohira.model.dto.TweetDto;

@Repository
public class TweetDao extends JdbcDaoBase implements TweetDaoSpec {

	@Override
	public List<TweetDto> getTweets() {
		TweetDaoSelectQuery query = new TweetDaoSelectQuery(getDataSource());
		return query.execute();
	}

	@Override
	public void delete(long postId) {
		new TweetDaoDeleteQuery(getDataSource()).delete(postId);
	}

	@Override
	public void createTweet(TweetDto dto) {
		new TweetDaoInsertQuery(getDataSource()).create(dto);
	}

	@Override
	public long getNewPostId() {
		List<Long> postIds = new TweetDaoPostIdSeq(getDataSource()).execute();
		return postIds.isEmpty() ? 0L : postIds.get(0) + 1;
	}

}
