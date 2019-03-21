package helloshiro;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hanxiao.shiro.ShiroService;
import hanxiao.shiro.User;

public class TestShiro {

	@Test
	public void testShiro() {
		// 用户们
		User zhang3 = new User();
		zhang3.setName("zhang3");
		zhang3.setPassword("12345");

		User li4 = new User();
		li4.setName("li4");
		li4.setPassword("abcde");

		User wang5 = new User();
		wang5.setName("wang5");
		wang5.setPassword("wrongpassword");

		List<User> users = new ArrayList<>();

		users.add(zhang3);
		users.add(li4);
		users.add(wang5);

		// 角色们
		String roleAdmin = "admin";
		String roleProductManager = "productManager";

		List<String> roles = new ArrayList<>();
		roles.add(roleAdmin);
		roles.add(roleProductManager);

		// 权限们
		String permitAddProduct = "addProduct";
		String permitAddOrder = "addOrder";

		List<String> permits = new ArrayList<>();
		permits.add(permitAddProduct);
		permits.add(permitAddOrder);

		ShiroService shiroService = new ShiroService();

		for (User user : users) {
			for (String permit : permits) {
				if (shiroService.login(user)) {
					if (shiroService.isPermitted(permit))
						System.out.printf("%s\t 拥有权限: %s\t%n", user.getName(), permit);
					else
						System.out.printf("%s\t 不拥有权限: %s\t%n", user.getName(), permit);
				} else {
					System.out.printf("%s \t登陆失败，用的密码是 %s\t %n", user.getName(), user.getPassword());
				}
			}
		}

	}
}
