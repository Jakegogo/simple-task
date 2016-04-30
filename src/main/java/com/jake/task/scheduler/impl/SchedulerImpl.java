package com.jake.task.scheduler.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;

import com.jake.task.monitor.Monitorable;
import com.jake.task.monitor.ScheduleTaskInfo;
import com.jake.task.scheduler.ScheduledTask;
import com.jake.task.scheduler.Scheduler;
import com.jake.task.scheduler.SchedulerListener;
import com.jake.task.scheduler.StopListenable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * spring 定时器实现
 * @author jake
 *
 */
@Component("springScheduler")
public class SchedulerImpl implements Scheduler {

	@Autowired
	private TaskScheduler taskScheduler;
	@Autowired
	private SchedulerListener schedulerListener;

	/**
	 * 任务Id - 任务信息
	 */
	private ConcurrentMap<String, ScheduleTaskInfo> activeTaskInfo = new ConcurrentHashMap<String, ScheduleTaskInfo>();

	@Override
	public List<Monitorable> listMonitorable() {
		if (activeTaskInfo.isEmpty()) {
			return Collections.emptyList();
		}
		List<Monitorable> list = new ArrayList<>(activeTaskInfo.size() + 1);
		for (ScheduleTaskInfo taskInfo : activeTaskInfo.values()) {
			list.add(taskInfo.getMonitorable());
		}
		return list;
	}

	@Override
	public List<ScheduledTask> listSchedulingTask() {
		if (activeTaskInfo.isEmpty()) {
			return Collections.emptyList();
		}
		List<ScheduledTask> list = new ArrayList<>(activeTaskInfo.size() + 1);
		for (ScheduleTaskInfo taskInfo : activeTaskInfo.values()) {
			list.add(taskInfo.getTask());
		}
		return list;
	}

	@Override
	public boolean cancelScheduledTask(String id) {
		ScheduleTaskInfo taskInfo = activeTaskInfo.get(id);
		if (taskInfo == null) {return false;}
		if (taskInfo.getScheduledFuture().cancel(true)) {
			return true;
		}
		return false;
	}

	@Override
	public ScheduleTaskInfo schedule(String id, ScheduledTask task, final Trigger trigger) {
		return new ScheduleBuilder() {
			@Override
			public ScheduledFuture<?> schedule(ScheduledTask decoratedTask) {
				return taskScheduler.schedule(decoratedTask, trigger);
			}
		}.ifNotExistsPreviousSchedule(id, task);
	}

	@Override
	public ScheduleTaskInfo schedule(String id, ScheduledTask task, final Date startTime) {
		return new ScheduleBuilder() {
			@Override
			public ScheduledFuture<?> schedule(ScheduledTask decoratedTask) {
				return taskScheduler.schedule(decoratedTask, startTime);
			}
		}.ifNotExistsPreviousSchedule(id, task);
	}

	@Override
	public ScheduleTaskInfo schedule(String id, ScheduledTask task, final String cron) {
		return new ScheduleBuilder() {
			@Override
			public ScheduledFuture<?> schedule(ScheduledTask decoratedTask) {
				return taskScheduler.schedule(decoratedTask, new CronTrigger(cron));
			}
		}.ifNotExistsPreviousSchedule(id, task);
	}

	@Override
	public ScheduleTaskInfo scheduleAtFixedRate(String id, ScheduledTask task,
			final Date startTime, final long period) {
		return new ScheduleBuilder() {
			@Override
			public ScheduledFuture<?> schedule(ScheduledTask decoratedTask) {
				return taskScheduler.scheduleAtFixedRate(decoratedTask, startTime, period);
			}
		}.ifNotExistsPreviousSchedule(id, task);
	}

	@Override
	public ScheduleTaskInfo scheduleAtFixedRate(String id, ScheduledTask task,
			final long period) {
		return new ScheduleBuilder() {
			@Override
			public ScheduledFuture<?> schedule(ScheduledTask decoratedTask) {
				return taskScheduler.scheduleAtFixedRate(decoratedTask, period);
			}
		}.ifNotExistsPreviousSchedule(id, task);
	}

	@Override
	public ScheduleTaskInfo scheduleWithFixedDelay(String id, ScheduledTask task,
			final Date startTime, final long delay) {
		return new ScheduleBuilder() {
			@Override
			public ScheduledFuture<?> schedule(ScheduledTask decoratedTask) {
				return taskScheduler.scheduleWithFixedDelay(decoratedTask, startTime, delay);
			}
		}.ifNotExistsPreviousSchedule(id, task);
	}

	@Override
	public ScheduleTaskInfo scheduleWithDelay(String id, ScheduledTask task, final long delay) {
		return new ScheduleBuilder() {
			@Override
			public ScheduledFuture<?> schedule(ScheduledTask decoratedTask) {
				return taskScheduler.scheduleWithFixedDelay(decoratedTask, delay);
			}
		}.ifNotExistsPreviousSchedule(id, task);
	}
	

	abstract class ScheduleBuilder {

		public ScheduleTaskInfo ifNotExistsPreviousSchedule(final String id, ScheduledTask task) {
			final ScheduleTaskInfo taskInfo = new ScheduleTaskInfo();
			task = decorateTask(task, taskInfo);

			taskInfo.setId(id);
			taskInfo.setTask(task);
			if (activeTaskInfo.putIfAbsent(id, taskInfo) == null) {

				schedulerListener.onStart(taskInfo);

				ScheduledFuture<?> future = this.schedule(task);
				taskInfo.setMonitorable((Monitorable) future);
				taskInfo.setScheduledFuture(future);
				((StopListenable) future).addListener(new StopListenable.StopListener() {
					@Override
					public void onStop() {
						activeTaskInfo.remove(id);
						schedulerListener.onStop(taskInfo);
					}
				});
				return taskInfo;
			}
			return null;
		}

		private ScheduledTask decorateTask(ScheduledTask task, ScheduleTaskInfo taskInfo) {
			return new EventDecorateTask(task, schedulerListener, taskInfo);
		}

		public abstract ScheduledFuture<?> schedule(ScheduledTask decoratedTask);
	}

}
