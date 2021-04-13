package com.proinnova.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class PrintListener implements ApplicationListener<PrintEvent>{

	@Override
	@Async
	public void onApplicationEvent(PrintEvent event) {
		int a=10000;
		while(a > 0) {
			a--;
		}
		System.out.println("hello:"+Thread.currentThread());
	}

}
