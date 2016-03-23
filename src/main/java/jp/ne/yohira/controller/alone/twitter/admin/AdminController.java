package jp.ne.yohira.controller.alone.twitter.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@RequestMapping("/")
	public String index() {
		return "admin/index";
	}

}
