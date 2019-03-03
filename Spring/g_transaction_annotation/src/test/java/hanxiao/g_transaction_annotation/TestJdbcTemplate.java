package hanxiao.g_transaction_annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hanxiao.g_transaction_annotation.AccountService;

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
