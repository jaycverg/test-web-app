package com.catapult.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */

/**
 * commented out the @Service because I was trying the groovy service
 * found at "Other Sources"/groovy/service/TestService.groovy
 */

//@Service
@Transactional(propagation=Propagation.REQUIRED)
public class TestService implements ITestService
{
    @Autowired
    private ITestDAO dao;
    
    @Override
    public void update()
    {
        System.out.println("=====> " + TransactionSynchronizationManager.isActualTransactionActive());
        dao.insert1();
        dao.insert2();
        dao.insert3();
    }

}
