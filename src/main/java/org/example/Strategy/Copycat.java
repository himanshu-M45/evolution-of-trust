package org.example.Strategy;

import org.example.Enum.Move;

public class Copycat extends PlayerStrategy {
    private Move move = Move.CHEAT; // Start with CHEAT
    @Override
    public Move getMove() {
        return move;
    }

    @Override
    public void setMove(Move move) {
        this.move = move;
    }
}
