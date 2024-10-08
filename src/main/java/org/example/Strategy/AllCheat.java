package org.example.Strategy;

import org.example.Enum.Move;

public class AllCheat extends PlayerStrategy {
    @Override
    public Move nextMove() {
        return Move.CHEAT;
    }

    @Override
    public void processOpponentMove(Move move) {
        // No implementation needed
    }
}
