package hanxiao.e_jdbctemplate;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDao extends JdbcDaoSupport{
	
	public void addAccount(int id,String userName,int money) {
		getJdbcTemplate().update("insert into account(id,username,money) values(?,?,?)",id,userName,money);
	}

}
