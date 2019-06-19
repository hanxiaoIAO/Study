package hanxiao.springboot.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroService {
	
	public Subject getSubject() {
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		DatabaseRealm databaseRealm = new DatabaseRealm();
        defaultSecurityManager.setRealm(databaseRealm);
        
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        return SecurityUtils.getSubject();
	}
	
	public boolean hasRole(User user,String role) {
		Subject subject = getSubject();
		return subject.hasRole(role);
	}
	public boolean isPermitted(String permission) {
		Subject subject = getSubject();
		return subject.isPermitted(permission);
	}
	
	public boolean login(User user) {
		Subject subject = getSubject();
		if(subject.isAuthenticated()) {
			subject.logout();
		}
		
		UsernamePasswordToken token  = new UsernamePasswordToken(user.getName(), user.getPassword());
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			return false;
		}
		return subject.isAuthenticated();
		
	}

}
