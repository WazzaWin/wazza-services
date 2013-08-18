package com.wazzawin.exception;

import javax.xml.ws.WebFault;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@WebFault(name = "ResourceNotFoundFault",
        faultBean = "com.wazzawin.exception.ResourceNotFoundFault")
public class ResourceNotFoundFault extends Exception {

    private static final long serialVersionUID = -7845458091893066318L;
    //
    private Long id;

    public ResourceNotFoundFault() {
    }

    public ResourceNotFoundFault(String msg) {
        super(msg);
    }

    public ResourceNotFoundFault(String msg, Long id) {
        super(msg);
        this.id = id;
    }

    public ResourceNotFoundFault(String message, Throwable cause) {
        super(message, cause);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
