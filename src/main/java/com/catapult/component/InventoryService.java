package com.catapult.component;

import org.springframework.stereotype.Service;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@Service
public class InventoryService implements IInventoryService
{

    @Override
    public String getMessage()
    {
        return "Message from spring component....";
    }

}
