package io.github.tibetteixeira.api.v1.domain.exception;

public class ValidatorException extends RuntimeException {

    public ValidatorException() {
        super();
    }


    public ValidatorException(String message) {
        super(message);
    }
}
