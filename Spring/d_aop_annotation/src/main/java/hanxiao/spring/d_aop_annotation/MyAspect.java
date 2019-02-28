package hanxiao.spring.d_aop_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* hanxiao.spring.d_aop_annotation.*.*(..))")
	private void myPointCut() {
		
	}
	
	@Before("execution(* hanxiao.spring.d_aop_annotation.*.*(..))")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("前置通知： "+joinPoint.getSignature().getName());
	}
	
	@AfterReturning(pointcut="myPointCut()",returning="ret")
	public void myAfterReturning(JoinPoint joinPoint,Object ret) {
		System.out.println("后置通知 ： " + joinPoint.getSignature().getName() + " , -->" + ret);
	}

	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("前");
		//手动执行目标方法
		Object obj = joinPoint.proceed();
		
		System.out.println("后");
		return obj;
	}

	@AfterThrowing(value="myPointCut()",throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("抛出异常通知 ： " + e.getMessage());
	}
	
	@After("myPointCut()")
	public void myAfter(JoinPoint joinPoint){
		System.out.println("最终通知");
	}

}
