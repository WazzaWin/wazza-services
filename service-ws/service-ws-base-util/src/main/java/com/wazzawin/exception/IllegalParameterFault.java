package com.wazzawin.exception;

import javax.xml.ws.WebFault;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@WebFault(name = "IllegalParameterFault",
        faultBean = "com.wazzawin.exception.IllegalParameterFault")
public class IllegalParameterFault extends Exception {
    private static final long serialVersionUID = -2368791315839616994L;

    public IllegalParameterFault() {
    }

    public IllegalParameterFault(String message) {
        super(message);
    }

    public IllegalParameterFault(String message, Throwable cause) {
        super(message, cause);
    }
}
