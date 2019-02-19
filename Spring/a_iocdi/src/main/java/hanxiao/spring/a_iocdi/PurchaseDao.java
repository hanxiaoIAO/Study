package hanxiao.spring.a_iocdi;

public class PurchaseDao {
	
	public PurchaseDao() {
		System.out.println("new PurchaseDao");
	}
	
	public void createConnect() {
		System.out.println("创建连接");
	}
	
	public void closeConnect() {
		System.out.println("连接关闭");
	}

	public void query() {
		System.out.println("查询");
	}

}
