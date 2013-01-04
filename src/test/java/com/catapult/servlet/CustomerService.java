package com.catapult.servlet;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */

@Stateless
public class CustomerService
{
    @Resource(name="jdbc/exercise1")
    private DataSource ds;
    
    public Object save(Object obj)
    {
        System.out.println("DATASOURCE is " + ds);
        return obj;
    }
}
