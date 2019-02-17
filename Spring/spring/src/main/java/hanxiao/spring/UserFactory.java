package hanxiao.spring;

public class UserFactory {
	
	public UserService createUserService() {
		return new UserServiceImp();
	}
	
	public static UserModel createUserModel(String id,String name) {
		return new UserModel(id, name);
	} 
}
