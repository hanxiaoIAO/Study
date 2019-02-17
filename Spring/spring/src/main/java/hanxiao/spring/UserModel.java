package hanxiao.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userModel")
public class UserModel {
	private String name;
	private String id;
	
	@Autowired
	public UserModel(@Value("1") String id,@Value("1") String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
