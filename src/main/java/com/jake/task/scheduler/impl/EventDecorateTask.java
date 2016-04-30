package com.jake.task.scheduler.impl;

import java.util.Date;

import com.jake.task.monitor.ScheduleTaskInfo;
import com.jake.task.scheduler.ScheduledTask;
import com.jake.task.scheduler.SchedulerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于做事件监听和日志记录的任务装饰类
 * @author jake
 */
public class EventDecorateTask implements ScheduledTask {
	
	static final Logger logger = LoggerFactory.getLogger(EventDecorateTask.class);

	private final ScheduledTask task;
	private final SchedulerListener schedulerListener;
	private final ScheduleTaskInfo taskInfo;

	public EventDecorateTask(ScheduledTask task, SchedulerListener schedulerListener, ScheduleTaskInfo taskInfo) {
		this.task = task;
		this.schedulerListener = schedulerListener;
		this.taskInfo = taskInfo;
	}

	public String getName() {
		return task.getName();
	}

	public void run() {
		if (logger.isDebugEnabled()) {
			logger.debug("任务[{}]开始运行时间[{}]", task.getName(), new Date());
		}
		if (schedulerListener != null) {
			schedulerListener.beforeRun(taskInfo);
		}
		try {
			task.run();
		} catch (RuntimeException e) {
			schedulerListener.onException(taskInfo, e);
			logger.error("任务[" + task.getName() + "]在执行时出现异常!", e);
			throw e;
		}
		if (schedulerListener != null) {
			schedulerListener.afterRun(taskInfo);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("任务[{}]结束运行时间[{}]", task.getName(), new Date());
		}
	}

	@Override
	public String getDescription() {
		return task.getDescription();
	}

}