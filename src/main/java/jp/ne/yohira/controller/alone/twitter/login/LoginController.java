package jp.ne.yohira.controller.alone.twitter.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class LoginController {

	@RequestMapping("login")
	public String loginHome() {
		return "login";
	}

}
