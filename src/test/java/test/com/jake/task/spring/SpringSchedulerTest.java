package test.com.jake.task.spring;

import com.jake.task.monitor.Monitorable;
import com.jake.task.scheduler.AbstractScheduledTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jake.task.scheduler.Scheduler;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Component
public class SpringSchedulerTest {
	
	@Autowired
	@Qualifier("springScheduler")
	private Scheduler scheduler;
	
	@Test
	public void test() throws InterruptedException {
		
		scheduler.schedule("1", new AbstractScheduledTask("测试1", "SpringSchedulerTest.test()") {
			
			@Override
			public void run() {
				printMonitorable();
				scheduler.cancelScheduledTask("2");
				throw new RuntimeException("测试异常");
			}

		}, "*/5 * * * * *");
		
		scheduler.schedule("2", new AbstractScheduledTask("测试2", "SpringSchedulerTest.test()") {
			
			@Override
			public void run() {
				System.out.println(System.currentTimeMillis());
			}

		}, "*/1 * * * * *");
		
		Thread.sleep(15000);
	}

	private void printMonitorable() {
		for (Monitorable m :scheduler.listMonitorable()) {
			System.out.println(m.toString());
		}
	}

}
