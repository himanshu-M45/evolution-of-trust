package org.example.Strategy;

import org.example.Enum.Move;

public class Detective extends PlayerStrategy {
    private Move lastOpponentMove;
    private int moveCount;
    private boolean opponentCheated;

    public Detective() {
        this.lastOpponentMove = Move.COOPERATE;
        this.moveCount = 0;
        this.opponentCheated = false;
    }

    @Override
    public Move nextMove() {
        if (moveCount < 4) {
            switch (moveCount) {
                case 0, 2, 3:
                    return Move.COOPERATE;
                case 1:
                    return Move.CHEAT;
            }
        }
        return opponentCheated ? lastOpponentMove : Move.CHEAT;
    }

    @Override
    public void processOpponentMove(Move move) {
        if (move == Move.CHEAT) {
            opponentCheated = true;
        }
        lastOpponentMove = move;
        moveCount++;
    }
}
