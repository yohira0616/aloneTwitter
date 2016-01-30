package jp.ne.yohira.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ne.yohira.model.dao.UsersDaoSpec;
import jp.ne.yohira.model.dto.UsersDto;

@Service
public class UsersService implements UsersServiceSpec {

	@Autowired
	private UsersDaoSpec dao;

	@Override
	public void create(UsersDto user) {
		dao.createUser(user);
	}

}
