package hanxiao.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;
import org.apache.shiro.web.env.DefaultWebEnvironment;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

public class MyWebEnvironment extends DefaultWebEnvironment implements Initializable, Destroyable{
	
	public void init() {
		DefaultSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
		DatabaseRealm databaseRealm = new DatabaseRealm();
        defaultSecurityManager.setRealm(databaseRealm);
        
        setSecurityManager(defaultSecurityManager);
    }

}
