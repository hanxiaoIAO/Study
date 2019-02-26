package hanxiao.spring.b_iocdi_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("category")
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

	@Value("1")
	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	@Value("category")
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	
	@Value("类别")
	public void setName(String name) {
		this.name = name;
	}
}
