package com.jake.task.scheduler;

/**
 * 定时任务接口
 * @author Jake
 */
public interface ScheduledTask extends Runnable {

	/**
	 * 获取当前任务的任务名
	 * @return
	 */
	String getName();
	
	/**
	 * 获取任务描述
	 * @return
	 */
	String getDescription();
}
