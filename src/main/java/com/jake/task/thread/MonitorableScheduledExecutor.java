package com.jake.task.thread;

import com.jake.task.scheduler.impl.ListenableFutureAdapter;

import java.util.concurrent.*;

/**
 * 可监控的定时器线程池
 * Created by jake on 2016-3-30.
 */
public class MonitorableScheduledExecutor extends ScheduledThreadPoolExecutor {

    public MonitorableScheduledExecutor(int corePoolSize) {
        super(corePoolSize);
    }

    public MonitorableScheduledExecutor(int corePoolSize, RejectedExecutionHandler handler) {
        super(corePoolSize, handler);
    }

    public MonitorableScheduledExecutor(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    public MonitorableScheduledExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, threadFactory, handler);
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> task) {
        return new ListenableFutureAdapter(task);
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        return new ListenableFutureAdapter(task);
    }

}
