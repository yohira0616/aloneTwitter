package jp.ne.yohira.model.auth;

import jp.ne.yohira.model.dto.UsersDto;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class UsersDetails extends User {

	private static final long serialVersionUID = 1L;

	private UsersDto user;

	public UsersDetails(UsersDto user) {
		super(user.getUserId(), user.getPasswd(), AuthorityUtils
				.createAuthorityList("ROLE_USER"));
		this.user = user;
	}

	public UsersDto getUser() {
		return user;
	}

}
