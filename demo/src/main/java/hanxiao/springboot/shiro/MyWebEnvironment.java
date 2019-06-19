package hanxiao.springboot.shiro;

import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;
import org.apache.shiro.web.env.DefaultWebEnvironment;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

public class MyWebEnvironment extends DefaultWebEnvironment implements Initializable, Destroyable{
	
	public void init() {
		DefaultSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
		DatabaseRealm databaseRealm = new DatabaseRealm();
        defaultSecurityManager.setRealm(databaseRealm);
        
        setSecurityManager(defaultSecurityManager);
        
        PathMatchingFilterChainResolver resolver = new PathMatchingFilterChainResolver();
        FilterChainManager manager = resolver.getFilterChainManager();
        
        Map<String, Filter> filters = manager.getFilters();
        
        FormAuthenticationFilter authc = (FormAuthenticationFilter)filters.get(DefaultFilter.authc.name());
        authc.setLoginUrl("/login.jsp");
        
        RolesAuthorizationFilter roles = (RolesAuthorizationFilter)filters.get(DefaultFilter.roles.name());
        roles.setUnauthorizedUrl("/noRoles.jsp");
        
        PermissionsAuthorizationFilter perms = (PermissionsAuthorizationFilter)filters.get(DefaultFilter.perms.name());
        perms.setUnauthorizedUrl("/noPerms.jsp");
        
        manager.addToChain("/doLogout", DefaultFilter.logout.name());
        manager.addToChain("/login.jsp", DefaultFilter.anon.name());
        manager.addToChain("/noroles.jsp", DefaultFilter.anon.name());
        manager.addToChain("/noperms.jsp", DefaultFilter.anon.name());
        manager.addToChain("/listProduct.jsp", DefaultFilter.authc.name());
        manager.addToChain("/deleteProduct.jsp", DefaultFilter.authc.name());
        manager.addToChain("/deleteProduct.jsp", DefaultFilter.roles.name(),"productManager");
        manager.addToChain("/deleteOrder.jsp", DefaultFilter.authc.name());
        manager.addToChain("/deleteOrder.jsp", DefaultFilter.perms.name(),"deleteOrder");
	
        setFilterChainResolver(resolver);
	}

}
