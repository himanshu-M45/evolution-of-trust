package org.example.Strategy;

import org.example.Enum.Move;

public class AlwaysCheat extends PlayerStrategy {
    @Override
    public Move getMove() {
        return Move.CHEAT;
    }
}