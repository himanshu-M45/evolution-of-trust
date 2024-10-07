package org.example.Exceptions;

public class CannotCreatePlayerWithoutStrategy extends RuntimeException {
    public CannotCreatePlayerWithoutStrategy(String message) {
        super(message);
    }
}
