package jp.ne.yohira.model.dao;

import java.util.List;

import jp.ne.yohira.common.CassandraDaoBase;
import jp.ne.yohira.model.dto.TweetDto;

/**
 * Cassanra用のDao
 *
 */
//@Repository
public class TweetDaoCassandra extends CassandraDaoBase implements TweetDaoSpec {

	@Override
	public List<TweetDto> getTweets() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void delete(long postId) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void createTweet(TweetDto dto) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public long getNewPostId() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
