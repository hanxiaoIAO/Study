package hanxiao.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJdbc {

	@Test
	public void jdbc() throws Throwable {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanxiao", "root", "root");
		Statement statement = conn.createStatement();
		ResultSet rst = statement.executeQuery("select * from user");
		while(rst.next()) {
			System.out.println(rst.getString("name"));
		}
	}
	
	@Test
	public void dbcp() throws Throwable {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/hanxiao");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dataSource.getConnection();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		List<Map<String,Object>> dataTable = jdbcTemplate.queryForList("select * from user");
		for(Map<String,Object> row:dataTable) {
			System.out.println(row.get("name"));
		}
//		Connection conn = dataSource.getConnection();
//		Statement statement = conn.createStatement();
//		ResultSet rst = statement.executeQuery("select * from user");
//		while(rst.next()) {
//			System.out.println(rst.getString("name"));
//		}
	}
}
