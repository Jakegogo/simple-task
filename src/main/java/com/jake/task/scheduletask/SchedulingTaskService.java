package com.jake.task.scheduletask;

import java.util.Date;
import java.util.List;

import com.jake.task.monitor.Monitorable;
import com.jake.task.scheduler.ScheduledTask;
import org.springframework.scheduling.Trigger;

/**
 * 定时器实时任务服务
 * @author jake
 */
public interface SchedulingTaskService {
	
	/**
	 * 列出所有正在执行的SchedulingRunner
	 * @return List<{@link Monitorable}>
	 */
	List<Monitorable> listMonitorable();
	
	/**
	 * 列出所有执行的任务
	 * @return List<{@link ScheduledTask}>
	 */
	List<ScheduledTask> listSchedulingTask();
	
	/**
	 * 取消执行任务
	 * @param name String
	 */
	void cancelScheduledTask(String name);

	/**
	 * 提交定时任务<br/>
	 * 执行调度会结束后关闭或可通过返回的 ScheduledFuture 取消。
	 * @param task 定时任务
	 * @param trigger 触发器
	 * @return 
	 */
	void schedule(ScheduledTask task, Trigger trigger);

	/**
	 * 提交定时任务<br/>
	 * 执行调度会结束后关闭或可通过返回的 ScheduledFuture 取消。
	 * @param task 定时任务
	 * @param startTime 任务开始时间
	 * @return 
	 */
	void schedule(ScheduledTask task, Date startTime);

	/**
	 * 提交一个按 Cron 表达式确定执行周期的任务
	 * @param task 定时任务
	 * @param cron Cron表达式
	 * @return 
	 * @throws IllegalArgumentException 当 Cron 表达式不正确时抛出
	 */
	void schedule(ScheduledTask task, String cron);

	/**
	 * 提交一个固定周期开始执行的任务<br/>
	 * 执行调度会结束后关闭或可通过返回的 ScheduledFuture 取消。
	 * @param task 定时任务
	 * @param startTime 任务开始时间
	 * @param period 连续执行之间的周期
	 * @return 
	 */
	void scheduleAtFixedRate(ScheduledTask task, Date startTime, long period);

	/**
	 * 提交一个固定周期开始执行的任务，并以最快速度开始执行他<br/>
	 * 执行调度会结束后关闭或可通过返回的 ScheduledFuture 取消。
	 * @param task 定时任务
	 * @param period 连续执行之间的周期
	 * @return  
	 */
	void scheduleAtFixedRate(ScheduledTask task, long period);

	/**
	 * 创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟。如果任务的任一执行遇到异常，
	 * 就会取消后续执行。否则，只能通过执行程序的取消或终止方法来终止该任务。
	 * @param task 要执行的任务
	 * @param startTime 开始时间
	 * @param delay 一次执行终止和下一次执行开始之间的延迟
	 * @return 
	 */
	void scheduleWithFixedDelay(ScheduledTask task, Date startTime, long delay);

	/**
	 * 创建并执行在给定延迟后启用的一次性操作。
	 * @param task 要执行的任务
	 * @param delay 从现在开始延迟执行的时间
	 * @return  
	 */
	void scheduleWithDelay(ScheduledTask task, long delay);
	
}
