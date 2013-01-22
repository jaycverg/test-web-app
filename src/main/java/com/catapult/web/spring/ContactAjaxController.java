package com.catapult.web.spring;

import com.catapult.contact.component.IContactService;
import com.catapult.contact.model.Contact;
import com.catapult.contact.model.JsonResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@Controller
@RequestMapping("/contact/ajax")
public class ContactAjaxController
{

    @Autowired
    private IContactService service;
    
    @Autowired
    private MessageSource messageSource;
    

    @RequestMapping(method=RequestMethod.GET)
    public String viewContactForm(@ModelAttribute("contact") Contact contact)
    {
        return "contact/index";
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public JsonResponse saveContact(@Valid Contact contact, BindingResult result)
    {
        JsonResponse resp = new JsonResponse();
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError err : result.getFieldErrors()) {
                if (sb.length() > 0) sb.append("<br/>");
                sb.append(messageSource.getMessage(err, null));                
            }
            resp.setMessage(sb.toString());
            resp.setError(true);
        }
        else {
            if (contact.getId() == null)
                contact = service.create(contact);
            else
                contact = service.update(contact);
            
            resp.setResult(contact);
        }
        return resp;
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ResponseBody
    public JsonResponse getContact(@PathVariable Long id)
    {
        JsonResponse resp = new JsonResponse();
        resp.setResult(service.read(id));
        return resp;
    }

    @RequestMapping("/list")
    public String viewList()
    {
        return "contact/list";
    }

    @ModelAttribute("list")
    public List<Contact> getList()
    {
        return service.getList();
    }
}
