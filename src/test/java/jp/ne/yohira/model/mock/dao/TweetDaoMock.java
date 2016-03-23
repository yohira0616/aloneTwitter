package jp.ne.yohira.model.mock.dao;

import java.util.Calendar;
import java.util.List;

import com.google.common.collect.Lists;

import jp.ne.yohira.model.dao.spec.TweetDaoSpec;
import jp.ne.yohira.model.dto.TweetDto;

public class TweetDaoMock implements TweetDaoSpec {

	@Override
	public List<TweetDto> getTweets() {
		List<TweetDto> mock = Lists.newArrayList();
		TweetDto dto = new TweetDto();
		dto.setPostId(0);
		dto.setContents("mock");
		dto.setPrcDate(Calendar.getInstance().getTime());
		mock.add(dto);
		return mock;
	}

	@Override
	public void delete(long postId) {

	}

	@Override
	public void createTweet(TweetDto dto) {

	}

	@Override
	public long getNewPostId() {
		return 1;
	}

}
