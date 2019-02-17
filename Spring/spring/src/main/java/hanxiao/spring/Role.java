package hanxiao.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("role")
public class Role {
	
	@Value("Administrator")
	private String name;

	@Autowired
	private List<UserModel> userModelList;

	public void setUserModelList(List<UserModel> userModelList) {
		this.userModelList = userModelList;
	}

	public List<UserModel> getUserModelList() {
		return userModelList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
