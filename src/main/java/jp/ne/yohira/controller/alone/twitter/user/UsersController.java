package jp.ne.yohira.controller.alone.twitter.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.ne.yohira.model.dto.UsersDto;
import jp.ne.yohira.model.service.UsersServiceSpec;

@RequestMapping("/user")
@RestController
public class UsersController {

	@Autowired
	private UsersServiceSpec usersService;

	@RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void createUser(@RequestBody UsersDto user) {
		usersService.create(user);
	}

	@RequestMapping("/userlist")
	public List<UsersDto> getUsers() {
		return usersService.getAllUser();
	}

}
