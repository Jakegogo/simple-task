package com.newweb.utils;

import org.junit.Test;

import java.util.Date;

/**
 * Created by Jake on 2015/8/2.
 */

public class TestLadtModify {

    @Test
    public void testLastModify() {
        long lastModifyTime = FileUtils.getLastModifiyTime("E:\\Project\\java\\newweb\\target");
        System.out.println(new Date(lastModifyTime));
    }


    @Test
    public void testGetWebInf() {
        System.out.println(PathUtil.getWebInfPath());
    }

}
