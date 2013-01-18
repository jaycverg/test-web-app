package com.catapult.contact.model;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
public class JsonResponse 
{
    private String message;
    private boolean error;
    private Object result;

    /**
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * @return the error
     */
    public boolean isError()
    {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(boolean error)
    {
        this.error = error;
    }

    /**
     * @return the result
     */
    public Object getResult()
    {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Object result)
    {
        this.result = result;
    }
}
