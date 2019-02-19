package hanxiao.spring.b_iocdi_annotion;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hanxiao.spring.b_iocdi_annotion.Material;
import hanxiao.spring.b_iocdi_annotion.PurchaseDao;

public class TestIocDi_Annotation {
	
	@Test
	public void tesiIocDi_Annotation() {
		String configLocation = "applicationContext.xml";
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		
		Material material = (Material)context.getBean("material");
		System.out.println(material.toString());
		
		//生命周期
		PurchaseDao purchaseDao = (PurchaseDao) context.getBean("purchaseDao");
		purchaseDao.query();
		context.close();
	}

}
