package hanxiao.springboot.shiro;

import org.apache.shiro.mgt.SecurityManager;
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
}
