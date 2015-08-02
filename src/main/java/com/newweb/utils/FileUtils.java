package com.newweb.utils;

import java.io.File;

/**
 * Created by Jake on 2015/8/2.
 */
public class FileUtils {

    /**
     * 获取文件最后修改时间
     * @param directory
     */
    public static long getLastModifiyTime(String directory) {

        File file = new File(directory);

        if (!file.exists()) {
            throw new IllegalArgumentException("param:0 directory 路径不存在.");
        }

        if (!file.isDirectory()) {
            throw new IllegalArgumentException("param:0 directory 参数必须为文件夹.");
        }

        return recursiveSearch(file, 0l);
    }


    private static long recursiveSearch(File file, long l) {

        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                l = recursiveSearch(f, l);
                continue;
            }
            if (f.lastModified() > l) {
                l = f.lastModified();
            }
        }

        return l;
    }

}
