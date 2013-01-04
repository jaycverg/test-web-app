package groovy.controller

import com.catapult.component.ITestService
import java.util.logging.Level
import java.util.logging.Logger
import javax.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */

@Controller
@RequestMapping("/spring/groovy")
class TestGroovyController 
{
	@RequestMapping(method=RequestMethod.GET)
    void serve(HttpServletResponse resp) throws Exception
    {        
        resp.writer.write "hello world from groovy controller!"
    }
}

