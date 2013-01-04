package com.catapult.web.jsf;

import com.catapult.component.IInventoryService;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@Named
@ViewScoped
public class ItemInventoryBean 
{
    @Inject
    private IInventoryService svc;
    
    public String getMessage()
    {
        return svc.getMessage();
    }
}
