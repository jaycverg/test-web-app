package com.catapult.web.spring;

import com.catapult.component.ITestService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */

@Controller
@RequestMapping("/spring")
public class TestController 
{
    private static final Logger LOGGER = Logger.getLogger(TestController.class.getName());
    
    @Autowired
    private ITestService service;
    
    
    @RequestMapping(method=RequestMethod.GET)
    public void serve(HttpServletResponse resp) throws Exception
    {        
        try {
            service.update();
            resp.getWriter().write("test spring controller");
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            resp.getWriter().write("Failed to update");
        }
    }

}
