package jp.ne.yohira.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TweetDto {

	private long postId;
	private String contents;
	private Date prcDate;

}
