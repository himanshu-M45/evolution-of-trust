package org.example.Enum;

import static org.example.Enum.Move.CHEAT;
import static org.example.Enum.Move.COOPERATE;

public enum PlayerType {
    ALWAYS_COOPERATE(COOPERATE),
    ALWAYS_CHEAT(CHEAT),
    COPYCAT(CHEAT);

    private Move move;

    PlayerType(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
