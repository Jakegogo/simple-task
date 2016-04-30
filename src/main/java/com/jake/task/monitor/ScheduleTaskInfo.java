package com.jake.task.monitor;

import java.util.concurrent.ScheduledFuture;

import com.jake.task.scheduler.ScheduledTask;
import com.jake.task.scheduler.impl.ListenableFutureAdapter;
import com.jake.task.scheduler.impl.ReschedulingRunnable;

/**
 * 任务执行信息
 * @author jake
 */
public class ScheduleTaskInfo {

	private String id;

	private Monitorable monitorable;
	
	private ScheduledFuture scheduledFuture;
	
	private ScheduledTask task;
	
	public static ScheduleTaskInfo valueOf(ReschedulingRunnable reschedulingRunnable, ScheduledTask task) {
		ScheduleTaskInfo info = new ScheduleTaskInfo();
		info.monitorable = reschedulingRunnable;
		info.scheduledFuture = reschedulingRunnable;
		info.task = task;
		return info;
	}

	public static ScheduleTaskInfo valueOf(ListenableFutureAdapter listenableFutureAdapter, ScheduledTask task) {
		ScheduleTaskInfo info = new ScheduleTaskInfo();
		info.monitorable = listenableFutureAdapter;
		info.scheduledFuture = listenableFutureAdapter;
		info.task = task;
		return info;
	}
	
	public Monitorable getMonitorable() {
		return monitorable;
	}

	public ScheduledFuture getScheduledFuture() {
		return scheduledFuture;
	}

	public ScheduledTask getTask() {
		return task;
	}

	@Override
	public String toString() {
		return "ScheduleTaskInfo{" +
				"monitorable=" + monitorable +
				", task=" + task +
				'}';
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMonitorable(Monitorable monitorable) {
		this.monitorable = monitorable;
	}

	public void setScheduledFuture(ScheduledFuture scheduledFuture) {
		this.scheduledFuture = scheduledFuture;
	}

	public void setTask(ScheduledTask task) {
		this.task = task;
	}

	public String getId() {
		return id;
	}
}
