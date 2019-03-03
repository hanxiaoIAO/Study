package hanxiao.h_junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJdbcTemplate {
	
	@Autowired
	private AccountService accountService;
	@Test
	public void testTrans() {	
		accountService.trans("theo", "hanxiao", 10);
	}
}
