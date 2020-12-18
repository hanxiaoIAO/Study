package study.demo.demo1;

import java.util.function.Function;

public class Example {
	
	public static void main(String[] args) {
//		InterfaceBeanFactory interfaceBeanFactory = new InterfaceBeanFactory() {
//
//			@Override
//			public MyBean create() {
//				return new MyBean("接口方式匿名创建");
//			}
//			
//		};
//		InterfaceBeanFactory interfaceBeanFactory = ()->{
//			return new MyBean("接口方式匿名创建");
//		};
		InterfaceBeanFactory interfaceBeanFactory = MyBean::new;
		MyBean bean = interfaceBeanFactory.create();
		System.out.println(bean.toString());
		
		InterfaceBeanFactory1 interfaceBeanFactory1 = MyBean::new;
		MyBean bean1 = interfaceBeanFactory1.create("参数");
		System.out.println(bean1.toString());
		
//		MyBean bean1 = new MyBean("继承方式匿名创建") {
//			public String toString() {
//				System.out.println(str);
//				return "已被改写";
//			}
//			
//		};
//		bean1.toString();
//		System.out.println(bean1.toString());
		
	}
}

class MyBean {
	
	String str;
	
	public MyBean() {
		System.out.println("无参构造");
	}
	
	public MyBean(String str) {
		System.out.println("有参构造");
		this.str = str;
	}
	
	public String toString() {
		return str;
	}
}

interface InterfaceBeanFactory{
	MyBean create();
}

interface InterfaceBeanFactory1{
	MyBean create(String str);
}