package jp.ne.yohira.cmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import jp.ne.yohira.model.dao.UsersDaoSpec;
import jp.ne.yohira.model.dto.UsersDto;

@Component
public class TestUserMaker implements CommandLineRunner {

	@Autowired
	private UsersDaoSpec dao;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void run(String... args) throws Exception {
		makeDummyUser().stream().forEach((user) -> {
			dao.createUser(user);
		});
	}

	private List<UsersDto> makeDummyUser() {
		List<UsersDto> users = Lists.newArrayList();
		users.add(new UsersDto("testuser", encoder.encode("test")));
		users.add(new UsersDto("admin", encoder.encode("admin")));
		users.add(new UsersDto("user1", encoder.encode("user1")));
		return users;
	}

}
