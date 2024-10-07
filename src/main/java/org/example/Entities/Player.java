package org.example.Entities;

import org.example.Enum.Move;
import org.example.Enum.PlayerType;
import org.example.Exceptions.CannotCreatePlayerWithoutStrategy;

public class Player {
    private int score;
    private final Move move;

    public Player(PlayerType playerType) {
        if (playerType == null) {
            throw new CannotCreatePlayerWithoutStrategy("Strategy not set");
        }
        this.score = 0;
        this.move = playerType.getMove();
    }

    private void invest() {
        if (this.move == Move.CHEAT) {
            this.score += 3;
            return;
        }
        this.score += 2;
    }

    private void deduct() {
        this.score--;
    }

    public void playWith(Player anotherPlayer) {
        if (this.move == Move.COOPERATE && anotherPlayer.getMove() == Move.COOPERATE) { // if both players have cooperated
            this.invest();
            anotherPlayer.invest();
        }
        if (this.move == Move.CHEAT && anotherPlayer.getMove() == Move.COOPERATE) { // if this player has cheated and another player has cooperated
            this.invest();
            anotherPlayer.deduct();
        }
        if (this.move == Move.COOPERATE && anotherPlayer.getMove() == Move.CHEAT) { // if this player has cooperated and another player has cheated
            this.deduct();
            anotherPlayer.deduct();
        }
    }

    private Move getMove() {
        return move;
    }

    public int getScore() {
        return score;
    }
}
