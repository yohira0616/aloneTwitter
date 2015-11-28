package jp.ne.yohira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Cassandraへの接続コネクションを設定する
 * @author yukito ohira
 *
 */
@Configuration
public class CassandraDataSource {

	@Bean
	public Session getSession() {
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		return cluster.connect();
	}

}
