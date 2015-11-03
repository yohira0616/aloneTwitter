package jp.ne.yohira.controller.alone.twitter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/alonetwitter")
@Controller
public class AloneTwitterController {

	@RequestMapping("/")
	public String show() {
		return "./twitter/twitter";
	}

}
