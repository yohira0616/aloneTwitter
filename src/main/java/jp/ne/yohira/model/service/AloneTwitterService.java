package jp.ne.yohira.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ne.yohira.model.dao.TweetDaoSpec;
import jp.ne.yohira.model.dto.TweetDto;

@Service
public class AloneTwitterService implements AloneTwitterServiceSpec {

	@Autowired
	private TweetDaoSpec tweetDao;

	@Override
	public List<TweetDto> getTweets() {
		return tweetDao.getTweets();
	}

	@Override
	public void insert(TweetDto dto) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(long postId) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
