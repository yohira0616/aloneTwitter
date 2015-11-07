package jp.ne.yohira.model.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import jp.ne.yohira.model.dto.TweetDto;

@Repository
public class TweetDao implements TweetDaoSpec {

	@Override
	public List<TweetDto> getTweets() {
		//TweetDaoSelectQuery query = new TweetDaoSelectQuery();
		//query.execute();
		return getMock();
	}

	@Override
	public void delete(long postId) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void createTweet(TweetDto dto) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private List<TweetDto> getMock() {
		List<TweetDto> tweets = Lists.newArrayList();
		TweetDto dto = new TweetDto();
		dto.setPostId(0);
		dto.setContents("This is Test Contents");
		dto.setPrcDate(Calendar.getInstance().getTime());
		tweets.add(dto);
		return tweets;
	}

}
