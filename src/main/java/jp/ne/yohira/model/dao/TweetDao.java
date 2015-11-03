package jp.ne.yohira.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import jp.ne.yohira.model.dto.TweetDto;

@Repository
public class TweetDao implements TweetDaoSpec {

	@Override
	public List<TweetDto> getTweets() {
		// TODO 自動生成されたメソッド・スタブ
		return Lists.newArrayList();
	}

	@Override
	public void delete(long postId) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void createTweet(TweetDto dto) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
