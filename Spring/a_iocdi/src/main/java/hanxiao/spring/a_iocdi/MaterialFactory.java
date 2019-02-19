package hanxiao.spring.a_iocdi;

public class MaterialFactory {
	
	public Material newMaterial() {
		Material material = new Material();
		material.setCategory(CategoryFactory.getAutoCategory());
		return material;
	}

}
