package hanxiao.spring;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED )
public class AccountServiceImp implements AccountService {
	
	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String inner, String outer, int money) {
		accountDao.in(inner, money);
		int i = 1/0;
		accountDao.out(outer, money);
	}

}
