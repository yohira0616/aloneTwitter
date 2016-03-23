package jp.ne.yohira.model.dao.spec;

import java.util.List;

import jp.ne.yohira.model.dto.TweetDto;

public interface TweetDaoSpec {

	public List<TweetDto> getTweets();

	public void delete(long postId);

	public void createTweet(TweetDto dto);

	public long getNewPostId();

}
