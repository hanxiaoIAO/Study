package hanxiao.spring.a_iocdi;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIocDi {
	
	@Test
	public void tesiIocDi() {
		String configLocation = "applicationContext.xml";
		
		System.out.println("BeanFactory采取延迟加载，第一次getBean时才会初始化Bean");
		System.out.println("ClassPathXmlApplicationContext是的子接口,当配置文件被加载，就进行对象实例化");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		
		Material material = (Material)context.getBean("material");
		System.out.println(material.toString());
		
		System.out.println();
		//工厂
		Material materialFromFactory = (Material)context.getBean("materialFromFactory");
		System.out.println(materialFromFactory.getCategory().getName());
		//静态工厂
		Category categoryFromFactory = (Category)context.getBean("categoryFromFactory");
		System.out.println(categoryFromFactory.getName());
		
		System.out.println();
		//单例、多例
		Material material_1 = (Material)context.getBean("material");
		Material material_2 = (Material)context.getBean("material");
		System.out.println("material_1:"+material_1.hashCode());
		System.out.println("material_2:"+material_2.hashCode());
		Material autoMaterial_1 = (Material) context.getBean("autoMaterial");
		Material autoMaterial_2 = (Material) context.getBean("autoMaterial");
		System.out.println("autoMaterial_1:"+autoMaterial_1.hashCode());
		System.out.println("autoMaterial_2:"+autoMaterial_2.hashCode());
		
		//构造函数
		Material material_construct = (Material) context.getBean("material_construct");
		System.out.println(material_construct.toString());
		
		//集合注入
		Material material_collection = (Material) context.getBean("material_collection");
		List<String> plants = material_collection.getPlants();
		for(String plant:plants) {
			System.out.println(plant);
		}
		
		//生命周期
		PurchaseDao purchaseDao = (PurchaseDao) context.getBean("purchaseDao");
		purchaseDao.query();
		context.close();
	}

}
