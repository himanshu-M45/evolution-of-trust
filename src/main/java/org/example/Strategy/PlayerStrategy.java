package org.example.Strategy;

import org.example.Enum.Move;

public abstract class PlayerStrategy implements Cloneable {
    public abstract Move nextMove();
    public abstract void processOpponentMove(Move move);
    @Override
    public PlayerStrategy clone() {
        try {
            return (PlayerStrategy) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
