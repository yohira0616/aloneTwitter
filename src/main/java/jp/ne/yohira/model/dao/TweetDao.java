package jp.ne.yohira.model.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import jp.ne.yohira.common.DaoBase;
import jp.ne.yohira.model.dao.query.TweetDaoDeleteQuery;
import jp.ne.yohira.model.dao.query.TweetDaoInsertQuery;
import jp.ne.yohira.model.dao.query.TweetDaoPostIdSeq;
import jp.ne.yohira.model.dao.query.TweetDaoSelectQuery;
import jp.ne.yohira.model.dto.TweetDto;

@Repository
public class TweetDao extends DaoBase implements TweetDaoSpec {

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

	@SuppressWarnings("unused")
	private List<TweetDto> getMock() {
		List<TweetDto> tweets = Lists.newArrayList();
		TweetDto dto = new TweetDto();
		dto.setPostId(0);
		dto.setContents("This is Test Contents");
		dto.setPrcDate(Calendar.getInstance().getTime());
		tweets.add(dto);
		return tweets;
	}

	@Override
	public long getNewPostId() {
		Long lastId = new TweetDaoPostIdSeq(getDataSource()).execute().get(0);
		return lastId++;
	}

}
