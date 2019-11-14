package com.imooc.service.impl;

import com.imooc.service.StuService;
import com.imooc.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试业务层
 *
 * @author WuJunyi
 * @create 2019-11-14 17:06
 **/
public class TestTransServiceImpl implements TestTransService {

    @Autowired
    private StuService stuService;

    /**
     * 事务传播 - Propagation
     * REQUIRED:
     * SUPPORTS:
     * MANDATORY:
     * REQUIRES_NEW:
     * NOT_SUPPORTED:
     * NEVER:
     * NESTED:
     */
    //@Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans() {
        stuService.saveParent();

        stuService.saveChildren();
        // int a = 1 / 0;
    }
}
