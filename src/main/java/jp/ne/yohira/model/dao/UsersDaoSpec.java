package jp.ne.yohira.model.dao;

import java.util.List;

import jp.ne.yohira.model.dto.UsersDto;

public interface UsersDaoSpec {

	public List<UsersDto> fetchAllUsers();

	public UsersDto findByUserId(String userId);

	public void createUser(UsersDto user);

	public void delete(String userId);

}
