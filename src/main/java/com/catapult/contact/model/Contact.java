package com.catapult.contact.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
public class Contact
{

    private Long id;
    
    @NotEmpty
    private String name;
    private String address;
    
    @NotEmpty
    private String contactNo;

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo()
    {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo)
    {
        this.contactNo = contactNo;
    }
}
