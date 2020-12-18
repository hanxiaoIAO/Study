package study.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class MyService {
	@Bean
	public MyDao myDao() {
		return new MyDao();
	};

}
