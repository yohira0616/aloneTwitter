package jp.ne.yohira.model.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.ne.yohira.common.JdbcDaoBase;
import jp.ne.yohira.model.dto.UsersDto;

@Repository
public class UsersDao extends JdbcDaoBase implements UsersDaoSpec {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final String SELECT_ALL_SQL = "SELECT user_id,passwd FROM users";

	private static final String SELECT_BYID_SQL = "SELECT user_id,passwd FROM users WHERE user_id=:user_id";

	private static final String INSERT_SQL = "INSERT INTO users(user_id,passwd) VALUES(:user_id,:passwd)";

	private static final String DELETE_SQL = "DELETE FROM users WHERE user_id=:user_id";

	private static final RowMapper<UsersDto> usersDaoMapper = (rs, rowNum) -> {
		UsersDto result = new UsersDto();
		result.setUserId(rs.getString("user_id"));
		result.setPasswd(rs.getString("passwd"));
		return result;
	};

	@Autowired
	public UsersDao(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<UsersDto> fetchAllUsers() {
		return namedParameterJdbcTemplate.query(SELECT_ALL_SQL, usersDaoMapper);
	}

	@Override
	public UsersDto findByUserId(String userId) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("user_id", userId);
		return namedParameterJdbcTemplate.queryForObject(SELECT_BYID_SQL, param, usersDaoMapper);
	}

	@Override
	public void createUser(UsersDto user) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("user_id", user.getUserId()).addValue("passwd",
				user.getPasswd());
		namedParameterJdbcTemplate.update(INSERT_SQL, param);

	}

	@Override
	public void delete(String userId) {
		namedParameterJdbcTemplate.update(DELETE_SQL, new MapSqlParameterSource().addValue("user_id", userId));
	}

}
