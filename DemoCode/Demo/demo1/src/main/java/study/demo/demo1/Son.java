package study.demo.demo1;

import java.util.Arrays;
import java.util.List;

public class Son extends Father{
	
	public void print() {
		List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
		
		//对象的超类方法语法： super::methodName 
		list.forEach(super::print);
//		list.forEach(super::print_Static);
	}

}
