package org.itpu.exception;

public class ParameterConversionException extends RuntimeException {

    public ParameterConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterConversionException(String message) {
        super(message);
    }
}
