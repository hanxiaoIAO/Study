package hanxiao.spring.a_iocdi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("purchaseDao")) {
			System.out.println("postProcessBeforeInitialization");
		}
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("purchaseDao")) {
			System.out.println("postProcessAfterInitialization");
		}
		return bean;
	}

}
