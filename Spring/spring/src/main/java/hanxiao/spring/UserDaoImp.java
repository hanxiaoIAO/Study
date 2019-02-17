package hanxiao.spring;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoImp extends JdbcDaoSupport implements UserDao{
	

	@Override
	public void addUser() {
		System.out.println("addUser");
	}
	
	public void printUser() {
		List<Map<String,Object>> dataTable = getJdbcTemplate().queryForList("select * from user");
		for(Map<String,Object> row:dataTable) {
			System.out.println(row.get("name"));
		}
	}

}
