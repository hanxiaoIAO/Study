package hanxiao.spring.b_iocdi_annotion;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("purchaseDao")
public class PurchaseDao {
	
	public PurchaseDao() {
		System.out.println("new PurchaseDao");
	}
	
	@PostConstruct
	public void createConnect() {
		System.out.println("创建连接");
	}
	
	@PreDestroy
	public void closeConnect() {
		System.out.println("连接关闭");
	}

	public void query() {
		System.out.println("查询");
	}

}
