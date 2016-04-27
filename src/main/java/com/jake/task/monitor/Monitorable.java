package com.jake.task.monitor;

import java.util.List;

/**
 * 可监控的
 * @author jake
 */
public interface Monitorable {
	
	/**
	 * 是否为活跃的
	 * @return
	 */
	boolean isActive();
	
	/**
	 * 是否已经完成的
	 * @return
	 */
	boolean isDone();
	
	/**
	 * 是否取消
	 * @return
	 */
	boolean isCancelled();
	
	/**
	 * 是否存在异常
	 * @return
	 */
	boolean hasException();
	
	/**
	 * 获取执行历史
	 * @return
	 */
	List<ScheduleHistory> getHistoryList();

	
	
}
