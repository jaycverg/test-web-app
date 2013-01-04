package groovy.service

import com.catapult.component.ITestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager
import com.catapult.component.ITestDAO

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@Service
@Transactional(propagation=Propagation.REQUIRED)
class TestService implements ITestService
{
	@Autowired
    ITestDAO dao
    
    @Override
    void update()
    {
        println "=========> invoking from groovy service"
        println "=========> " + TransactionSynchronizationManager.isActualTransactionActive()
        dao.insert1()
        dao.insert2()
        dao.insert3()
    }
}

