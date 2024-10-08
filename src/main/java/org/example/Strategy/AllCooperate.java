package org.example.Strategy;

import org.example.Enum.Move;

public class AllCooperate extends PlayerStrategy {
    @Override
    public Move nextMove() {
        return Move.COOPERATE;
    }

    @Override
    public void processOpponentMove(Move move) {
        // No implementation needed
    }
}
