package com.catapult.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class TestDAO implements ITestDAO
{
    @Autowired
    private JdbcTemplate jdbc;

    
    @Override
    public void insert1()
    {
        String sql = "insert into template"
                + "(id)"
                + "values(?)";
        jdbc.update(sql, 1L);
    }
    
    @Override
    public void insert2()
    {
        String sql = "insert into template"
                + "(id)"
                + "values(?)";
        jdbc.update(sql, 2L);
    }
    
    @Override
    public void insert3()
    {
        String sql = "insert into template"
                + "(id)"
                + "values(?)";
        jdbc.update(sql, 2L);
    }

}
