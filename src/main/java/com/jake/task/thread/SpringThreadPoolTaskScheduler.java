package com.jake.task.thread;

import java.util.concurrent.*;

import com.jake.task.scheduler.SchedulerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.TaskUtils;
import org.springframework.util.ErrorHandler;

import com.jake.task.scheduler.impl.ReschedulingRunnable;

/**
 * spring线程池定时器
 * @author jake
 */
public class SpringThreadPoolTaskScheduler extends ThreadPoolTaskScheduler {

	private static final long serialVersionUID = -4761251181759406014L;
	
	private volatile ErrorHandler errorHandler;
	@Autowired
	private SchedulerListener schedulerListener;
	
	@Override
	public ReschedulingRunnable schedule(Runnable task, Trigger trigger) {
		ScheduledExecutorService executor = getScheduledExecutor();
		try {
			ErrorHandler errorHandler =
					(this.errorHandler != null ? this.errorHandler : TaskUtils.getDefaultErrorHandler(true));
			return new ReschedulingRunnable(task, trigger, executor, errorHandler).schedule();
		}
		catch (RejectedExecutionException ex) {
			throw new TaskRejectedException("Executor [" + executor + "] did not accept task: " + task, ex);
		}
	}
	
	
	@Override
	protected ExecutorService initializeExecutor(ThreadFactory threadFactory,
			RejectedExecutionHandler rejectedExecutionHandler) {
		ThreadGroup group = new ThreadGroup("定时任务");
		NamedThreadFactory namedThreadFactory = new NamedThreadFactory(group, "处理");
		return super.initializeExecutor(namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
	}

	@Override
	protected ScheduledExecutorService createExecutor(
			int poolSize, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {

		return new MonitorableScheduledExecutor(poolSize, threadFactory, rejectedExecutionHandler);
	}


	/**
	 * Set a custom {@link ErrorHandler} strategy.
	 */
	public void setErrorHandler(ErrorHandler errorHandler) {
		super.setErrorHandler(errorHandler);
		this.errorHandler = errorHandler;
	}

	/**
	 * Set up the ExecutorService.
	 */
	public void initialize() {
		super.initialize();
		schedulerListener.onInit();
	}

	public void destroy() {
		schedulerListener.onDestroy();
		super.destroy();
	}
	
}
