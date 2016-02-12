package jp.ne.yohira.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/webjars/**", "/css/**", "/img/**", "/js/**", "/lib/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		permitPagesConfigure(http);
		loginConfigure(http);
		logoutHandleConfigure(http);
	}

	private void permitPagesConfigure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest()
				.authenticated();
	}

	private void loginConfigure(HttpSecurity http) throws Exception {
		http.formLogin().loginProcessingUrl("/dologin").loginPage("/login").failureUrl("/login?error")
				.defaultSuccessUrl("/alonetwitter/", true).usernameParameter("username").passwordParameter("password");
	}

	private void logoutHandleConfigure(HttpSecurity http) throws Exception {
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**")).logoutSuccessUrl("/login");
	}

	@Configuration
	static class AuthenticationConfigration extends GlobalAuthenticationConfigurerAdapter {

		@Autowired
		private UserDetailsService service;

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(service).passwordEncoder(passwordEncoder());
		}

	}
}