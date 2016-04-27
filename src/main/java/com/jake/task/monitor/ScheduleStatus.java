package com.jake.task.monitor;

/**
 * 定时器状态
 * @author jake
 */
public enum ScheduleStatus {
	
	/**
	 * 初始状态
	 */
	INIT,
	
	/**
	 * 运行状态
	 */
	RUNNING,
	
	/**
	 * 取消状态
	 */
	CANCEL,
	
	/**
	 * 完成状态
	 */
	DONE,

}
