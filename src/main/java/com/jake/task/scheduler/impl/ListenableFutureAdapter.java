package com.jake.task.scheduler.impl;

import com.jake.task.monitor.Monitorable;
import com.jake.task.scheduler.StopListenable;
import com.jake.task.monitor.ScheduleHistory;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFutureTask;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 可监听的Future
 * Created by jake on 2016-3-30.
 */
public class ListenableFutureAdapter extends ListenableFutureTask implements RunnableScheduledFuture, Monitorable, StopListenable {

    private RunnableScheduledFuture runnableScheduledFuture;

    public ListenableFutureAdapter(Callable callable) {
        super(callable);
    }

    public ListenableFutureAdapter(Runnable runnable, Object result) {
        super(runnable, result);
    }

    public ListenableFutureAdapter(RunnableScheduledFuture runnableScheduledFuture) {
        super(runnableScheduledFuture, null);
        this.runnableScheduledFuture = runnableScheduledFuture;
    }

    public long getDelay(TimeUnit unit) {
        return this.runnableScheduledFuture.getDelay(unit);
    }

    @Override
    public int compareTo(Delayed other) {
        return this.runnableScheduledFuture.compareTo(other);
    }

    /**
     * Returns true if this is a periodic (not a one-shot) action.
     *
     * @return true if periodic
     */
    public boolean isPeriodic() {
        return this.runnableScheduledFuture.isPeriodic();
    }


    public boolean cancel(boolean mayInterruptIfRunning) {
        return this.runnableScheduledFuture.cancel(mayInterruptIfRunning);
    }

    /**
     * Overrides FutureTask version so as to reset/requeue if periodic.
     */
    public void run() {
        this.runnableScheduledFuture.run();
    }

    @Override
    public boolean isActive() {
        return !this.runnableScheduledFuture.isCancelled() && !this.runnableScheduledFuture.isDone();
    }

    @Override
    public boolean hasException() {
        return false;
    }

    @Override
    public List<ScheduleHistory> getHistoryList() {
        return null;
    }

    @Override
    public void addListener(final StopListener stopListener) {
        super.addCallback(new SuccessCallback() {
            @Override
            public void onSuccess(Object result) {
                stopListener.onStop();
            }
        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                stopListener.onStop();
            }
        });
    }

    @Override
    public String toString() {
        return "Monitorable{" +
                "isDone=" + isDone() +
                ", isCancelled=" + isCancelled() +
                ", isActive=" + isActive() +
                ", hasException=" + hasException()
                + "}";
    }

}
