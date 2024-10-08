package org.example.Strategy;

import org.example.Enum.Move;

public class Copycat extends PlayerStrategy {
    private Move move = Move.CHEAT; // Start with CHEAT
    @Override
    public Move nextMove() {
        return move;
    }

    @Override
    public void processOpponentMove(Move move) {
        this.move = move;
    }
}
