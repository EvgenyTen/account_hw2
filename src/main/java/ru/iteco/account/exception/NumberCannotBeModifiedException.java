package ru.iteco.account.exception;

public class NumberCannotBeModifiedException extends RuntimeException {

    public NumberCannotBeModifiedException() {
    }

    public NumberCannotBeModifiedException(String message) {
        super(message);
    }

    public NumberCannotBeModifiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberCannotBeModifiedException(Throwable cause) {
        super(cause);
    }

    public NumberCannotBeModifiedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
