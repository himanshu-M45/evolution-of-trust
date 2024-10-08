package org.example.Strategy;

import org.example.Enum.Move;

public abstract class PlayerStrategy {
    public abstract Move nextMove();
    public abstract void processOpponentMove(Move move);
}
