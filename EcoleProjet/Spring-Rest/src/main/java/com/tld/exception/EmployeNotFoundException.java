package com.tld.exception;

public class EmployeNotFoundException extends
        RuntimeException {
    public EmployeNotFoundException(String message) {
        super(message);
    }
    public EmployeNotFoundException(String message,
                                    Throwable cause) {
        super(message, cause);
    }
    public EmployeNotFoundException(Throwable cause) {
        super(cause);
    }
}
