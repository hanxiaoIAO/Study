package hanxiao.h_junit;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDao extends JdbcDaoSupport{
	
	public void addAccount(int id,String userName,int money) {
		getJdbcTemplate().update("insert into account(id,username,money) values(?,?,?)",id,userName,money);
	}
	
	public void out(String outer, Integer money) {
		this.getJdbcTemplate().update("update account set money = money - ? where username = ?", money,outer);
	}

	public void in(String inner, Integer money) {
		this.getJdbcTemplate().update("update account set money = money + ? where username = ?", money,inner);
	}


}
