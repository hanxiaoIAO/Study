package study.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
//@EnableAsync
public class ScheduleList {
	
	@Scheduled(fixedDelay=1000)
	@Scheduled(fixedRate=2000)
	@Async
	public void schedulePrint() throws Throwable {
		System.out.println(Thread.currentThread());
		Object obj = new Object();
		synchronized (obj) {
			obj.wait(1500);
		}
	}

}
