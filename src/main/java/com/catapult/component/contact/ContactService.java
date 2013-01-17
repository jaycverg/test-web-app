package com.catapult.component.contact;

import com.catapult.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
@Service
public class ContactService implements IContactService
{
    private static final Map<Long,Contact> contactIndex = new LinkedHashMap();

    @Override
    public Contact create(Contact contact)
    {
        contact.setId(contactIndex.size()+1L);
        contactIndex.put(contact.getId(), contact);
        return contact;
    }

    @Override
    public Contact read(Long id)
    {
        return contactIndex.get(id);
    }

    @Override
    public Contact update(Contact contact)
    {
        contactIndex.put(contact.getId(), contact);
        return contact;
    }

    @Override
    public void delete(Contact contact)
    {
        contactIndex.remove(contact.getId());
    }

    @Override
    public List<Contact> getList()
    {
        Collection<Contact> list = contactIndex.values();
        return new ArrayList(list);
    }

}
