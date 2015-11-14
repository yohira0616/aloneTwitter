package jp.ne.yohira;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class AloneTwitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AloneTwitterApplication.class, args);
	}

	@Bean
	public Filter characterEncondingFileter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
}
