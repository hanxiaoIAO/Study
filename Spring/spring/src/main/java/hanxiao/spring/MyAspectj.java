package hanxiao.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect()
public class MyAspectj {
	
	@Before("execution(* hanxiao.spring.UserService*.*(..))")
	public void before() {
		System.out.println("before");
	}
}
