package hanxiao.spring.d_aop_annotation;

import org.springframework.stereotype.Component;

@Component("role")
public class Role {
	public void addRole() {
		System.out.println("add role");
	}
	
	public void modifyRole() {
		System.out.println("modify role");
	}
	
	public void deleteRole() {
		System.out.println("delete role");
	}
	
}
