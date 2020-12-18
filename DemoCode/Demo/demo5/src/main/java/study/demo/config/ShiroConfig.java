package study.demo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
	
	@Autowired
	public CustomRealm customRealm;
	
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
		defaultSecurityManager.setRealm(customRealm);
		return defaultSecurityManager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
		
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/notRole", "anon");
		filterChainDefinitionMap.put("/libs/**", "anon");
		
		filterChainDefinitionMap.put("/", "authc");
		filterChainDefinitionMap.put("/vip", "authc");
		filterChainDefinitionMap.put("/vip", "roles[Admin]");
//		filterChainDefinitionMap.put("/notRole", "perms[admin:notRole]");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;

	}
	
    /**
     * 开启注解
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);

        return authorizationAttributeSourceAdvisor;
    }

}
