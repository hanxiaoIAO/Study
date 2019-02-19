package hanxiao.spring.a_iocdi;

public class CategoryFactory {
	
	private static Category autoCategory;
	
	public static Category getAutoCategory() {
		if(autoCategory == null) {
			autoCategory = new Category();
			autoCategory.setId(0);
			autoCategory.setCode("Auto");
			autoCategory.setName("自动创建");
		}
		
		return autoCategory;
	}
	
	private static Category woodCategory;
	
	public static Category getWoodCategory() {
		if(woodCategory == null) {
			woodCategory = new Category();
			woodCategory.setId(0);
			woodCategory.setCode("Wood");
			woodCategory.setName("木头");
		}
		
		return woodCategory;
	}

}
