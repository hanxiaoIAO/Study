package study.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleList1 {

	@Scheduled(fixedDelay=1000)
	public void schedulePrint() throws Throwable {
		System.out.println("ScheduleList1:"+Thread.currentThread());
		Object obj = new Object();
		synchronized (obj) {
			obj.wait(1500);
		}
	}
}
