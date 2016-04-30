/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jake.task.scheduler.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.jake.task.monitor.Monitorable;
import com.jake.task.scheduler.StopListenable;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.DelegatingErrorHandlingRunnable;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.util.ErrorHandler;

import com.jake.task.monitor.ScheduleHistory;

/**
 * Internal adapter that reschedules an underlying {@link Runnable} according
 * to the next execution time suggested by a given {@link Trigger}.
 *
 * <p>Necessary because a native {@link ScheduledExecutorService} supports
 * delay-driven execution only. The flexibility of the {@link Trigger} interface
 * will be translated onto a delay for the next execution time (repeatedly).
 *
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @since 3.0
 */
public class ReschedulingRunnable extends DelegatingErrorHandlingRunnable implements ScheduledFuture<Object>, Monitorable, StopListenable {

	private final Trigger trigger;

	private final SimpleTriggerContext triggerContext = new SimpleTriggerContext();

	private final ScheduledExecutorService executor;

	private ScheduledFuture<?> currentFuture;

	private Date scheduledExecutionTime;

	private final Object triggerContextMonitor = new Object();

	private StopListenable.StopListener stopListener;

	public ReschedulingRunnable(Runnable delegate, Trigger trigger, ScheduledExecutorService executor, ErrorHandler errorHandler) {
		super(delegate, errorHandler);
		this.trigger = trigger;
		this.executor = executor;
	}


	public ReschedulingRunnable schedule() {
		synchronized (this.triggerContextMonitor) {
			this.scheduledExecutionTime = this.trigger.nextExecutionTime(this.triggerContext);
			if (this.scheduledExecutionTime == null) {
				return null;
			}
			long initialDelay = this.scheduledExecutionTime.getTime() - System.currentTimeMillis();
			this.currentFuture = this.executor.schedule(this, initialDelay, TimeUnit.MILLISECONDS);
			return this;
		}
	}

	@Override
	public void run() {
		Date actualExecutionTime = new Date();
		super.run();
		Date completionTime = new Date();
		synchronized (this.triggerContextMonitor) {
			this.triggerContext.update(this.scheduledExecutionTime, actualExecutionTime, completionTime);
			if (!this.currentFuture.isCancelled()) {
				schedule();
			}
		}
	}


	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		synchronized (this.triggerContextMonitor) {
			if(this.currentFuture.cancel(mayInterruptIfRunning)) {
				this.stopListener.onStop();
				return true;
			}
			return false;
		}
	}

	@Override
	public boolean isCancelled() {
		synchronized (this.triggerContextMonitor) {
			return this.currentFuture.isCancelled();
		}
	}

	@Override
	public boolean isDone() {
		synchronized (this.triggerContextMonitor) {
			return this.currentFuture.isDone();
		}
	}

	@Override
	public Object get() throws InterruptedException, ExecutionException {
		ScheduledFuture<?> curr;
		synchronized (this.triggerContextMonitor) {
			curr = this.currentFuture;
		}
		return curr.get();
	}

	@Override
	public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		ScheduledFuture<?> curr;
		synchronized (this.triggerContextMonitor) {
			curr = this.currentFuture;
		}
		return curr.get(timeout, unit);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		ScheduledFuture<?> curr;
		synchronized (this.triggerContextMonitor) {
			curr = this.currentFuture;
		}
		return curr.getDelay(unit);
	}

	@Override
	public int compareTo(Delayed other) {
		if (this == other) {
			return 0;
		}
		long diff = getDelay(TimeUnit.MILLISECONDS) - other.getDelay(TimeUnit.MILLISECONDS);
		return (diff == 0 ? 0 : ((diff < 0)? -1 : 1));
	}


	@Override
	public boolean isActive() {
		synchronized (this.triggerContextMonitor) {
			return !this.currentFuture.isCancelled() && !this.currentFuture.isDone();
		}
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
	public void addListener(StopListener stopListener) {
		this.stopListener = stopListener;
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
