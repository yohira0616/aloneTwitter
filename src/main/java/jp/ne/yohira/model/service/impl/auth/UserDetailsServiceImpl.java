package jp.ne.yohira.model.service.impl.auth;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.ne.yohira.model.auth.UsersDetails;
import jp.ne.yohira.model.dao.spec.UsersDaoSpec;
import jp.ne.yohira.model.dto.UsersDto;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersDaoSpec usersDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersDto user = usersDao.findByUserId(username);
		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException("user is not found");
		}
		return new UsersDetails(user);
	}

}
