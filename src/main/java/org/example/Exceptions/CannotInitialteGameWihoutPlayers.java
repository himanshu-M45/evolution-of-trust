package org.example.Exceptions;

public class CannotInitialteGameWihoutPlayers extends RuntimeException {
    public CannotInitialteGameWihoutPlayers(String message) {
        super(message);
    }
}
