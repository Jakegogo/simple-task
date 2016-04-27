package com.jake.task.scheduler;

/**
 * 抽象的定时任务
 * 提供toString()方法
 * Created by jake on 2016-3-30.
 */
public abstract class AbstractScheduledTask implements ScheduledTask {

    private final String name;
    private final String description;

    public AbstractScheduledTask() {
        name = null;
        description = null;
    }

    public AbstractScheduledTask(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "AbstractScheduledTask{" +
                "name=" + this.getName() +
                ", description=" + this.getDescription() +
                ", class=" + this.getClass().getName()
                + "}";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
