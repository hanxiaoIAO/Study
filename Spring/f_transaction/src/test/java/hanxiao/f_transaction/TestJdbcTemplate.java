package hanxiao.f_transaction;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hanxiao.f_transaction.AccountService;

public class TestJdbcTemplate {

	@Test
	public void testTrans() {
		String configLocation = "applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.trans("theo", "hanxiao", 10);
		applicationContext.close();
	}
}
