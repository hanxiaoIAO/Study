package hanxiao.spring;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImp extends JdbcDaoSupport implements AccountDao {

	@Override
	public void in(String inner, int money) {
		getJdbcTemplate().update("update account set money=money+? where username=?", money,inner);
	}
	@Override
	public void out(String outer, int money) {
		getJdbcTemplate().update("update account set money=money-? where username=?", money,outer);
	}

}
