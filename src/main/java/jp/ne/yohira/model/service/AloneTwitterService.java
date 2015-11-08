package jp.ne.yohira.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ne.yohira.model.dao.TweetDaoSpec;
import jp.ne.yohira.model.dto.TweetDto;
import jp.ne.yohira.model.param.TweetInsParam;

@Service
public class AloneTwitterService implements AloneTwitterServiceSpec {

	@Autowired
	private TweetDaoSpec tweetDao;

	@Override
	public List<TweetDto> getTweets() {
		return tweetDao.getTweets();
	}

	@Override
	public void delete(long postId) {
		tweetDao.delete(postId);
	}

	@Override
	public void insert(TweetInsParam param) {
		TweetDto dto = new TweetDto();
		dto.setPostId(tweetDao.getNewPostId());
		dto.setContents(param.getContents());
		tweetDao.createTweet(dto);
	}

}
