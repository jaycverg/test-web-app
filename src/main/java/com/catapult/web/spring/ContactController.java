package com.catapult.web.spring;

import com.catapult.contact.component.IContactService;
import com.catapult.contact.model.Contact;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@Controller
@RequestMapping("/contact")
public class ContactController 
{
    @Autowired
    private IContactService service;
    
    @RequestMapping(method=RequestMethod.GET)
    public String viewContactForm(@ModelAttribute("contact") Contact contact)
    {
        return "contact/index";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String saveContact(@Valid Contact contact, BindingResult result)
    {
        if (result.hasErrors()) {
            return "contact/index";
        }
        
        service.create(contact);
        return "redirect:/contact?success";
    }
    
    @ModelAttribute("list")
    public List<Contact> getList()
    {
        return service.getList();
    }
}
