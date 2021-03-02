package com.kpi.it01.team1.exceptions;

public class InvalidCookieException extends Exception {
    private String cookieName;

    public InvalidCookieException(String message, String cookieName) {
        super(message);
        this.cookieName = cookieName;
    }

    public InvalidCookieException(String message, String cookieName, Throwable cause) {
        super(message, cause);
        this.cookieName = cookieName;
    }

    protected InvalidCookieException() {
    }

    protected InvalidCookieException(Throwable cause) {
        super(cause);
    }

    protected InvalidCookieException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }
}
