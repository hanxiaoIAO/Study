package hanxiao.springboot.demo.shiro;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Bean
    public DatabaseRealm databaseRealm()
    {
        return new DatabaseRealm();
    }
    
    @Bean
    public SecurityManager securityManager(DatabaseRealm databaseRealm) {
    	DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(databaseRealm);
        
        return defaultSecurityManager;
    }
    
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
    	ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    	
    	shiroFilterFactoryBean.setSecurityManager(securityManager);
    	shiroFilterFactoryBean.setLoginUrl("/login");
    	shiroFilterFactoryBean.setUnauthorizedUrl("/login");
    	shiroFilterFactoryBean.setSuccessUrl("/index");
    	
    	Map<String,String> filterChainDefinitionMap = new HashMap<>();
    	filterChainDefinitionMap.put("/static/css/**", "anon");
    	filterChainDefinitionMap.put("/static/js/**", "anon");
    	
    	filterChainDefinitionMap.put("/login", "anon");
    	
    	filterChainDefinitionMap.put("/**", DefaultFilter.user.name());
    	
    	shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    	
    	
    	return shiroFilterFactoryBean;
    	
    }
}
