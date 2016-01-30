package jp.ne.yohira.model.dto;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class UsersDto {

	@Id
	private String userId;
	private String passwd;

}
