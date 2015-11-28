package jp.ne.yohira.common;

import org.springframework.data.cassandra.mapping.PrimaryKey;

import com.datastax.driver.mapping.annotations.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "Users")
@Data
@AllArgsConstructor
public class Users {

	@PrimaryKey
	private String key;
	private String first;
	private String last;
	private int age;

}
