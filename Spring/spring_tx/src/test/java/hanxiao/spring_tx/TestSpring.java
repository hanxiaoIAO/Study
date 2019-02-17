package hanxiao.spring_tx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hanxiao.spring.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestSpring {
	@Autowired
	private AccountService acccountService;
	
	@Test
	public void testTransfer() {
//		String configLocation = "applicationContext.xml";
//		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(configLocation);
//		AccountService acccountService = (AccountService)application.getBean("accountService");
		acccountService.transfer("jack", "rose", 1000);
//		application.close();
	}
	
}
