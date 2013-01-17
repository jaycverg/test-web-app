package com.catapult.web.spring;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@Controller
@RequestMapping("/pages")
public class PageController 
{
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView serve()
    {
        return new ModelAndView("page1", "message", "first message");
    }
    
    @RequestMapping(value="/page1", method=RequestMethod.GET)
    public String servePage1(Map model)
    {
        model.put("message", "method using java.util.Map as model");
        return "page1";
    }
    
    @RequestMapping(value="/page2", method=RequestMethod.GET)
    public String servePage2(ModelMap model)
    {
        model.put("message", "method using ModelMap as model");
        return "page1";
    }
    
    @RequestMapping(value = "/page3", method = RequestMethod.GET)
    public String servePage3(Model model)
    {
        model.addAttribute("message", "method using Model as model");
        return "page1";
    }
    
    @RequestMapping(value = "/page4", method = RequestMethod.GET)
    public String servePage4()
    {
        return "page1";
    }
    
    @ModelAttribute("message")
    public String getMessage()
    {
        return "message from bean using @ModelAttribute annotation";
    }
}
