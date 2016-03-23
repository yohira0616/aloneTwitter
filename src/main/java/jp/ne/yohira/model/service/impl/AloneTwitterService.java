package jp.ne.yohira.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ne.yohira.model.dao.spec.TweetDaoSpec;
import jp.ne.yohira.model.dto.TweetDto;
import jp.ne.yohira.model.service.spec.AloneTwitterServiceSpec;

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
	public void insert(String contents) {
		TweetDto dto = new TweetDto();
		dto.setPostId(tweetDao.getNewPostId());
		dto.setContents(contents);
		tweetDao.createTweet(dto);
	}

}
