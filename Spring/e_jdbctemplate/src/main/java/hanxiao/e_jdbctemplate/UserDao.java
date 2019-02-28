package hanxiao.e_jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addUser(int id,String name) {
		jdbcTemplate.update("insert into user(id,name) values(?,?)",id,name);
	}
	
}
