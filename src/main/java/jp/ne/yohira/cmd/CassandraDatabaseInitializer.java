package jp.ne.yohira.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.datastax.driver.core.Session;

public class CassandraDatabaseInitializer implements CommandLineRunner {

	@Autowired
	private Session cassandra;

	@Override
	public void run(String... args) throws Exception {
		//String cql="DROP "

	}

}
