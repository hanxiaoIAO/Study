package study.demo.config;

import java.util.Optional;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study.demo.dao.UserEntity;
import study.demo.dao.UserRepo;

@Component
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	UserRepo userRepo;
	
	/**
	 * 授权
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("-------授权--------");
		//获取登录用户名
        String code = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        Optional<UserEntity> userOpt = userRepo.findByCode(code);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(userOpt.get().getRole().getCode());
//        simpleAuthorizationInfo.addStringPermission("admin");
        return simpleAuthorizationInfo;
	}

	/**
	 * 身份认证/登录(账号密码验证)
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("-------身份认证方法--------");
		 UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
	        String username = upToken.getUsername();
	        String password = new String(upToken.getPassword());

        return new SimpleAuthenticationInfo(username, password,getName());
	}

}
