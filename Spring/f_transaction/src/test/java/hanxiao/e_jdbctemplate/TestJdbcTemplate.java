package hanxiao.e_jdbctemplate;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbcTemplate {

	@Test
	public void testJdbcTemplate() {
		String configLocation = "applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);

		applicationContext.close();
	}
}
