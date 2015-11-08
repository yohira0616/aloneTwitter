package jp.ne.yohira.model.service;

import java.util.List;

import jp.ne.yohira.model.dto.TweetDto;
import jp.ne.yohira.model.param.TweetInsParam;

/**
 * alone twitter service
 *
 */
public interface AloneTwitterServiceSpec {

	/**
	 * ポストを全て取得
	 */
	public List<TweetDto> getTweets();

	/**
	 * 新しいポストを追加
	 * @param dto
	 */
	public void insert(TweetInsParam param);

	/**
	 * ポストを削除
	 * @param postId
	 */
	public void delete(long postId);
}
