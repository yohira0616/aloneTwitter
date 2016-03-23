package jp.ne.yohira.model.service.spec;

import java.util.List;

import jp.ne.yohira.model.dto.UsersDto;

public interface UsersServiceSpec {

	public void create(UsersDto user);

	public List<UsersDto> getAllUser();

}
