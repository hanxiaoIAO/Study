package hanxiao.e_jdbctemplate;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbcTemplate {

	@Test
	public void testJdbcTemplate() {
		String configLocation = "applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		userDao.addUser(1, "theo");
		
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		accountDao.addAccount(2, "hanxiao", 100);
		applicationContext.close();
	}
}
