package study.demo.test.demo1;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import study.demo.demo1.Son;


/**
 * jdk8中使用了::的用法。就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("study.demo.test.demo1")
public class Demo {
	@Test
	public void test() {
		List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
		
		//静态方法语法	ClassName::methodName
		list.forEach(Demo::print_static);
		
		list.forEach(t->Demo.print_static(t));
		
		//对象实例语法	instanceRef::methodName
		list.forEach(System.out::println);
		list.forEach(t -> System.out.println(t));
		list.forEach(new Demo()::print);
		list.forEach(t -> new Demo().print(t));
	}
	
	@Test
	public void test1() {
		new Son().print();
	}
	
	public static void print_static(String content){
		System.out.println(content);
	}
	
	public void print(String content){
		System.out.println(content);
	}
}
