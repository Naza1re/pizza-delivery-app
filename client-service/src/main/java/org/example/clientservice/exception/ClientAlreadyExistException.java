package org.example.clientservice.exception;

public class ClientAlreadyExistException extends RuntimeException {
    public ClientAlreadyExistException(String s) {
        super(s);
    }
}
