package org.example.Strategy;

import org.example.Enum.Move;

public abstract class PlayerStrategy {
    public abstract Move getMove();
    public abstract void setMove(Move move);
}
