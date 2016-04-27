package com.jake.task.scheduletask.impl;

import java.util.Date;
import java.util.List;

import com.jake.task.monitor.Monitorable;
import com.jake.task.scheduler.ScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.Trigger;
import org.springframework.stereotype.Component;

import com.jake.task.scheduler.Scheduler;
import com.jake.task.scheduletask.SchedulingTaskService;

/**
 * 定时器实时任务服务
 * @author jake
 */
@Component
public class SchedulingTaskServiceImpl implements SchedulingTaskService {

	@Autowired
	@Qualifier("springScheduler")
	private Scheduler scheduler;

	@Override
	public List<Monitorable> listMonitorable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduledTask> listSchedulingTask() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelScheduledTask(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void schedule(ScheduledTask task, Trigger trigger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void schedule(ScheduledTask task, Date startTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void schedule(ScheduledTask task, String cron) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scheduleAtFixedRate(ScheduledTask task, Date startTime,
			long period) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scheduleAtFixedRate(ScheduledTask task, long period) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scheduleWithFixedDelay(ScheduledTask task, Date startTime,
			long delay) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scheduleWithDelay(ScheduledTask task, long delay) {
		// TODO Auto-generated method stub

	}

}
