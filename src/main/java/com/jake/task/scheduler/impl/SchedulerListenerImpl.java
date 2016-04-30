package com.jake.task.scheduler.impl;

import com.jake.task.monitor.ScheduleTaskInfo;
import org.springframework.stereotype.Component;

import com.jake.task.scheduler.SchedulerListener;

/**
 * 任务执行监听实现
 * Created by jake on 2016-3-30.
 */
@Component
public class SchedulerListenerImpl implements SchedulerListener {

    @Override
    public void onStart(ScheduleTaskInfo taskInfo) {
    	System.err.println("start " + taskInfo.getTask().getName());
    }

    @Override
    public void beforeRun(ScheduleTaskInfo taskInfo) {
    	System.err.println("runing " + taskInfo.getTask().getName());
    }

    @Override
    public void onException(ScheduleTaskInfo taskInfo, RuntimeException e) {
    	System.err.println("exception " + taskInfo.getTask().getName() + " : " + e.getMessage());
    }

    @Override
    public void afterRun(ScheduleTaskInfo taskInfo) {
    	System.err.println("run over " + taskInfo.getTask().getName());
    }

    @Override
    public void onStop(ScheduleTaskInfo taskInfo) {
    	System.err.println("stop " + taskInfo.getTask().getName());
    }

    @Override
    public void onInit() {
    	System.err.println("init schedule pool success.");
    }

    @Override
    public void onDestroy() {
    	System.err.println("destroying schedule pool.");
    }
}
