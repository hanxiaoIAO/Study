package study.demo.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Example2 extends MyUtil{
	
	public static void main(String[] args) {
		InterfacePrint interfacePrint = new InterfacePrint() {

			@Override
			public void print(String str) {
				System.out.println(str);
			}
			
		};
		interfacePrint.print("匿名内部类方式重写");
		
		interfacePrint = new InterfacePrint() {

			@Override
			public void print(String str) {
				MyUtil.print_static(str);
			}
			
		};
		interfacePrint.print("匿名内部类方式重写-复用");
		
		interfacePrint = (str)-> MyUtil.print_static(str);
		interfacePrint.print("Lambda方式重写-复用");
		
		interfacePrint = MyUtil::print_static;
		interfacePrint.print("双冒号方式重写-复用");
		
		interfacePrint = (str)->MyUtil.print_static(str);
		interfacePrint.print("双冒号方式重写-复用-静态方法引用");
		
		interfacePrint = new MyUtil()::print;
		interfacePrint.print("双冒号方式重写-复用-特定对象的方法引用");
		
		interfacePrint = (str)->new MyUtil().print(str);
		interfacePrint.print("双冒号方式重写-复用-特定对象的方法引用");
		
		InterfacePrintMyUtil interfacePrintMyUtil = MyUtil::printMyUtil;
		interfacePrintMyUtil.print(new MyUtil(),"双冒号方式重写-复用-特定类的任意对象的方法引用");
		
		interfacePrintMyUtil = (myUtil,str)-> myUtil.printMyUtil(str);
		interfacePrintMyUtil.print(new MyUtil(),"双冒号方式重写-复用-特定类的任意对象的方法引用");
		
//		InterfaceBeanFactory interfaceBeanFactory = MyBean::new;
//		MyBean bean = interfaceBeanFactory.create();
//		System.out.println(bean.toString());
//		
//		InterfaceBeanFactory1 interfaceBeanFactory1 = MyBean::new;
//		MyBean bean1 = interfaceBeanFactory1.create("参数");
//		System.out.println(bean1.toString());
		
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

class MyUtil {
	
	public static void print_static(String str) {
		System.out.println(str);
	}
	
	public void print(String str) {
		System.out.println(str);
	}
	
	public void printMyUtil(String str) {
		System.out.println("printMyUtil:"+this.hashCode());
		System.out.println(str);
	}
	
}

interface InterfacePrint{
	void print(String str);
}

interface InterfacePrintMyUtil{
	void print(MyUtil myUtil,String str);
}

