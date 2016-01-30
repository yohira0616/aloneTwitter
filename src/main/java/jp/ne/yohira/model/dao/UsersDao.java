package jp.ne.yohira.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import jp.ne.yohira.common.JdbcDaoBase;
import jp.ne.yohira.model.dto.UsersDto;

@Repository
public class UsersDao extends JdbcDaoBase implements UsersDaoSpec {

	@Autowired
	public UsersDao(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<UsersDto> fetchAllUsers() {
		String sql = "SELECT USER_ID,PASSWD FROM USERS";
		MappingSqlQuery<UsersDto> query = new MappingSqlQuery<UsersDto>(getDataSource(), sql) {

			@Override
			protected UsersDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				UsersDto result = new UsersDto();
				result.setUserId(rs.getString("user_id"));
				result.setPasswd(rs.getString("passwd"));
				return result;
			}
		};
		return query.execute();
	}

	@Override
	public UsersDto findByUserId(String userId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void createUser(UsersDto user) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(String userId) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
