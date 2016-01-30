package jp.ne.yohira.model.auth;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import jp.ne.yohira.model.dto.UsersDto;

public class UsersDetails extends User {

	private UsersDto user;

	public UsersDetails(UsersDto user) {
		super(user.getUserId(), user.getPasswd(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}

	public UsersDto getUser() {
		return user;
	}

}
