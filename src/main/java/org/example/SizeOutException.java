package org.example;

public class SizeOutException extends RuntimeException {
    public SizeOutException() {
    }

    public SizeOutException(String message) {
        super(message);
    }

    public SizeOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public SizeOutException(Throwable cause) {
        super(cause);
    }

    public SizeOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
