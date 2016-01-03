package jp.ne.yohira;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableAutoConfiguration
@ComponentScan
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
