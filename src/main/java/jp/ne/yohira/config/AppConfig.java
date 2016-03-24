package jp.ne.yohira.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Autowired
	private DataSourceProperties properties;

	DataSource ds;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() throws URISyntaxException {
		String url;
		String username;
		String password;
		String databaseUrl = System.getenv("DATABASE_URL");
		if (!Objects.isNull(databaseUrl)) {
			URI dbUri = new URI(databaseUrl);
			url = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath();
			username = dbUri.getUserInfo().split(":")[0];
			password = dbUri.getUserInfo().split(":")[1];
		} else {
			url = properties.getUrl();
			username = properties.getUsername();
			password = properties.getPassword();
		}
		DataSourceBuilder builder = DataSourceBuilder.create(this.properties.getClassLoader()).url(url)
				.username(username).password(password);
		ds = builder.build();
		return ds;
	}
}
