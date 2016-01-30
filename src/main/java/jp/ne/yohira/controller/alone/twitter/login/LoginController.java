package jp.ne.yohira.controller.alone.twitter.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@Controller
public class LoginController {

	@RequestMapping("/")
	public String loginHome() {
		return "login";
	}

}
