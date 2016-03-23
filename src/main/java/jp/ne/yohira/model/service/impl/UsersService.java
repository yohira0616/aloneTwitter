package jp.ne.yohira.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ne.yohira.model.dao.spec.UsersDaoSpec;
import jp.ne.yohira.model.dto.UsersDto;
import jp.ne.yohira.model.service.spec.UsersServiceSpec;

@Service
public class UsersService implements UsersServiceSpec {

	@Autowired
	private UsersDaoSpec dao;

	@Override
	public void create(UsersDto user) {
		dao.createUser(user);
	}

	@Override
	public List<UsersDto> getAllUser() {
		return dao.fetchAllUsers();
	}

}
