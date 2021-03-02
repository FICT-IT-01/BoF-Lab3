package com.kpi.it01.team1.exceptions;

public class InvalidParameterException extends Exception {
    private String parameterName;

    public InvalidParameterException(String message, String cookieName) {
        super(message);
        this.parameterName = cookieName;
    }

    public InvalidParameterException(String message, String cookieName, Throwable cause) {
        super(message, cause);
        this.parameterName = cookieName;
    }

    protected InvalidParameterException() {
    }

    protected InvalidParameterException(Throwable cause) {
        super(cause);
    }

    protected InvalidParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String cookieName) {
        this.parameterName = cookieName;
    }

}
