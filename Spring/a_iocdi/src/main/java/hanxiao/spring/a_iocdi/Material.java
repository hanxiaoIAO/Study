package hanxiao.spring.a_iocdi;

import java.util.List;

public class Material {
	
	public Material() {
		System.out.println("new Material");
	}
	
	public Material(String code,String name,Category category) {
		this.code = code;
		this.name = name;
		this.category = category;
	}
	
	public List<String> plants;
	

	public List<String> getPlants() {
		return plants;
	}

	public void setPlants(List<String> plants) {
		this.plants = plants;
	}

	private int id;
	private String code;
	private String name;

	Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", code=" + code + ", name=" + name + ", category=" + category.getCode() + " "
				+ category.getName() + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
