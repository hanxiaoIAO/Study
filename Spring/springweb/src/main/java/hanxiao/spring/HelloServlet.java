package hanxiao.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = 8950743723459667367L;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
		// 从application作用域（ServletContext）获得spring容器
				//方式1： 手动从作用域获取
				ApplicationContext applicationContext = 
						(ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				//方式2：通过工具获取
//				ApplicationContext apppApplicationContext2 = 
//						WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

				
				AccountService acccountService = (AccountService)applicationContext.getBean("accountService");
				acccountService.transfer("jack", "rose", 1000);
	}

}
