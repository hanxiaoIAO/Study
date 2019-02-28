package hanxiao.spring.c_aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hanxiao.spring.d_aop_annotation.Operator;
import hanxiao.spring.d_aop_annotation.Role;

public class TestAop {
	@Test
	public void testAop() {
		String configLocation = "applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
		Operator operator = (Operator) applicationContext.getBean("operator");
		operator.addOperator();
		
		Role role = (Role) applicationContext.getBean("role");
		role.addRole();
		
		applicationContext.close();
	}

}
