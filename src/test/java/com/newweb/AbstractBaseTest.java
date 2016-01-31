/**
 * Copyright (c)  by LianguangWang
 * All rights reserved
 *
 * @author:  Lianguang Wang
 * @email:   wanglianguang@139130.netData:    2010-4-27
 */
package com.newweb;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Spring junit test base class without Transaction support
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public abstract class AbstractBaseTest {
}
