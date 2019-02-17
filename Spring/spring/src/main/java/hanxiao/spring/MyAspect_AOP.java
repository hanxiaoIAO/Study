package hanxiao.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*•	前置通知 org.springframework.aop.MethodBeforeAdvice
•	在目标方法执行前实施增强
•	后置通知 org.springframework.aop.AfterReturningAdvice
•	在目标方法执行后实施增强
•	环绕通知 org.aopalliance.intercept.MethodInterceptor
•	在目标方法执行前后实施增强
•	异常抛出通知 org.springframework.aop.ThrowsAdvice
•	在方法抛出异常后实施增强
•	引介通知 org.springframework.aop.IntroductionInterceptor
•	在目标类中添加一些新的方法和属性*/


public class MyAspect_AOP implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		System.out.println("前");
		
		//手动执行目标方法
		Object obj = mi.proceed();
		
		System.out.println("后");
		return obj;
	}


}
