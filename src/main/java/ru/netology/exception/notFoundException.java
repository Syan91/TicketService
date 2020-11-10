package ru.netology.exception;

public class notFoundException extends RuntimeException {
    public notFoundException() {
    }

    public notFoundException(String message) {
        super(message);
    }

    public notFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public notFoundException(Throwable cause) {
        super(cause);
    }

    public notFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}