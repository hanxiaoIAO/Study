package hanxiao.spring.a_iocdi;

public class Category {
	public Category() {
		System.out.println("new Category");
	}
	
	private int id;
	private String code;
	private String name;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

	public void setId(int id) {
		this.id = id;
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
}
