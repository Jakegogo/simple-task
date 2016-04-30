package com.jake.task.scheduler;

import com.jake.task.monitor.ScheduleTaskInfo;

/**
 * 任务执行监听接口
 * Created by jake on 2016-3-30.
 */
public interface SchedulerListener {

    /**
     * 定时器开始时
     * @param taskInfo
     */
    void onStart(ScheduleTaskInfo taskInfo);

    /**
     * 调用run之前
     * @param taskInfo
     */
    void beforeRun(ScheduleTaskInfo taskInfo);

    /**
     * 出现异常
     * @param taskInfo
     * @param e
     */
    void onException(ScheduleTaskInfo taskInfo, RuntimeException e);

    /**
     * 调用run之后
     * @param taskInfo
     */
    void afterRun(ScheduleTaskInfo taskInfo);

    /**
     * 结束/取消时
     * @param taskInfo
     */
    void onStop(ScheduleTaskInfo taskInfo);

    /**
     * 初始化定时线程池
     */
    void onInit();

    /**
     * 销毁定时线程池
     */
    void onDestroy();

}
