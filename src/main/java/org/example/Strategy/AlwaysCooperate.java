package org.example.Strategy;

import org.example.Enum.Move;

public class AlwaysCooperate extends PlayerType {
    @Override
    public Move getMove() {
        return Move.COOPERATE;
    }

    @Override
    public void setMove(Move move) {
        // No implementation needed
    }
}
