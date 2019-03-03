package hanxiao.f_transaction;

public class AccountService {
	private AccountDao accountDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void trans(String outer,String inner,int money) {
		accountDao.out(outer, money);
		int i=1/0;
		accountDao.in(inner, money);
	}

}
