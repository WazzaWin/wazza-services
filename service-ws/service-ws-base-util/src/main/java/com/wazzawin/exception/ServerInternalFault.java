package com.wazzawin.exception;

import javax.xml.ws.WebFault;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@WebFault(name = "ServerInternalFault",
        faultBean = "com.wazzawin.exception.ServerInternalFault")
public class ServerInternalFault extends Exception {
    private static final long serialVersionUID = -6459752762088059643L;

    public ServerInternalFault() {
    }

    public ServerInternalFault(String message) {
        super(message);
    }

    public ServerInternalFault(String message, Throwable cause) {
        super(message, cause);
    }
}
