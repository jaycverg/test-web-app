package com.catapult.component.contact;

import com.catapult.model.Contact;
import java.util.List;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
public interface IContactService
{

    Contact create(Contact contact);

    Contact read(Long id);

    Contact update(Contact contact);

    void delete(Contact contact);
    
    List<Contact> getList();
}
