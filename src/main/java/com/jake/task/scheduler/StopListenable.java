package com.jake.task.scheduler;

/**
 * 可监听停止的
 * Created by jake on 2016-3-31.
 */
public interface StopListenable {

    /**
     * 添加监听器
     * @param stopListener StopListener
     */
    void addListener(StopListener stopListener);

    /**
     * 停止时候回调,取消/完成
     */
    interface StopListener {

        /**
         * 停止时回调
         */
        void onStop();

    }

}
