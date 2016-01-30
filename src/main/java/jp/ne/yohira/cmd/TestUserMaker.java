package jp.ne.yohira.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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
		UsersDto testuser = new UsersDto();
		testuser.setUserId("testuser");
		testuser.setPasswd(encoder.encode("test"));
		dao.createUser(testuser);
	}

}
