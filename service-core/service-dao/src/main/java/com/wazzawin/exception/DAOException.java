package com.wazzawin.exception;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public class DAOException extends RuntimeException {

    private static final long serialVersionUID = 3760467442426848580L;
    //
    private String message;

    public DAOException() {
    }

    public DAOException(String message) {
        this.message = message;
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(Throwable e) {
        super(e);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
