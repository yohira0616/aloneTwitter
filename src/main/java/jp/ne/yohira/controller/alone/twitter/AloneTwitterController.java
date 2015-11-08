package jp.ne.yohira.controller.alone.twitter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jp.ne.yohira.model.dto.TweetDto;
import jp.ne.yohira.model.param.TweetInsParam;
import jp.ne.yohira.model.service.AloneTwitterServiceSpec;

@RequestMapping("/alonetwitter")
@Controller
public class AloneTwitterController {

	@Autowired
	private AloneTwitterServiceSpec aloneTwitterService;

	@RequestMapping("/")
	public String show(Model model) {
		model.addAttribute("appTitle", "AloneTwitter");
		return "./twitter/twitter";
	}

	@RequestMapping("/getTweets")
	@ResponseBody
	public List<TweetDto> getTweets(Model model) {
		return aloneTwitterService.getTweets();
	}

	@RequestMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void create(Model model, @RequestBody TweetInsParam param) {
		aloneTwitterService.insert(param);
		System.out.println("insert done!");
	}

	@RequestMapping(value = "/delete/{postId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(Model model, @PathVariable long postId) {
		aloneTwitterService.delete(postId);
	}

}
